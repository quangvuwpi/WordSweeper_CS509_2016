package client.view;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.model.Board;

public class BoardInfoPanel extends JPanel implements IBoundary {

	private Dimension size;
	public JLabel lbSelectedWords;
	
	final Board board;
	
	public BoardInfoPanel(Board board) {
		this.board = board;
		setup();
	}
	
	@Override
	public boolean setup() {
		// TODO Auto-generated method stub
		this.size = new Dimension(350, 100);
		setLayout(null);
		setBorder(BorderFactory.createEmptyBorder());
		setPreferredSize(size);
		
		lbSelectedWords = new JLabel("");
		lbSelectedWords.setFont(new Font("Wawati SC", Font.PLAIN, 26));
		lbSelectedWords.setBounds(0, 6, 117, 51);
		add(lbSelectedWords);
		
		JLabel lbCurrentScore = new JLabel("100");
		lbCurrentScore.setFont(new Font("Wawati SC", Font.PLAIN, 26));
		lbCurrentScore.setBounds( 130, 6, 117, 51);
		add(lbCurrentScore);

		
		return true;
	}

	@Override
	public boolean teardown() {
		// TODO Auto-generated method stub
		removeAll();
		return true;
	}

	@Override
	public void refresh() {
		lbSelectedWords.setText(board.selectionToString());
		lbSelectedWords.repaint();		
	}

}
