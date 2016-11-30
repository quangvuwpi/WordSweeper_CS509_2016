/**
 * 
 */
package client.view;

import java.io.IOException;

import javax.swing.JFrame;

import client.ServerAccess;
import client.messageController.ClientMessageHandler;
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

	/** The application message handler **/
	public ClientMessageHandler handler;

	/** The library file being used **/
	public String library = null;

	/** The current frame being displayed */
	JFrame current;

	public Application(Model model) {
		this.model = model;
	}

	public Application(Model model, String library) {
		this.model = model;
		this.library = library;
	}

	/** Start the application */
	public void start() {
		try {
			if (library != null) {
				WordTable.loadWordTable(library);
			} else {
				WordTable.loadWordTable();
			}

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
	
	/** Refresh repositionable status **/
	public void refreshRepositionableStatus() {
		if (current != null && current instanceof WordSweeper) {
			WordSweeper ws = (WordSweeper) current;
			ws.refreshRepositionStatus();
		}
	}
	
	/** Refresh player status **/
	public void refreshPlayerStatus() {
		if (current != null && current instanceof WordSweeper) {
			WordSweeper ws = (WordSweeper) current;
			ws.refreshPlayerStatus();
		}
	}
	
	/** Refresh current score **/
	public void refreshCurrentScore() {
		if (current != null && current instanceof WordSweeper) {
			WordSweeper ws = (WordSweeper) current;
			ws.refreshCurrentScore();
		}
	}

	/** Refresh board panel **/
	public void refreshBoard() {
		if (current != null && current instanceof WordSweeper) {
			WordSweeper ws = (WordSweeper) current;
			ws.refreshBoard();
		}
	}
	
	/** Refresh all scores **/
	public void refreshScores() {
		if (current != null && current instanceof WordSweeper) {
			WordSweeper ws = (WordSweeper) current;			
			ws.refreshScores();
		}
	}
	
	/** Refresh word history **/
	public void refreshWordHistory() {
		if (current != null && current instanceof WordSweeper) {
			WordSweeper ws = (WordSweeper) current;			
			ws.refreshWordHistory();
		}
	}

	public void setMessageHandler(ClientMessageHandler handler) {
		this.handler = handler;
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
