/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import client.IController;
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
		Message m = new ExitGameRequest(model.game.currentUser, model.game.gameId).toMessage();
		app.switchToLogin();
//		app.getServerAccess().sendRequest(new IController() {
//
//		@Override
//		public void process(Message request, Message response) {
//			if (response.success()) {
//				// Process response
//				
//				// Add word to history						
//			}					
//		}
//		}, m);
	}

}
