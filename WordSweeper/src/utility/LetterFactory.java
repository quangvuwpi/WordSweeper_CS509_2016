/**
 * 
 */
package utility;

import java.util.Random;

/**
 * @author quangvu
 *
 */
public class LetterFactory {

	/** Size of the alphabet **/
	public static int ALPHABET_SIZE = 26;

	/** PRNG **/
	Random rand = new Random(System.currentTimeMillis());
	
	/** Percentile array **/
	double percentile[] = new double[ALPHABET_SIZE];	
	
	/** Probability of each letter to appear */
	Data frequency[] = {new Data(2, 8.17),
						new Data(4, 1.49),	
						new Data(3, 2.78),
						new Data(3, 4.25),
						new Data(1, 12.70),
						new Data(4, 2.23),
						new Data(4, 2.02),
						new Data(2, 6.09),
						new Data(2, 6.97),
						new Data(7, 0.15),
						new Data(5, 0.77),
						new Data(3, 4.03),
						new Data(3, 2.41),
						new Data(2, 6.75),		
						new Data(2, 7.51),
						new Data(4, 1.93),
						new Data(8, 0.10),
						new Data(2, 5.99),
						new Data(2, 6.33),
						new Data(1, 9.06),
						new Data(3, 2.76),		
						new Data(5, 0.98),
						new Data(3, 2.36),
						new Data(7, 0.15),
						new Data(4, 1.97),	
						new Data(8, 0.07)};	

	public LetterFactory() {
		/** Initialize the percentile array **/
		percentile[0] = frequency[0].freq;
		for (int i = 1; i < ALPHABET_SIZE; i++) {
			percentile[i] = percentile[i - 1] + frequency[i].freq;
		}
	}

	/**
	 * Return the next letter according to its frequency
	 * 
	 * @return the next letter
	 */
	public String getNext() {
		/** Guaranteed to be 0.0 <= f <= 100.0 **/
		double f = rand.nextDouble() * 100.0;
		
		/** Special case **/
		if (f < percentile[0]) {
			return "A";
		}
		
		for (int i = 1; i < percentile.length; i++) {
			if (f < percentile[i] && f >= percentile[i - 1]) {
				// Q is treated weirdly...
				if (i == 16) {
					return "Qu";
				} else {
					return String.valueOf((char) ('A' + i));
				}
			}
		}
		
		/** Should never get here... **/
		return "";
	}
	
	/**
	 * Return the frequency for a given string for testing purposes
	 * 
	 * @param s
	 * @return
	 */
	public double getFrequency(String s) {		
		if (s.length() > 2) {
			return 0;
		} else if (s.length() == 2) {
			return frequency['Q' - 'A'].freq;
		}
		
		return frequency[s.charAt(0) - 'A'].freq;
	}

	/** private data tuple class **/
	private class Data {
		final int score;
		final double freq;

		public Data(int score, double freq) {
			this.score = score;
			this.freq = freq;
		}
	}

}
