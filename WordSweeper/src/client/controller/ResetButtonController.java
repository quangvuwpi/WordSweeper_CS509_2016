/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.model.Model;
import client.view.Application;
import request.ResetGameRequest;
import xml.Message;

/**
 * The controller for the RESET button
 *  
 * @author Jarway
 * @author quangvu
 */
public class ResetButtonController extends MouseAdapter {
	Application app;
	Model model;
	
	public ResetButtonController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Message m = new ResetGameRequest(model.game.gameId).toMessage();
		
		app.getServerAccess().sendRequest(m);
	}

}
