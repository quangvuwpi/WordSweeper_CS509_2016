package client.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import client.model.Game;

@SuppressWarnings("serial")
public class WordHistory extends JPanel implements IBoundary {

	JList list;
	DefaultListModel model;

	final Game game;
	Font myFont = new Font("Wawati SC", Font.PLAIN, 25);

	/**
	 * Define this method for tracking word history
	 * @param game
	 */
	public WordHistory (Game game) {
		this.game = game;
		setup();
	}

	@Override
	/**
	 * set up word history view
	 */
	public boolean setup() {
		// TODO Auto-generated method stub
		setLayout(new BorderLayout());
	    model = new DefaultListModel();
	    list = new JList(model);
	    list.setFont(myFont);
	    list.setSelectionInterval(-1, -1); // not selectable
	    JScrollPane pane = new JScrollPane(list);
		Dimension d = new Dimension(148, 249);
		pane.setPreferredSize(d);
		add(pane, BorderLayout.NORTH);
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
		model.addElement(word);
		list.ensureIndexIsVisible(model.size() - 1); // Auto scroll
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
