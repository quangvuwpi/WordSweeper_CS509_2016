/**
 * 
 */
package response;

import java.util.Iterator;
import java.util.LinkedList;

import client.model.Position;

/**
 * This class encapsulates the board response object from the server
 * 
 * @author quangvu
 *
 */
public class BoardResponse extends Response implements Iterator<PlayerResponse> {

	public String gameId = null;
	public int size = 0;
	public String managingUser = null;
	public String content = null;
	public Position bonus = null;

	protected int current = 0;
	LinkedList<PlayerResponse> players = new LinkedList<PlayerResponse>();

	/**
	 * Return the number of player response in this board response
	 * 
	 * @return the player count
	 */
	public int playerResponseCount() {
		return players.size();
	}

	/**
	 * Add a player response to this board response
	 * 
	 * @param pr
	 *            the player response to add
	 * @return true if the player response was added; false if not
	 */
	public boolean addPlayerResponse(PlayerResponse pr) {
		return players.add(pr);
	}

	@Override
	public boolean hasNext() {
		return (current < players.size());
	}

	@Override
	public PlayerResponse next() {
		PlayerResponse pr = players.get(current);
		current++;
		
		return pr;
	}

}
