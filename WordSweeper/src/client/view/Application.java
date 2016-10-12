/**
 * 
 */
package client.view;

import javax.swing.JFrame;

import client.ServerAccess;
import client.model.Model;

/**
 * The main application class to keep track of miscellaneous data
 * 
 * @author quangvu
 *
 */
public class Application {
	
	public final Model model;
	ServerAccess serverAccess;
	
	//public final WordSweeperFrame frame;
	JFrame current;
	
	public Application(Model model) {
		this.model = model;		
		//this.frame = new WordSweeperFrame(this, model);
	}
	
	public void start() {
		//frame.switchToLogin();
		//frame.setVisible(true);
		switchToLogin();
	}
	
	public void switchToLogin() {
		if (current != null) {
			current.setVisible(false);
			current.dispose();
		}
		
		current = new Login(this, model);
		current.setVisible(true);
	}
	
	public void switchToBoard() {
		if (current != null) {
			current.setVisible(false);
			current.dispose();
		}
		
		current = new WordSweeper(this, model);
		current.setVisible(true);
	}
	
	/** Record the means to communicate with server. */
	public void setServerAccess(ServerAccess access) {
		this.serverAccess = access;
	}
	
	/** Get the server access object. */
	public ServerAccess getServerAccess() {
		return serverAccess;
	}
}
