package client.model;

import java.util.HashMap;

/**
 * The Game entity class; keeps track of the state of the current WordSweeper game
 * 
 * @author quangvu
 *
 */
public class Game implements IGame {
	
	/** The current game ID **/
	public String gameId = "";
	
	/** Name of the local player **/
	public String currentUser = null;
	
	/** Whether the local player is the managing user **/
	public boolean isManagingUser = false;	
	
	/** The local player's board **/
	public Board board = new Board();
	
	public HashMap<String, Player> players = new HashMap<String, Player>();
	public Word[] History;	

	public int countPlayer(Position p) {
		int num = 1;
		// for (int i = 0; i < Player.length; i++){
		// Position pplayer = Player[i].topleft;
		// if (p != null &&
		// (p.col >= pplayer.col && p.col < 4+pplayer.col) &&
		// (p.row >= pplayer.row && p.row < 4+pplayer.row)) {
		// num = num+1;
		// }
		// }
		return num;
	}

	public boolean validate(Word currentWord) {
		if (currentWord != null) {
			return true;
		}
		return false;
	}

}
