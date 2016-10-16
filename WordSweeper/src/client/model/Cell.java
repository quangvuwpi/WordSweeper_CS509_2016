/**
 * 
 */
package client.model;

import java.util.Random;

import utility.BoardFactory;

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

	/**
	 *  Cell to copy and random on the current cell
	 */
	public void copy(Cell c){
		this.letter = c.letter;
		this.point = c.point;
		this.multiplier = c.multiplier;
	}

}
