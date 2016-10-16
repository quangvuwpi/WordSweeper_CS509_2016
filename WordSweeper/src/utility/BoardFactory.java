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

	public static Board randomBoard() {
		LetterFactory cf = new LetterFactory();
		String cells[][] = new String[Board.COL_COUNT][Board.ROW_COUNT];
		
		for (int row = 0; row < Board.ROW_COUNT; row++) {
			for (int col = 0; col < Board.COL_COUNT; col++) {
				cells[col][row] = cf.getNext();
			}
		}
		
		return new Board(cells);
	}

}
