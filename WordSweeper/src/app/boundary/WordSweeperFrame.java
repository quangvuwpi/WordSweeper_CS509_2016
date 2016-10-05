package app.boundary;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.controller.BoardController;
import app.entity.Board;

@SuppressWarnings("serial")
public class WordSweeperFrame extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public WordSweeperFrame() {
		setupGUI();		
	}
	
	/**
	 * Initialize the main application GUI
	 */
	void setupGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPane);
	}
	
	/**
	 * Switch current screen to a new one
	 * 
	 * @param b the IBoundary screen to switch to
	 */
	void switchScreen(IBoundary b) {
		JPanel pane = (JPanel) getContentPane();
		
		Component c[] = pane.getComponents();
		for (int i = 0; i < c.length; i++) {
			if (c[i] instanceof IBoundary) {
				((IBoundary) c[i]).teardown();
			}
		}	
		
		pane.removeAll();
		
		pane.add((JPanel) b);
		b.setup();
		
		pane.invalidate();
		pane.repaint();		
	}
	
	public boolean switchToLogin() {
		return true;
	}
	
	public boolean switchToBoard() {
		BoardController bc = new BoardController(new Board());
		BoardPanel bp = bc.panel;
		
		bp.setBounds(new Rectangle(bp.getPreferredSize()));
		
		switchScreen(bp);
		
		return true;
	}

}
