/**
 * 
 */
package client.model;

/**
 * The Cell entity class; representing the state of a position on the player's board
 * Showing scores,state of the cell and if it has bonus score.
 * Also shows it's position
 * @author quangvu
 *
 */
public class Cell {

	public final Position position;

	public String letter;
	public boolean bonus = false;
	public boolean selected = false;

	public Cell(Position p) {
		this.position = p;
	}

	/**
	 * Copy the content of another Cell object
	 * 
	 * @param c
	 *            the Cell object to copy
	 */
	public void copy(Cell c) {
		if (c != null && c instanceof Cell) {
			this.letter = c.letter;
			
			this.bonus = false;
			this.selected = false;
		}
	}

}
