/**
 *  @file   TileFrequency.java
 *  @author Tony Vu
 *  @since  Apr 11, 2015
 */
package app.entity.factory;

import java.util.HashMap;
import java.util.Random;

/** The model to describe the frequency of each value and multiplier appearing in the level */
public class LetterFactory {
	
	static final int minValue = 1;
	static final int maxValue = 26;
	
	/** Probability of each value to appear in the level */
	HashMap<Integer, Double> valFreq = new HashMap<Integer, Double>();
	
	/** Random number generator */
	static Random rand = new Random();
	
	public LetterFactory() {		
		double val  = 100.0 / maxValue;      // Equal frequency for each value
		
		HashMap<Integer, Double> vhm = new HashMap<Integer, Double>();
		for (int i = minValue; i <= maxValue; i++) {
			vhm.put(i, val);
		}
		
		setValFreq(vhm);
	}
	
	public LetterFactory(HashMap<Integer, Double> valFreq, HashMap<Integer, Double> mulFreq) {
		if (!setValFreq(valFreq)) {
			throw new IllegalArgumentException("Invalid frequency setting!");
		}
	}
	
	public boolean setValFreq(HashMap<Integer, Double> valFreq) {
		double sum = 0;
		
		this.valFreq.clear();
		this.valFreq.put(0, 0.0);
		
		for (int i = minValue; i <= maxValue; i++) {
			if (valFreq.containsKey(i)) {
				sum += valFreq.get(i);
				if (sum > 100.00) {
					this.valFreq.put(i, Math.floor(sum)); // round down
				} else {
					this.valFreq.put(i, sum); // save the percentile
				}
			} else {
				break;
			}
		}
		// the total must be 100
		if (Math.floor(sum) != 100) {
			valFreq.clear();
			return false;
		}
		return true;
	}
	
	/**
	 * @param i the Tile value
	 * @return frequency of i appearing in the level
	 */
	double getValFreq(int i) {
		try {
			return valFreq.get(i);
		} catch (IndexOutOfBoundsException e) {
			return 0.0;		
		} 
	}
	
	public double getValPercent(int i) {
		return getValFreq(i) - getValFreq(i - 1);
	}
	
	/**
	 * @return the next value to appear
	 */
	int nextVal() {
		double f0, f1;
		double freq = rand.nextDouble() * 100;
		
		for (int i = minValue; i <= maxValue; i++) {
			f1 = getValFreq(i);
			f0 = getValFreq(i-1);
			if (freq > f0 && freq < f1) {
				return i;
			}
		}
		return 0;
	}
	
}

