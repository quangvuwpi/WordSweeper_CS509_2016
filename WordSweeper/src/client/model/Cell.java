/**
 * 
 */
package client.model;

/**
 * @author quangvu
 *
 */
public class Cell {

	final Position p;

	public String letter;
	public int point;
	public int multiplier;

	public boolean selected = false;
	public boolean added = false;
	
	public Cell(Position p) {
		this.p = p;
	}

}
