package client.controller;


import client.IController;
import client.messageController.BoardResponseController;
import client.view.Application;
import client.view.ILogin;
import request.CreateGameRequest;
import xml.Message;

public class CreateGameController {

	Application app;
	ILogin login;
	
	
	public CreateGameController(Application app, ILogin login) {
		this.app = app;		
		this.login = login;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		String name = login.getUserName();
		String password = login.getPassword();
		
		// send the request to create the game.
		Message m = new CreateGameRequest(name, password).toMessage();
		
		// Request the lock (this might not succeed).
		System.out.print(m.toString());
		System.out.print("\n");
		
		// Only switch to Board view on first response
		app.getServerAccess().sendRequest(new IController() {
			
			@Override
			public void process(Message request, Message response) {
				if (response.success()) {
					new BoardResponseController(app, app.model).process(response);
					app.switchToBoard();					
				}				
			}
		}, m);
	}
}
