package client.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.controller.BoardController;
import client.model.Board;
import client.model.Model;

@SuppressWarnings("serial")
public class WordSweeperFrame extends JFrame {

	private JPanel contentPane;
	
	final Application app;
	final Model model;
	
	/**
	 * Create the frame.
	 */
	public WordSweeperFrame(Application app, Model model) {
		this.app = app;
		this.model = model;
		
		setupGUI();		
	}
	
	/**
	 * Initialize the main application GUI
	 */
	void setupGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 400);
		
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
		
		b.setup();
		pane.add((Component) b);
		
		pane.invalidate();
		pane.repaint();		
	}
	
	public boolean switchToLogin() {
		Login panel = new Login(app, model);
		
		switchScreen(panel);
		
		return true;
	}
	
	public boolean switchToBoard() {		
		BoardPanel bp = new BoardPanel(new Board());
		
		bp.setBounds(new Rectangle(bp.getPreferredSize()));
		
		switchScreen(bp);
		
		return true;
	}

}
