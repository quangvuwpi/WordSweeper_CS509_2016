/**
 * 
 */
package utility;

import java.util.HashMap;

import junit.framework.TestCase;

/**
 * @author quangvu
 *
 */
public class LetterFactoryTest extends TestCase {

	/**
	 * Test method for {@link utility.LetterFactory#getNext()}.
	 */
	public void testGetNext() {
		LetterFactory lf = new LetterFactory();
		HashMap<String, Integer> count = new HashMap<String, Integer>();
		
		int run = 1000000;
		for (int i = 0; i < run; i++) {
			String s = lf.getNext();
			assertNotNull(s);
			
			if (count.containsKey(s)) {
				count.put(s, count.get(s) + 1);
			} else {
				count.put(s, 1);
			}
		}		
		
		String temp;
		double freq, cal_freq;
		for (int i = 0; i < LetterFactory.ALPHABET_SIZE; i++) {
			if (i != 16) {
				temp = String.valueOf((char) ('A' + i));
			} else {
				temp = "Qu";
			}
			
			freq     = lf.getFrequency(temp);
			cal_freq = count.get(temp) * 100.0 / (double) run;			
			
			assertEquals(freq, cal_freq, 0.50);
		}
	}

}
