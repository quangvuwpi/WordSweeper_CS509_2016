/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.model.Model;
import client.view.Application;

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
		app.switchToLogin();
	}

}
