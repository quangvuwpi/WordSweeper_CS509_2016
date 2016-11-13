/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.model.Board;
import client.model.Game;
import client.model.Model;
import client.model.Word;
import client.view.Application;
import client.view.WordHistory;

/**
 * The controller for the SUBMIT button
 * 
 * @author quangvu
 *
 */
public class SubmitButtonController extends MouseAdapter {
	
	Model model;
	Application app;
	WordHistory wh;
	
	public SubmitButtonController(Application app, Model model, WordHistory wh) {
		this.wh = wh;
		this.app = app;
		this.model = model;
	}
	/**
	 * Define submit controller in online game
	 * Add word to word history after submission.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		Game game = model.game;
		Board board = model.game.board;		
		Word word = board.selectionToWord();
		
		if (game.validate(word)) {
			game.addToWordHistory(word);
			wh.addWord(word.toString());
			
			// Create a submit message to send to server
//			Message m = new Message("");			
//			app.getServerAccess().sendRequest(new IController() {
//				
//				@Override
//				public void process(Message request, Message response) {
//					if (response.success()) {
//						// Process response
//						
//						// Add word to history						
//					}					
//				}
//			}, m);
		}
		
		board.clearSelection();
		app.refresh();
	}

}
