package client.model;

import java.util.HashMap;
import java.util.LinkedList;

import util.WordTable;

/**
 * The Game entity class; keeps track of the state of the current WordSweeper
 * game
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
	public final Board board = new Board();

	/** The list of all participating players in the current game **/
	public final HashMap<String, Player> players = new HashMap<String, Player>();

	/** The list of successful Word submission **/
	public final LinkedList<Word> history = new LinkedList<Word>();

	/** The table of valid words **/
	final WordTable table = new WordTable();
	
	/** The game mode to switch on the countPlayers or not **/
	public boolean offlineMode = false;
	
	/** The count of palyers shared same position **/
	public int[][] playerCounts = new int[4][4];
	
	/** Count the number of players share the same area **/
	public void countPlayers() {
		if (offlineMode) return;
		Position p = players.get(currentUser).position;		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (String player: players.keySet()){
					Position pplayer = players.get(player).position;
					if (p != null && ((p.col + i) >= pplayer.col && (p.col + i) < (4 + pplayer.col)) && ((p.row + j) >= pplayer.row && (p.row + j) < (4 + pplayer.row))) {
						playerCounts[i][j] = playerCounts[i][j] + 1;
					}
				}
			}
		}
	}
	
	public int countPlayer(Position p) {
		if (offlineMode) return 1;
		Position upleft = players.get(currentUser).position;
		return playerCounts[p.col - upleft.col][p.row - upleft.row];
	}

	public boolean validate(Word currentWord) {
		if (currentWord != null) {
			return WordTable.isWord(currentWord.toString());
		}
		return false;
	}

	/**
	 * Set Board content to given Board's content
	 * 
	 * @param board
	 *            the input Board
	 */
	public void setBoard(Board board) {
		this.board.copy(board);
	}

	/**
	 * Return how many Players in the list
	 * 
	 * @return the Player count
	 */
	public int playerCount() {
		return players.values().size();
	}

	/**
	 * Return whether the given Player is in the list
	 * 
	 * @param player
	 *            the Player
	 * @return true if player is in list; false if not
	 */
	public boolean playerExist(Player player) {
		if (player != null) {
			return players.containsKey(player.name);
		}
		return false;
	}

	/**
	 * Update an existing Player or add a new Player
	 * 
	 * @param player
	 *            the player to update
	 * @return true if player is updated; false if not
	 */
	public boolean updatePlayer(Player player) {
		if (playerExist(player)) {
			players.get(player.name).update(player);
			return true;
		} else {
			return addToPlayerList(player);
		}
	}

	/**
	 * Add a new Player to the current player list
	 * 
	 * @param player
	 *            the new Player
	 * @return true if Player was added; false if not
	 */
	public boolean addToPlayerList(Player player) {
		if (player != null) {
			if (!players.containsKey(player.name)) {
				players.put(player.name, player);

				return true;
			}
		}
		return false;
	}

	/**
	 * Remove a Player from the current list
	 * 
	 * @param player
	 *            the Player to remove
	 * @return true if player was removed; false if not
	 */
	public boolean removeFromPlayerList(Player player) {
		if (player != null) {
			if (players.containsKey(player.name)) {
				players.remove(player.name);
				return true;
			}
		}
		return false;
	}

	/**
	 * Add a Word to the history of submitted Word's
	 * 
	 * @param word
	 *            the Word to add
	 * @return true if the word was added; false if not
	 */
	public boolean addToWordHistory(Word word) {
		if (word != null) {
			return history.add(word);
		}
		return false;
	}
}
