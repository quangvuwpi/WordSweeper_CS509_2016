/**
 * 
 */
package client.model;

/**
 * @author quangvu
 *
 */
public class Position {
	
	public final int col;
	public final int row;
	
	public Position(int col, int row) {
		this.col = col;
		this.row = row;
	}
	
	@Override
	public int hashCode() {
		return (col << 2) + row; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Position) {			
			return col == ((Position) obj).col && 
				   row == ((Position) obj).row;
		}
		return false;
	}

}
