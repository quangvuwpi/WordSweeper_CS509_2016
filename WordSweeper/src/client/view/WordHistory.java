package client.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;

import client.model.Game;
import client.model.Word;

/**
 * Boundary class to show previously submitted words
 * 
 * @author Jarway
 *
 */
@SuppressWarnings("serial")
public class WordHistory extends JPanel implements IBoundary {

	JList<Word> list;
	DefaultListModel<Word> model;

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
		setLayout(new BorderLayout());
	    model = new DefaultListModel<Word>();
	    
	    list = new JList<Word>(model);
	    list.setFont(myFont);
	    list.setSelectionInterval(-1, -1); // not selectable
	    list.setCellRenderer(new ListCellRenderer<Word>() {
			@Override
			public Component getListCellRendererComponent(
					JList<? extends Word> list, Word value, int index,
					boolean isSelected, boolean cellHasFocus) {
				
				JTextArea area = new JTextArea(value.toString());
				area.setFont(myFont);

				return area;
			}
		});
	    
	    JScrollPane pane = new JScrollPane(list);
		Dimension d = new Dimension(148, 249);
		pane.setPreferredSize(d);
		add(pane, BorderLayout.NORTH);
		return true;
	}

	@Override
	public boolean teardown() {
		model.removeAllElements();
		removeAll();
		return true;
	}

	/**
	 * add word in word history
	 * @param word
	 */
	public void addWord(Word word) {
		model.addElement(word);
		list.ensureIndexIsVisible(model.size() - 1); // Auto scroll
	}

	@Override
	/**
	 * after add new word, refresh the word history board 
	 */
	public void refresh() {
		model.clear();
		for (Word w : game.history) {
			addWord(w);
		}
		repaint();
	}
}
