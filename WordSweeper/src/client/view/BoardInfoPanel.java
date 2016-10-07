package client.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardInfoPanel extends JPanel implements IBoundary {

	private Dimension size;
	public JLabel lbSelectedWords;
	private final WordHistory wordHistory;
	public BoardInfoPanel(WordHistory wh) {
		this.wordHistory = wh;
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
	
	public void refreshWord(String word){
		lbSelectedWords.setText(word);
		this.validate();
		this.repaint();
	}

}
