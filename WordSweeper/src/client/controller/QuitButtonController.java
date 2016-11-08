/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.model.Model;
import client.view.Application;
import request.ExitGameRequest;
import xml.Message;

/**
 * The controller for the QUIT button
 *  
 * @author quangvu
 *
 */
public class QuitButtonController extends MouseAdapter {
	
	Application app;
	Model model;
	
	public QuitButtonController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// Send exit game request to server
		Message m = new ExitGameRequest(model.game.currentUser, model.game.gameId).toMessage();
		app.getServerAccess().sendRequest(m);
		
		// Reset game ID
		model.game.setGameId(null);
		
		// Show login screen again
		app.switchToLogin();
	}

}
