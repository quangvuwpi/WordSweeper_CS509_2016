package client.controller;


import client.IController;
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
		 * Send the request to create the game.
		 */
		Message m = new JoinGameRequest(name, gameId, password).toMessage();
		System.out.print(m.toString() + "\n");
		
		/** Only switch to Board view on first response
		 * 
		 *  NOTE: This may not succeed	
		 */
		app.getServerAccess().sendRequest(new IController() {
			
			@Override
			public void process(Message request, Message response) {
				app.handler.process(response);
				app.switchToBoard();
			}
		}, m);
	}
}
