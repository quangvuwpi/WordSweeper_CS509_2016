/**
 * 
 */
package utility;

import java.util.HashMap;

import client.model.Cell;
import client.model.IGame;
import client.model.Word;
import util.WordTable;

/**
 * Calculate the score of submitted words
 * 
 * @author quangvu
 *
 */
public class ScoreCalculator {

	final IGame game;

	/** Score hash map **/
	HashMap<String, Integer> scores = new HashMap<String, Integer>();

	public ScoreCalculator(IGame game) {
		this.game = game;

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
		scores.put("QU", 11);
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
	public long getScore(Word w) {
		Cell cell;
		long temp;
		int count = 0;
		long score = 0;
		boolean bonus = false;
		
		if (w == null) {
			return 0;
		} else if (!WordTable.isWord(w.toString())) {
			return 0;
		}

		// Summing the score of every letter and multiplier
		while (w.hasNext()) {
			cell = w.next();

			if (cell.bonus) {
				bonus = true;
			}

			count += cell.letter.length();

			temp = getScore(cell.letter);
			temp = (long) (temp * Math.pow(2.0, game.countPlayer(cell.position)));
			
			score += temp;
		}

		// Multiply number of letters
		score = (long) (score * Math.pow(2.0, count) * 10);

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
		if (s != null) {
			String temp = s.toUpperCase();
			if (scores.containsKey(temp)) {
				return scores.get(temp);
			}
		}
		return 0;
	}

}
