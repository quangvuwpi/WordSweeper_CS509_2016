/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.model.Model;
import client.view.Application;

/**
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
	public void mousePressed(MouseEvent e) {
		model.game.board.clearSelection();
		app.refresh();
	}

}
