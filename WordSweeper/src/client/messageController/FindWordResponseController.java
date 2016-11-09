/**
 * 
 */
package client.messageController;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import client.model.Model;
import client.view.Application;
import client.view.WordHistory;
import response.BoardResponse;
import response.FindWordResponse;
import xml.Message;

/**
 * Chainable message handler for FindWordResponse
 * 
 * @author quangvu
 *
 */
public class FindWordResponseController extends ChainableMessageController {
	
	Application app;
	Model model;
	
	public FindWordResponseController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}

	public boolean process(Message message) {
		String type = message.contents.getFirstChild().getLocalName();
		if (!type.equals("findWordResponse")) {
			return next.process(message);
		}
		
		FindWordResponse res = parseMessage(message);
		if (res.name != null && res.name.equals(model.game.currentUser)) {
			if (res.gameId != null && res.gameId.equals(model.game.gameId)) {				
				model.game.updateScore(model.game.getScore() + res.score);
				
				app.refresh();
			}
		}
		
		return true;
	}
	
	FindWordResponse parseMessage(Message m) {
		// this refers to the outer node of the Message DOM (in this case,
		// updateResponse).
		Node findWordRes = m.contents.getFirstChild();
		NamedNodeMap map = findWordRes.getAttributes();
		
		String name = map.getNamedItem("name").getNodeValue();
		String gameId = map.getNamedItem("gameId").getNodeValue();
		long score = Long.valueOf(map.getNamedItem("score").getNodeValue());
		
		return new FindWordResponse(gameId, name, score);
	}

}
