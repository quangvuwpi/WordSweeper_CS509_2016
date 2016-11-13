package client.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.model.Game;

@SuppressWarnings("serial")
public class WordHistory extends JPanel implements IBoundary {

	private Dimension size;
	private int count;
	
	final Game game;
	/**
	 * Define this method for tracking word history
	 * @param game
	 */
	public WordHistory (Game game) {
		this.game = game;
		
		this.count = 0;
		setup();
	}
	
	@Override
	/**
	 * set up word history view
	 */
	public boolean setup() {
		// TODO Auto-generated method stub
		this.size = new Dimension(122, 275);
		setLayout(null);
		setBorder(BorderFactory.createEmptyBorder());
		setPreferredSize(size);
		
		JLabel lblYourWords = new JLabel("Your Words:");
		lblYourWords.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		lblYourWords.setBounds(0, 0, 117, 17);
		add(lblYourWords);
		
		return true;
	}

	@Override
	public boolean teardown() {
		// TODO Auto-generated method stub
		removeAll();
		return true;
	}
	
	/**
	 * add word in word history
	 * @param word
	 */
	public void addWord(String word) {
		this.count++;
		JLabel temp = new JLabel(word);
		temp.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		temp.setBounds(10, 25 * count, 117, 17);
		add(temp);
		this.validate();
		this.repaint();
	}

	@Override
	/**
	 * after add new word, refresh the word history board 
	 */
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
}
