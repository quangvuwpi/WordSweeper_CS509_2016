package client.messageController;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import client.model.Board;
import client.model.Model;
import client.model.Player;
import client.model.Position;
import client.view.Application;
import client.view.WordSweeper;
import response.BoardResponse;
import response.PlayerResponse;
import utility.XMLParser;
import xml.Message;

/**
 * Tells the client whether the model is locked or not BY SOME OTHER CLIENT.
 * This will never be returned to a client to tell him that HE has the model
 * locked (that is job of LockResponse).
 * 
 * @author quangvu
 */
public class BoardResponseController extends ChainableMessageController {

	public Application app;
	public Model model;
	public WordSweeper ws;

	public BoardResponseController(Application app, Model m) {
		this.app = app;
		this.model = m;
	}

	public boolean process(Message message) {
		String type = message.contents.getFirstChild().getLocalName();
		if (!type.equals("boardResponse")) {
			return next.process(message);
		}

		System.out.println(message.toString());

		String user = model.game.currentUser;
		BoardResponse br = parseMessage(message);

		/** May become the managing user here **/
		if (br.managingUser != null) {
			model.game.isManagingUser = br.managingUser.equals(user);
		}

		/** Set game ID **/
		model.game.setGameId(br.gameId);

		/** Remove or add Players **/
		boolean add = br.playerResponseCount() > model.game.playerCount();
		if (!add) {
			/**
			 * If removing players, clear the current list; the ones who are
			 * present will be updated in the loop
			 **/
			model.game.clearPlayerList();
		}

		System.out.print("Board Message received for game:" + br.gameId + "\n ManagingUser:" + br.managingUser + "\n");
		System.out.print("Players:\n");
		while (br.hasNext()) {
			PlayerResponse pr = br.next();

			String debug = "  " + pr.name;
			if (pr.board != null) {
				debug += " " + pr.board.toString();
			} else {
				debug += " " + "null";
			}
			if (pr.position != null) {
				debug += " " + pr.position.toString();
			} else {
				debug += " " + "null";
			}
			debug += " " + pr.score + "\n";
			System.out.print(debug);

			Player player = new Player(pr.name, pr.position, pr.score);

			if (pr.board != null && player.name.equals(user)) {
				model.game.setBoard(pr.board);
				
				if (br.bonus != null) {
					int dcol = br.bonus.col - pr.position.col;
					int drow = br.bonus.row - pr.position.row;
					Position bp = new Position(dcol, drow);
					
					if (model.game.board.isValidPosition(bp)) {
						model.game.board.getCell(bp).bonus = true;
					}
				}				
			}

			model.game.updatePlayer(player);
		}

		/** Update shared area */
		model.game.countPlayers();
		app.refreshPlayerStatus();
		app.refreshBoard();
		app.refreshScores();		
		return true;
	}

	/**
	 * Summarize the board response from the server for easy process
	 * 
	 * @param m
	 *            the incoming Message
	 * @return a BoardResponse object
	 */
	BoardResponse parseMessage(Message m) {
		BoardResponse response = new BoardResponse();

		// this refers to the outer node of the Message DOM (in this case,
		// updateResponse).
		Node boardResponse = m.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();

		response.gameId = map.getNamedItem("gameId").getNodeValue();
		response.size = Integer.valueOf(map.getNamedItem("size").getNodeValue());
		response.managingUser = map.getNamedItem("managingUser").getNodeValue();

		String sbonus = map.getNamedItem("bonus").getNodeValue();
		response.bonus = XMLParser.parseXmlPosition(sbonus);

		NodeList list = boardResponse.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);

			String name = n.getAttributes().getNamedItem("name").getNodeValue();

			String position = n.getAttributes().getNamedItem("position").getNodeValue();
			Position p = XMLParser.parseXmlPosition(position);

			String board = n.getAttributes().getNamedItem("board").getNodeValue();
			Board b = XMLParser.parseXmlBoard(board);

			String score = n.getAttributes().getNamedItem("score").getNodeValue();
			long s = Long.valueOf(score);

			response.addPlayerResponse(new PlayerResponse(name, p, b, s));
		}

		return response;
	}

}
