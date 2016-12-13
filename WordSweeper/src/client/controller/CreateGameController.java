package client.controller;


import client.IController;
import client.view.Application;
import client.view.ILogin;
import request.CreateGameRequest;
import xml.Message;

/**
 * Controller class for CreateGame request
 * 
 * @author quangvu
 *
 */
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

		/** Send the request to create the game */
		Message m = new CreateGameRequest(name, password).toMessage();
		System.out.print(m.toString());
		
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
