/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.model.Model;
import client.view.Application;
import request.LockGameRequest;
import xml.Message;

/**
 * The controller for the LOCK button
 *  
 * @author Jarway
 *
 */
public class LockButtonController extends MouseAdapter {

	Application app;
	Model model;

	public LockButtonController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Message m = new LockGameRequest(model.game.gameId).toMessage();

		app.getServerAccess().sendRequest(m);
	}
}
