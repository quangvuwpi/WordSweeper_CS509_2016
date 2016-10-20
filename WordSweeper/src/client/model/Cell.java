/**
 * 
 */
package client.model;

/**
 * @author quangvu
 *
 */
public class Cell {

	public final Position p;

	public String letter;
	public boolean bonus = false;

	public boolean selected = false;
	public boolean added = false;
	
	public Cell(Position p) {
		this.p = p;
	}

	/**
	 *  Cell to copy and random on the current cell
	 */
	public void copy(Cell c){
		this.letter = c.letter;
		this.bonus = c.bonus;
		
		this.selected = false;
		this.added = false;
	}

}
