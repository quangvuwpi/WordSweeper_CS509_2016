/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.model.Model;
import client.view.Application;

/**
 * Controller class for the CANCEL button
 * 
 * @author quangvu
 *
 */
public class CancelButtonController extends MouseAdapter {
	
	Application app;
	Model model;
	
	public CancelButtonController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	@Override
	/**
	 * If hit cancel button, all previous selections are cleared. 
	 */
	public void mousePressed(MouseEvent e) {
		model.game.board.clearSelection();
		app.refresh();
	}

}
