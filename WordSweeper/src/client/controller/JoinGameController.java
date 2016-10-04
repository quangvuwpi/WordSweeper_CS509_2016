package client.controller;


import xml.Message;
import client.model.Model;
import client.view.Login;

public class JoinGameController {

	Login app;
	Model model;

	public JoinGameController(Login app, Model model) {
		this.app = app;
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to create the game.
		String xmlString = Message.requestHeader() + "<joinGameRequest gameId='"+ app.gameId.getText() +"' name='"+ app.userId.getText() +"'/></request>";
		Message m = new Message (xmlString);

		// Request the lock (this might not succeed).
		System.out.print(m.toString());
		System.out.print("\n");
		app.getServerAccess().sendRequest(m);
	}
}
