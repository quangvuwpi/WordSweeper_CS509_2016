/**
 * 
 */
package utility;

import java.util.Random;

import client.model.Board;
import client.model.Cell;
import client.model.Position;

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
		
		return newBoard(cells);
	}
	
	public static Board newBoard(String letters[][]) {
		Cell cells[][] = new Cell[Board.COL_COUNT][Board.ROW_COUNT];
		
		for (int row = 0; row < Board.ROW_COUNT; row++) {
			for (int col = 0; col < Board.COL_COUNT; col++) {
				Cell c   = new Cell(new Position(col,row));
				c.letter = letters[col][row];
				
				cells[col][row] = c;
			}
		}
		
		return new Board(cells);
	}

}
