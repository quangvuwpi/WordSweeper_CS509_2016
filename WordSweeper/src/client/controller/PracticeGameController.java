/**
 * 
 */
package client.controller;

import client.model.Model;
import client.view.Application;
import utility.BoardFactory;

/**
 * Controller class for Practice mode request
 * 
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
	
	/**
	 * Generate random board
	 */
	public void process() {
		model.game.offlineMode = true;
		model.game.setBoard(BoardFactory.randomBoard());
		
		app.switchToPracticeBoard();
	}
}
