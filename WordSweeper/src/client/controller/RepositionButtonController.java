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
		Message m = processMouseClicked(e.getComponent().getName()).toMessage();
		System.out.println(m.toString());

		app.getServerAccess().sendRequest(m);
	}

	/**
	 * Return a repositionBoardRequest with the appropriate data filled out
	 * 
	 * @param direction
	 *            the direction to move the board
	 * @return the Message to send to server
	 */
	public RepositionBoardRequest processMouseClicked(String direction) {
		if (direction != null) {
			int dcol = 0;
			int drow = 0;

			if (direction.equals("up")) {
				drow = -1;
			} else if (direction.equals("down")) {
				drow = 1;
			} else if (direction.equals("left")) {
				dcol = -1;
			} else if (direction.equals("right")) {
				dcol = 1;
			}

			return new RepositionBoardRequest(model.game.currentUser, model.game.gameId, drow, dcol);
		}
		return null;
	}

}
