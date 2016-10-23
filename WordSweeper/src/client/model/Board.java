/**
 * 
 */
package client.model;

import java.util.LinkedList;

/**
 * The Board entity class; representing the current state of the player's board
 * 
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

	/** List of selected cells **/
	protected LinkedList<Cell> selected = new LinkedList<Cell>();

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

	/**
	 * Determine if the input position is valid
	 * 
	 * @param p
	 *            the input position
	 * @return true if valid, false if not
	 */
	public boolean isValidPosition(Position p) {
		if (p != null) {
			return ((p.col >= 0) && (p.col < COL_COUNT)) && ((p.row >= 0) && (p.row < ROW_COUNT));
		}
		return false;
	}

	/**
	 * Return the cell at the input position
	 * 
	 * @param p
	 *            the input position
	 * @return the Cell object at the given position, null if position is not
	 *         valid
	 */
	public Cell getCell(Position p) {
		if (isValidPosition(p)) {
			return cells[p.col][p.row];
		}
		return null;
	}

	/**
	 * Return whether the input position is selected
	 * 
	 * @param p
	 *            the input position
	 * @return true if the cell at the given position is selected, false if not
	 */
	public boolean isSelected(Position p) {
		Cell c = getCell(p);
		if (c != null) {
			return c.selected;
		}
		return false;
	}

	/**
	 * Select the cell at the input position
	 * 
	 * @param p
	 *            the input position
	 * @return true if the cell at the given position is selected, false if not
	 */
	public boolean selectCell(Position p) {
		Cell c = getCell(p);
		if (c != null && !c.selected) {
			c.selected = true;
			selected.addLast(c);

			return true;
		}
		return false;
	}

	/**
	 * De-select the last selected cell
	 * 
	 * @return true if the cell at the given position is de-selected, false if
	 *         not
	 */
	public boolean deselectLastCell() {
		if (!selected.isEmpty()) {
			Cell c = selected.removeLast();
			if (c != null && c.selected) {
				c.selected = false;
				return true;
			}
		}
		return false;
	}

	/**
	 * Get the last Cell selected
	 * 
	 * @return the last selected Cell
	 */
	public Cell getLastCellSelected() {
		if (!selected.isEmpty()) {
			Cell c = selected.getLast();
			if (c != null && c.selected) {
				return c;
			}
		}
		return null;
	}

	/**
	 * De-select all cells
	 */
	public void clearSelection() {
		for (int row = 0; row < ROW_COUNT; row++) {
			for (int col = 0; col < COL_COUNT; col++) {
				cells[col][row].selected = false;
				selected.clear();
			}
		}
	}

	/**
	 * Return the Word object representing all selected cells
	 * 
	 * @return the Word object
	 */
	public Word selectionToWord() {
		Word word = new Word();
		for (int i = 0; i < selected.size(); i++) {
			word.addCell(selected.get(i));
		}
		return word;
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

	/**
	 * Copy the content of another Board
	 * 
	 * @param b
	 *            the Board object to copy
	 */
	public void copy(Board b) {
		if (b != null && b instanceof Board) {
			for (int row = 0; row < ROW_COUNT; row++) {
				for (int col = 0; col < COL_COUNT; col++) {
					Position p = new Position(col, row);

					cells[col][row].copy(b.getCell(p));
				}
			}
		}
	}

}
