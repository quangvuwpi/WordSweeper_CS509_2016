package client.model;

import junit.framework.TestCase;


/**
 * Test case of the Position entity class
 * 
 * @author Qihang
 *
 */

public class TestPostion extends TestCase {

	public void testposition()
	{
		Position p = new Position(4,5);
		assertEquals(4, p.col);
		assertEquals(5, p.row);
	}

}
