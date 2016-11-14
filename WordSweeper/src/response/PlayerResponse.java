/**
 * 
 */
package response;

import client.model.Board;
import client.model.Position;

/**
 * @author quangvu
 *
 */
public class PlayerResponse extends Response {
	
	public final String name;	
	public final Board board;
	public final long score;
	public final Position position;
	/**
	 * This is for check on player with his parameters
	 * @param name
	 * @param position
	 * @param board
	 * @param score
	 */

	public PlayerResponse(String name, Position position, Board board, long score) {
		this.name = name;		
		this.board = board;
		this.score = score;
		this.position = position;
	}
}
