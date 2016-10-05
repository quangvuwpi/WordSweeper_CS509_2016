/**
 * 
 */
package app.entity;

/**
 * @author quangvu
 *
 */
public class Position {
	
	final int x;
	final int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int hashCode() {
		return (x << 2) + y; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Position) {			
			return x == ((Position) obj).x && 
				   y == ((Position) obj).y;
		}
		return false;
	}

}
