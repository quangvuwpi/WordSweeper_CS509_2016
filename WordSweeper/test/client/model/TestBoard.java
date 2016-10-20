package client.model;

import junit.framework.TestCase;
import utility.BoardFactory;

public class TestBoard extends TestCase {
	
	public void testBoardstart(){
		Board b = BoardFactory.randomBoard();
		
		//assertTrue(b.getActive() == null);
	}
	
	
	public void testgetCell(){
		Board b = BoardFactory.randomBoard();
		Position p = null;
		
		assertTrue(b.getCell(p) == null);
	}
	
//	public void testselectCell(){
//		Board b = BoardFactory.randomBoard();
//		Position p = null;
//		
//		assertTrue(b.selectCell(p) == false);
//	}

}
