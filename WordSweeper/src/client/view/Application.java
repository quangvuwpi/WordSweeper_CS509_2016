/**
 * 
 */
package client.view;

import java.io.IOException;

import javax.swing.JFrame;

import client.ServerAccess;
import client.model.Model;
import util.WordTable;

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
		try {
			WordTable.loadWordTable();
			switchToLogin();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
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
		
		current = new WordSweeper(this, model, false);
		current.setVisible(true);
	}
	
	public void switchToPracticeBoard() {
		if (current != null) {
			current.setVisible(false);
			current.dispose();
		}
		
		current = new WordSweeper(this, model, true);
		current.setVisible(true);
	}
	
	public void refresh() {
		if (current != null && current instanceof WordSweeper) {
			WordSweeper ws = (WordSweeper) current;
			
			ws.refresh();
		}
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
