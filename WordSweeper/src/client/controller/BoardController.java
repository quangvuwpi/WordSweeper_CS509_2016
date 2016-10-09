/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.model.Board;
import client.model.Position;
import client.view.BoardInfoPanel;
import client.view.BoardPanel;

/**
 * @author quangvu
 *
 */
public class BoardController extends MouseAdapter {
	
	public final Board board;
	public final BoardPanel panel;
	public final BoardInfoPanel infoPanel;
	public final StringBuilder sb;
	
	public BoardController(Board b, BoardPanel p, BoardInfoPanel i) {
		board = b;		
		panel = p;
		infoPanel = i;
		sb = new StringBuilder();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Position p = BoardPanel.pointToPosition(e.getPoint());
		
		if (p != null && (p.col >= 0 && p.col < 4) && (p.row >= 0 && p.row < 4)) {
			if(!board.getCell(p).selected) {
				sb.append(board.getCell(p).letter);
				board.getCell(p).selected = true;
				board.getCell(p).added = true;
			}
			else if(board.getCell(p).letter.charAt(0) == sb.charAt(sb.length() - 1)){
				sb.deleteCharAt(sb.length() - 1);
				board.getCell(p).selected = false;
				board.getCell(p).added = false;
			}
			infoPanel.refreshWord(sb.toString());
			infoPanel.invalidate();
			infoPanel.repaint();
			panel.invalidate();
			panel.repaint();
		}
		
		e.consume();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Position p = BoardPanel.pointToPosition(e.getPoint());
		
//		if (board.selectCell(p)) {
		if (p != null && (p.col >= 0 && p.col < 4) && (p.row >= 0 && p.row < 4)) {
			if(!board.getCell(p).added){
				board.getCell(p).added = true;
				sb.append(board.getCell(p).letter);
				infoPanel.refreshWord(sb.toString());
				infoPanel.invalidate();
				infoPanel.repaint();
			}
			board.getCell(p).selected = true;
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
