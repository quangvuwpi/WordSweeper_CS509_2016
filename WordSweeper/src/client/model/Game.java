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
