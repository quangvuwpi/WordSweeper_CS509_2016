package client.controller;


import client.model.Model;
import client.view.Application;
import client.view.Login;
import external.xml.Message;

public class JoinGameController {

	Application app;
	Model model;	
	
	public JoinGameController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to create the game.
		String xmlString = Message.requestHeader() + "<joinGameRequest gameId='"+ model.game.gameId +"' name='"+ model.game.currentUser +"'/></request>";
		Message m = new Message (xmlString);

		// Request the lock (this might not succeed).
		System.out.print(m.toString());
		System.out.print("\n");
		app.getServerAccess().sendRequest(m);
	}
}
