package client.view;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.model.Game;

@SuppressWarnings("serial")
public class WordHistory extends JPanel implements IBoundary {

	private Dimension size;
	private int count;
	private Stack<JLabel> tempstack = new Stack<>();
	private Stack<JLabel> labelstack = new Stack<>();
	
	final Game game;
	
	public WordHistory (Game game) {
		this.game = game;
		
		this.count = 0;
		setup();
	}
	
	@Override
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
	
	public void addWord(String word) {
		this.count++;
		if (count <= 10) {
			JLabel temp = new JLabel(word);
			temp.setFont(new Font("Wawati SC", Font.PLAIN, 20));
			temp.setBounds(10, 25 * count, 117, 17);
			labelstack.push(temp);
			add(temp);
		} else {
			String oldword = "";
			for (int i = 0; i < 10; i++) {
				JLabel temp = labelstack.pop();
				String thisword = temp.getText();
				if(i == 0) temp.setText(word);
				else temp.setText(oldword);
				oldword = thisword;
				tempstack.push(temp);
			}
			for (int i = 0; i < 10; i++) {
				labelstack.push(tempstack.pop());
			}
		}
		this.validate();
		this.repaint();
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
}
