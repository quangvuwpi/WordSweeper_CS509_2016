package client.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import client.model.Board;
import client.model.Model;
import client.model.Player;
import client.model.Position;
import client.view.Application;
import client.view.Login;
import client.view.WordSweeper;
import utility.XMLParser;
import xml.Message;

/**
 * Tells the client whether the model is locked or not BY SOME OTHER CLIENT. This will never be returned to a client
 * to tell him that HE has the model locked (that is job of LockResponse).
 */
public class BoardResponseController {

	public Application app;
	public Model model;
	public WordSweeper ws;
	
	public BoardResponseController(Application app, Model m) {
		this.app = app;
		this.model = m;
	}
	
	public void process(Message response) {
		// this refers to the outer node of the Message DOM (in this case, updateResponse).
		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();
		String player = map.getNamedItem("managingUser").getNodeValue();
		String gameId = map.getNamedItem("gameId").getNodeValue();
		String managingUser = map.getNamedItem("managingUser").getNodeValue();
		System.out.print("Board Message received for game:" + gameId + "\n ManagingUser:" + managingUser + "\n");
		System.out.print("Players:\n");
		NodeList list = boardResponse.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
			String pname  = n.getAttributes().getNamedItem("name").getNodeValue();
			String pboard = n.getAttributes().getNamedItem("board").getNodeValue();
			String pposition = n.getAttributes().getNamedItem("position").getNodeValue();
			String pscore = n.getAttributes().getNamedItem("score").getNodeValue();
			System.out.print("  " + pname  + " " + pboard + " " + pposition + " " + pscore + "\n");
			
			Position p = XMLParser.parseXmlPosition(pposition);
			Board b = XMLParser.parseXmlBoard(pboard);
			
			model.game.Board = b;
			
			//Player player = new Player(pname, p);
		}

		// at this point, you would normally start processing this...
		System.out.print(response.toString());
		System.out.print("\n");
		
		// Update game and board
		
	}

}
