/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import client.IController;
import client.model.Model;
import client.view.Application;
import request.RepositionBoardRequest;
import xml.Message;

/**
 * The controller for the all Reposition button
 *  
 * @author Jarway
 *
 */
public class RepositionButtonController extends MouseAdapter {

	Application app;
	Model model;

	public RepositionButtonController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Message m = null;
		if (e.getComponent().getName() == "up") m = new RepositionBoardRequest(model.game.currentUser, model.game.gameId, 1, 0).toMessage();
		if (e.getComponent().getName() == "down") m = new RepositionBoardRequest(model.game.currentUser, model.game.gameId, -1, 0).toMessage();
		if (e.getComponent().getName() == "left") m = new RepositionBoardRequest(model.game.currentUser, model.game.gameId, 0, -1).toMessage();
		if (e.getComponent().getName() == "right") m = new RepositionBoardRequest(model.game.currentUser, model.game.gameId, 0, 1).toMessage();
		System.out.println(m.toString());
//		app.getServerAccess().sendRequest(new IController() {
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
