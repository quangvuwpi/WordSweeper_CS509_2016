/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.model.Cell;
import client.model.Model;
import client.model.Word;
import client.view.Application;
import client.view.WordHistory;
import utility.LetterFactory;

/**
 * @author quangvu
 *
 */
public class PracticeSubmitButtonController extends MouseAdapter {

	Application app;
	Model model;
	WordHistory history;
	
	public PracticeSubmitButtonController(Application app, Model model, WordHistory wh) {
		this.app = app;
		this.model = model;
		this.history = wh;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		LetterFactory lf = new LetterFactory();
		
		Word word = model.game.board.selectionToWord();
		history.addWord(word.toString());
		
		while (word.hasNext()) {
			Cell c = word.next();
			c.letter = lf.getNext();
		}		
		
		model.game.board.clearSelection();
		app.refresh();
	}
}
