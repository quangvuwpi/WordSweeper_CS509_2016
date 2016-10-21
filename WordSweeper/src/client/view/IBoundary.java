/**
 * 
 */
package client.view;

/**
 * Common interface for boundary classes
 * 
 * @author quangvu
 *
 */
public interface IBoundary {
	
	/**
	 * Refresh the display
	 */
	public void refresh();
	
	/**
	 * Initializing function
	 * 
	 * @return true if finished successfully; false otherwise
	 */
	public boolean setup();
	
	/**
	 * Teardown function
	 * 
	 * @return true if finished successfully; false otherwise
	 */
	public boolean teardown();

}
