/**
 * 
 */
package client.model;

/**
 * @author quangvu
 *
 */
public class Player {
	
	public final String name;
	public Position position;
	
	public int score = 0;
	 
	public Player(String name, Position p) {
		this.name = name;
		this.position = p;
	}
}
