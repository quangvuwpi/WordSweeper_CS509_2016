/**
 * 
 */
package utility;

/**
 * Debug print message utility class
 * 
 * @author quangvu
 *
 */
public class Debug {

	static boolean debug = false;

	/**
	 * Print debug print
	 * 
	 * @param message
	 *            the message to print
	 */
	public static void print(String message) {
		if (debug) {
			System.out.print(message);
		}
	}

}
