package client.model;

import junit.framework.TestCase;

public class TestBoard extends TestCase {
	
	public void testBoardstart(){
		Board b = new Board();
		
		assertTrue(b.getActive() == null);
	}
	
	
	public void testgetCell(){
		Board b = new Board();
		Position p = null;
		
		assertTrue(b.getCell(p) == null);
	}
	
	public void testselectCell(){
		Board b = new Board();
		Position p = null;
		
		assertTrue(b.selectCell(p) == false);
	}

}
