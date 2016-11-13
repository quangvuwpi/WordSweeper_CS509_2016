/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import client.model.Board;
import client.model.Cell;
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
	 * Return whether the position can be selected
	 * 
	 * The position can be selected if it is a valid position on the board AND
	 * it has to be an adjacent to the last selected Cell. If no Cell has been
	 * selected, then it can be selected.
	 * 
	 * @param p
	 *            the input position
	 * @return true if can be selected, false if not
	 */
	boolean canSelect(Position p) {
		if (p != null) {
			if (board.isValidPosition(p)) {
				Cell last = board.getLastCellSelected();
				if (last != null) {
					int deltaCol = p.col - last.position.col;
					int deltaRow = p.row - last.position.row;

					return (deltaCol >= -1 && deltaCol <= 1) && (deltaRow >= -1 && deltaRow <= 1);
				} else {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	/**
	 *  Defined a method for catching mouse click. If click right button means select.
	 */
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			board.clearSelection();

			app.refresh();
		} else {
			Position p = BoardPanel.pointToPosition(e.getPoint());

			if (canSelect(p)) {
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
	/**
	 * Define another method for drag method. CLient could do both drag or click to select character.
	 */
	public void mouseDragged(MouseEvent e) {
		Position p = BoardPanel.pointToPosition(e.getPoint());

		if (canSelect(p)) {
			board.selectCell(p);

			app.refresh();
		}

		e.consume();
	}

}
