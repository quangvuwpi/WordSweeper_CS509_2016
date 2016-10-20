/**
 * 
 */
package client.model;

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
	protected Cell cells[][] = new Cell[COL_COUNT][ROW_COUNT];
	
	/**
	 * Empty board constructor
	 */
	public Board() {
		for (int row = 0; row < ROW_COUNT; row++) {
			for (int col = 0; col < COL_COUNT; col++) {
				this.cells[col][row] = new Cell(new Position(col, row));
			}
		}
	}

	/**
	 * Initialize the board
	 * 
	 * Assuming the cells come in row-by-row
	 * 
	 * @param cells
	 *            the cells to fill the board with
	 */
	public Board(Cell cells[][]) {
		for (int row = 0; row < ROW_COUNT; row++) {
			for (int col = 0; col < COL_COUNT; col++) {
				this.cells[col][row] = cells[col][row];
			}
		}
	}

	public Cell getCell(Position p) {
		if (p != null) {
			return cells[p.col][p.row];
		}
		return null;
	}

	public void cancel() {
		for (Cell[] i : cells) {
			for (Cell j : i) {
				j.selected = false;
				j.added = false;
			}
		}
	}

	@Override
	public String toString() {
		String str = "";		
		for (int row = 0; row < ROW_COUNT; row++) {
			for (int col = 0; col < COL_COUNT; col++) {
				str += cells[col][row].letter;				
			}
		}		
		return str;
	}
	
	public void copy(Board b) {
		for (int row = 0; row < ROW_COUNT; row++) {
			for (int col = 0; col < COL_COUNT; col++) {
				Position p = new Position(col, row);
				
				cells[col][row].copy(b.getCell(p));				
			}
		}
	}

}
