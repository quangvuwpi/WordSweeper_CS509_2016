package client.controller;


import client.model.Model;
import client.view.Application;
import client.view.Login;
import external.xml.Message;
import utility.MessageFactory;

public class CreateGameController {

	Application app;
	Model model;

	public CreateGameController(Application login, Model model) {
		this.app = login;
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to create the game.
		Message m = MessageFactory.createGameRequest(model.game.currentUser);
		
		// Request the lock (this might not succeed).
		System.out.print(m.toString());
		System.out.print("\n");
		
		if (app.getServerAccess().sendRequest(m)) {
			
		} else {
			
		}
	}
}
