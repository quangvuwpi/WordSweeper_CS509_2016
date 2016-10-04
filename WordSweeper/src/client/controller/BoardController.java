/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.model.Board;
import client.model.Position;
import client.view.BoardPanel;

/**
 * @author quangvu
 *
 */
public class BoardController extends MouseAdapter {
	
	public final Board board;
	public final BoardPanel panel;
	
	public BoardController(Board b) {
		board = b;		
		panel = new BoardPanel(b, this);
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
