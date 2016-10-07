/**
 * 
 */
package client.controller;

import client.model.Model;
import client.view.Application;

/**
 * @author quangvu
 *
 */
public class PracticeGameController {

	Application app;
	Model model;
	
	public PracticeGameController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	public void process() {
		app.switchToBoard();
	}
}
