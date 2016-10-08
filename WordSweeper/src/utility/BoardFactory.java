/**
 * 
 */
package utility;

import java.util.Random;

import client.model.Board;

/**
 * @author quangvu
 *
 */
public class BoardFactory {

	/**
	 * WordSweeper alphabet
	 */
	public static String ALPHABET[] = { "A", "B", "C", "D", 
			                            "E", "F", "G", "H",
			                            "I", "J", "K", "L",
			                            "M", "N", "O", "P",
			                            "Q", "R", "S", "T", 
			                            "U", "V", "W", "X", 
			                            "Y", "Z", "Qu" };

	public static Board randomBoard() {
		Random rand = new Random(System.currentTimeMillis());
		String cells[][] = new String[Board.COL_COUNT][Board.ROW_COUNT];
		
		for (int col = 0; col < Board.COL_COUNT; col++) {
			for (int row = 0; row < Board.ROW_COUNT; row++) {
				cells[col][row] = BoardFactory.ALPHABET[rand.nextInt(BoardFactory.ALPHABET.length)];
			}
		}
		
		return new Board(cells);
	}

}
