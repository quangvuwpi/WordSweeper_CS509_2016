/**
 * 
 */
package app.entity;

/**
 * @author quangvu
 *
 */
public class Board {
	
	public static int COL_COUNT = 4;
	public static int ROW_COUNT = 4;
	
	/**
	 * Array of cells
	 */
	protected Cell cells[][] = new Cell[ROW_COUNT][COL_COUNT];
	
	char fixed_board[][] = {{'A','B','C','D'},
							{'E','F','G','H'},
							{'I','J','K','L'},
							{'M','N','O','P'}};
	
	public Board() {
		/**
		 * Fill the board
		 */
		int mul = 0;
		for (int i = 0; i < COL_COUNT; i++) {
			for (int j = 0; j < ROW_COUNT; j++) {
				Cell c   = new Cell(new Position(i,j));
				c.letter = fixed_board[i][j];
				c.point  = 1;
				c.multiplier = mul;
				mul++;
				
				cells[i][j] = c;
			}
		}
	}
	
	public Cell getCell(Position p) {
		if (p != null) {
			return cells[p.x][p.y];
		}
		return null;
	}
	
	public boolean selectCell(Position p) {
		if (p != null && 
			(p.x >= 0 && p.x < 4) &&
			(p.y >= 0 && p.y < 4)) {
			cells[p.x][p.y].selected = true;
			
			return true;
		}
		return false;
	}

}
