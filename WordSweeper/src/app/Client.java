/**
 * 
 */
package app;

import java.awt.EventQueue;

import app.boundary.WordSweeperFrame;

/**
 * @author quangvu
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WordSweeperFrame frame = new WordSweeperFrame();
					frame.setVisible(true);
					
					frame.switchToBoard();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
