/**
 * 
 */
package app.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import app.boundary.BoardPanel;
import app.entity.Board;
import app.entity.Position;

/**
 * @author quangvu
 *
 */
public class BoardController extends MouseAdapter {
	
	final Board board;
	final BoardPanel panel;
	
	public BoardController(Board board, BoardPanel panel) {
		this.board = board;
		this.panel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Position p = BoardPanel.pointToPosition(e.getPoint());
		
		if (board.selectCell(p)) {
			panel.invalidate();
			panel.repaint();
		}
		
		e.consume();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Position p = BoardPanel.pointToPosition(e.getPoint());
		
		if (board.selectCell(p)) {
			panel.invalidate();
			panel.repaint();
		}
		
		e.consume();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseReleased(e);
	}
}
