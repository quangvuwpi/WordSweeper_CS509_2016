/**
 * 
 */
package client.view;

import client.model.Model;
import external.client.ServerAccess;

/**
 * The main application class to keep track of miscellaneous data
 * 
 * @author quangvu
 *
 */
public class Application {
	
	public final Model model;
	ServerAccess serverAccess;
	
	public final WordSweeperFrame frame;
	
	public Application(Model model) {
		this.model = model;		
		this.frame = new WordSweeperFrame(this, model);
	}
	
	public void start() {
		frame.switchToLogin();
		frame.setVisible(true);
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
