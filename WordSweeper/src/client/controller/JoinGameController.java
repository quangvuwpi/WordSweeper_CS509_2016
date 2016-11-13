package client.controller;


import client.IController;
import client.messageController.BoardResponseController;
import client.view.Application;
import client.view.ILogin;
import request.JoinGameRequest;
import xml.Message;

public class JoinGameController {

	Application app;
	ILogin login;	
	
	public JoinGameController(Application app, ILogin login) {
		this.app = app;
		this.login = login;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		String name = login.getUserName();
		String gameId = login.getGameId();
		String password = login.getPassword();
		
		/**
		 * send the request to create the game.
		 */
		Message m = new JoinGameRequest(name, gameId, password).toMessage();

		/**
		 * Request the lock (this might not succeed).
		 */
		System.out.print(m.toString());
		System.out.print("\n");
		
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
