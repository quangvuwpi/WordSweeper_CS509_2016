/**
 * 
 */
package client.model;

import java.util.HashMap;

/**
 * @author quangvu
 *
 */
public class Game {
	
	public String gameId = null;
	
	public String currentUser  = null;
	public String managingUser = null;
	
	public HashMap<String, Player> players = new HashMap<String, Player>();
	
	public Game() {
		// TODO Auto-generated constructor stub
	}

}
