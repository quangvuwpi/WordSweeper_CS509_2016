package client.controller;


import xml.Message;
import Utility.MessageFactory;
import client.model.Model;
import client.view.Login;

public class CreateGameController {

	Login app;
	Model model;

	public CreateGameController(Login login, Model model) {
		this.app = login;
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to create the game.
		Message m = MessageFactory.createGameRequest(app.userId.getText());
		
		// Request the lock (this might not succeed).
		System.out.print(m.toString());
		System.out.print("\n");
		
		if (app.getServerAccess().sendRequest(m)) {
			
		} else {
			
		}
	}
}
