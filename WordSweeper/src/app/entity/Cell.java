/**
 * 
 */
package app.entity;

/**
 * @author quangvu
 *
 */
public class Cell {

	final Position p;

	public char letter;
	public int point;
	public int multiplier;

	public boolean selected = false;

	public Cell(Position p) {
		this.p = p;
	}

}
