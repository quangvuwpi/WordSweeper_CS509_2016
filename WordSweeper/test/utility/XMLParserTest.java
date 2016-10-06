/**
 * 
 */
package utility;

import client.model.Position;
import junit.framework.TestCase;

/**
 * @author quangvu
 *
 */
public class XMLParserTest extends TestCase {

	/**
	 * Test method for {@link utility.XMLParser#parseXmlPosition(java.lang.String)}.
	 */
	public void testParseXmlPosition() {
		// null case
		String xml = null;
		assertNull(XMLParser.parseXmlPosition(xml));
		
		// empty string case
		xml = "";
		assertNull(XMLParser.parseXmlPosition(xml));
		
		// short string case
		xml = "1";
		assertNull(XMLParser.parseXmlPosition(xml));
		
		// long string case
		xml = "1234";
		assertNull(XMLParser.parseXmlPosition(xml));
		
		// malformed string case
		xml = "123";
		assertNull(XMLParser.parseXmlPosition(xml));
		xml = "a23";
		assertNull(XMLParser.parseXmlPosition(xml));
		xml = "12b";
		assertNull(XMLParser.parseXmlPosition(xml));
		xml = "a,3";
		assertNull(XMLParser.parseXmlPosition(xml));
		xml = "1,.";
		assertNull(XMLParser.parseXmlPosition(xml));
		
		// success case
		xml = "2,3";
		Position p = new Position(1,2);  // remember the offset by 1...		
		assertTrue(p.equals(XMLParser.parseXmlPosition(xml)));
	}

	/**
	 * Test method for {@link utility.XMLParser#parseXmlBoard(java.lang.String)}.
	 */
	public void testParseXmlBoard() {
		fail("Not yet implemented");
	}

}
