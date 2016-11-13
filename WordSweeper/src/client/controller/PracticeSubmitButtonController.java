/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import client.model.Board;
import client.model.Cell;
import client.model.Model;
import client.model.Position;
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
	/**
	 * Method for mouse clicking to select word to submit
	 */
	public void mouseClicked(MouseEvent e) {
		LetterFactory lf = new LetterFactory();
		
		Board board = model.game.board;
		
		Word word = board.selectionToWord();
		history.addWord(word.toString());
		
		/** Pack each column upward **/
		Position p;
		LinkedList<Cell> queue = new LinkedList<Cell>();
		for (int col = 0; col < Board.COL_COUNT; col++) {
			for (int row = 0; row < Board.ROW_COUNT; row++) {
				p = new Position(col, row); 
				if (!board.isSelected(p)) {
					queue.add(board.getCell(p));
				}
			}
			for (int row = 0; row < Board.ROW_COUNT; row++) {
				p = new Position(col, row);
				if (!queue.isEmpty()) {					
					Cell c = queue.removeFirst();					
					board.getCell(p).copy(c);
				} else {
					board.getCell(p).letter = lf.getNext();
				}
			}
		}
		
		model.game.board.clearSelection();
		app.refresh();
	}
}
