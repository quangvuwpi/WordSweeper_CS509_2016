/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import client.model.Board;
import client.model.Cell;
import client.model.Game;
import client.model.Model;
import client.model.Position;
import client.model.Word;
import client.view.Application;
import client.view.WordHistory;
import utility.LetterFactory;
import utility.ScoreCalculator;

/**
 * @author quangvu
 *
 */
public class PracticeSubmitButtonController extends MouseAdapter {

	Application app;
	Model model;
	WordHistory history;
	final ScoreCalculator sc;

	public PracticeSubmitButtonController(Application app, Model model, WordHistory wh) {
		this.app = app;
		this.model = model;
		this.history = wh;
		this.sc = new ScoreCalculator(model.game);
	}

	@Override
	/**
	 * Method for mouse clicking to select word to submit
	 */
	public void mouseClicked(MouseEvent e) {		
		Game game = model.game;
		Board board = model.game.board;
		Word word = board.selectionToWord();

		if (game.validate(word)) {
			game.addToWordHistory(word);
			game.updateScore(sc.getScore(word));

			packBoard(board);
			
			model.game.board.clearSelection();
			app.refreshCurrentScore();

			app.refreshBoard();
			app.refreshScores();
			app.refreshWordHistory();
		}
	}

	/**
	 * Remove selected cells, fill them with randomly generated letters, then
	 * pack the board upward
	 * 
	 * @param board
	 *            the board to pack
	 */
	public static void packBoard(Board board) {
		if (board != null) {
			LetterFactory lf = new LetterFactory();

			/** Pack each collumn upward **/
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
		}
	}
}
