/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import client.model.Model;
import client.view.Application;
import request.RepositionBoardRequest;
import xml.Message;

/**
 * The controller for the all Reposition button
 * 
 * @author Jarway
 * @author quangvu
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
		int dcol = 0;
		int drow = 0;

		String name = e.getComponent().getName();
		if (name.equals("up")) {
			drow = -1;
		} else if (name.equals("down")) {
			drow = 1;
		} else if (name.equals("left")) {
			dcol = -1;
		} else if (name.equals("right")) {
			dcol = 1;
		}

		Message m = new RepositionBoardRequest(model.game.currentUser, model.game.gameId, drow, dcol).toMessage();
		System.out.println(m.toString());
		
		app.getServerAccess().sendRequest(m);
	}

}
