package client.controller;


import client.model.Model;
import client.view.Application;
import external.client.IController;
import external.xml.Message;
import request.CreateGameRequest;

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
		Message m = new CreateGameRequest(model.game.currentUser).toMessage();
		
		// Request the lock (this might not succeed).
		System.out.print(m.toString());
		System.out.print("\n");
		
		// Only switch to Board view on first response
		app.getServerAccess().sendRequest(new IController() {
			
			@Override
			public void process(Message request, Message response) {
				if (response.success()) {
					app.switchToBoard();
					new BoardResponseController(app, model).process(response);
				}				
			}
		}, m);
	}
}
