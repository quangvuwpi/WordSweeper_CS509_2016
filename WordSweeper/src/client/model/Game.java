package client.model;

import java.util.HashMap;
import java.util.Iterator;

public class Game {
	public String gameId = null;
	public Board Board;
	public boolean isManagingUser = false;
	public HashMap<String, Player> players = new HashMap<String, Player>();
	public Word currentWord;
	public Word[] History;
	public String managingUser = null;
	public String currentUser = null;
	
	/** Score hash map **/
	HashMap<String, Integer> scores = new HashMap<String, Integer>();
	
	public Game() {
		/** Initialize score hash map **/
		scores.put("A", 2);
		scores.put("B", 4);
		scores.put("C", 3);
		scores.put("D", 3);
		scores.put("E", 1);
		scores.put("F", 4);
		scores.put("G", 4);
		scores.put("H", 2);		
		scores.put("I", 2);
		scores.put("J", 7);
		scores.put("K", 5);
		scores.put("L", 3);
		scores.put("M", 3);
		scores.put("N", 2);
		scores.put("O", 2);
		scores.put("P", 4);		
		scores.put("Q", 8);
		scores.put("R", 2);
		scores.put("S", 2);
		scores.put("T", 1);
		scores.put("U", 3);
		scores.put("V", 5);
		scores.put("W", 3);
		scores.put("X", 7);		
		scores.put("Y", 4);
		scores.put("Z", 8);
		scores.put("Qu", 11);			
	}

	public int countPlayer(Position p) {
		int num = 0;
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

	/**
	 * Calculate the score of a word
	 * 
	 * Score formula: score = 2^N * 10 * sum(letters score * 2^M)
	 * 
	 * N = # of letters; M = # of players sharing that letter
	 * 
	 * NOTE: Qu counts as 2 letters and has score of 11
	 * 
	 * @param currentWord
	 *            the word to calculate
	 * @return score of word
	 */
	public int calculateScore(Word currentWord) {
		if (!validate(currentWord)) {
			return 0;
		}

		Cell cell;
		int temp;
		int count = 0;
		int score = 0;
		boolean bonus = false;
		
		// Summing the score of every letter and multiplier
		Iterator<Cell> ic = currentWord.cell.iterator();
		while (ic.hasNext()) {
			cell = ic.next();
			
			if (cell.bonus) {
				bonus = true;
			}
			
			count += cell.letter.length();
			
			temp = getScore(cell.letter);						
			temp = temp * (2 ^ countPlayer(cell.p));
			
			score += temp;
		}
		
		// Multiply number of letters
		score = score * (2 ^ count) * 10;

		// Bonus x10 multiplier
		if (bonus) {
			score = score * 10;
		}
		
		return score;
	}
	
	/**
	 * Return the score of the input string/letter
	 * 
	 * @param s
	 * @return
	 */
	public int getScore(String s) {
		if (scores.containsKey(s)) {
			return scores.get(s);
		}
		return 0;
	}

	Game active = null;

	public Game getActive() {
		return active;
	}

}
