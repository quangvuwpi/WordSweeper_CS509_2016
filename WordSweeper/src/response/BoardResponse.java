/**
 * 
 */
package response;

import java.util.Iterator;
import java.util.LinkedList;

import client.model.Position;

/**
 * @author quangvu
 *
 */
public class BoardResponse extends Response implements Iterator<PlayerResponse> {
	
	public String gameId = null;
	public int    size = 0;
	public String managingUser = null;
	public String content = null;
	public Position bonus = null;
	/**
	 * This is for checking board response 
	 */
	protected int current = 0;
	LinkedList<PlayerResponse> players = new LinkedList<PlayerResponse>();

	public boolean add(PlayerResponse pr) {
		return players.add(pr);
	}
	
	@Override
	/**
	 * check if has next player
	 */
	public boolean hasNext() {
		return (current < players.size());
	}

	@Override
	/**
	 * receive response for last request
	 */
	public PlayerResponse next() {
		current++;
		return players.listIterator().next();
	}
	
	public void reset() {
		current = 0;
	}

}
