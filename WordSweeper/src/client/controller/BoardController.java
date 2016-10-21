/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.model.Board;
import client.model.Cell;
import client.model.Position;
import client.model.Word;
import client.view.Application;
import client.view.BoardInfoPanel;
import client.view.BoardPanel;

/**
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

	@Override
	public void mouseClicked(MouseEvent e) {
		Position p = BoardPanel.pointToPosition(e.getPoint());

		if (board.isValidPosition(p)) {
			if (!board.isSelected(p)) {
				board.selectCell(p);
			} else {
				board.deselectLastCell();
			}
			
			app.refresh();
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

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseReleased(e);
	}
}
