/**
 * 
 */
package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import client.model.Board;
import client.model.Position;

/**
 * Utility class to parse XML strings
 * 
 * @author quangvu
 *
 */
public class XMLParser {

	/**
	 * Parse an XML string and return a Position
	 * 
	 * @param xml
	 *            the XML string
	 * @return the new Position, or null if string is invalid
	 */
	public static Position parseXmlPosition(String xml) {
		if (xml != null && xml.length() == 3) {
			String regex = "(\\d),(\\d)";
			Matcher m = Pattern.compile(regex).matcher(xml);

			if (m.matches()) {
				int col = Integer.valueOf(m.group(1)) - 1; // Position is offset
															// by 1
				int row = Integer.valueOf(m.group(2)) - 1; // Position is offset
															// by 1

				return new Position(col, row);
			}
		}
		return null;
	}

	/**
	 * Parse an XML string and return a Board
	 * 
	 * @param xml
	 *            the XML string
	 * @return the new Board, or null if string is invalid
	 */
	public static Board parseXmlBoard(String xml) {
		if (xml != null && xml.length() >= 16) {
			String regex = "([A-Z]|Qu){16}";
			Matcher m = Pattern.compile(regex).matcher(xml);

			if (m.matches()) {
				// How to give string to Board???
				return new Board();
			}
		}
		return null;
	}

}
