package client.model;

import java.util.HashMap;

public class Game {
	public String gameId = null;	
	public boolean isManagingUser = false;
	public HashMap<String, Player> players = new HashMap<String, Player>();
	public Word currentWord;
	public Word[] History;
	public String managingUser = null;
	public String currentUser = null;
	
	public Board board = new Board();

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

	Game active = null;

	public Game getActive() {
		return active;
	}

}
