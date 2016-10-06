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
			String regex = "[A-Z]*(Qu)*[A-Z]*";
			Matcher m = Pattern.compile(regex).matcher(xml);

			if (m.matches()) {
				// If XML length is greater than 16, there has to be a Qu
				// somewhere
				
				
				Matcher p = Pattern.compile("[A-Z]*Qu[A-Z]*").matcher(xml);
				System.out.println(p.groupCount());
				for (int i = 0; i < p.groupCount(); i++) {
					System.out.println(p.group(i));
				}
				
				if (xml.length() == 16 || (xml.length() > 16 && m.groupCount() >= 2)) {
					return new Board();
				}
			}
		}
		return null;
	}

}
