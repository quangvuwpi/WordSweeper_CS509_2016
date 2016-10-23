/**
 * 
 */
package client.model;

/**
 * Interface of the Game object; separated to easily create test cases
 * 
 * @author quangvu
 *
 */
public interface IGame {
	
	/**
	 * Get the number of remote players sharing this position
	 * 
	 * @param p  The given position
	 * @return the number of remote players sharing the position
	 */
	public int countPlayer(Position p);

}
