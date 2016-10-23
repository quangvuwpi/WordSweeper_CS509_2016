/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import client.model.Board;
import client.model.Position;
import client.view.Application;
import client.view.BoardPanel;

/**
 * The controller class for the Board object
 * 
 * @author quangvu
 *
 */
public class BoardController extends MouseAdapter {

	public final Board board;
	public final Application app;

	public BoardController(Application app, Board b) {
		this.board = b;
		this.app = app;
	}

	/**
	 * Left click on un-selected Cell -> select Cell
	 * Left click on selected Cell    -> de-select last selected Cell
	 * Right click                    -> clear all Cell selection
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			board.clearSelection();
			
			app.refresh();
		} else {
			Position p = BoardPanel.pointToPosition(e.getPoint());

			if (board.isValidPosition(p)) {
				if (!board.isSelected(p)) {
					board.selectCell(p);
				} else {
					board.deselectLastCell();
				}

				app.refresh();
			}
		}

		e.consume();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Position p = BoardPanel.pointToPosition(e.getPoint());

		if (board.isValidPosition(p)) {
			board.selectCell(p);

			app.refresh();
		}

		e.consume();
	}

}
