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
				int col = Integer.valueOf(m.group(1)) - 1; // Position is offset by 1
				int row = Integer.valueOf(m.group(2)) - 1; // Position is offset by 1

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
			// Have to preprocess since board can have commas between the characters
			String xmlUp = xml.toUpperCase();
			String xml2  = xmlUp.replaceAll(",| ", "");
			
			String regex = "([A-Z]|QU){16}";
			Matcher m = Pattern.compile(regex).matcher(xml2);

			if (m.matches()) {
				String array[][] = new String[Board.COL_COUNT][Board.ROW_COUNT];
				
				int i = 0;
				int col = 0;
				int row = 0;				
				while (i < xml2.length()) {
					if (xml2.charAt(i) != 'Q') {  // Not QU, but might be Q
						array[col][row] = String.valueOf(xml2.charAt(i));
						i++;
					} else if (i < (xml2.length() - 1) && xml2.charAt(i+1) == 'U') {  // QU
						char qu[] = {xml2.charAt(i), Character.toLowerCase(xml2.charAt(i+1))};
						array[col][row] = String.valueOf(qu);
						i += 2;
					} else {  // Q
						array[col][row] = String.valueOf(xml2.charAt(i));
						i++;
					}
					
					if (col < Board.COL_COUNT - 1) {
						col++;
					} else {
						col = 0;
						row++;
					}										
				}
				
				return BoardFactory.newBoard(array);
			}
		}
		return null;
	}

}
