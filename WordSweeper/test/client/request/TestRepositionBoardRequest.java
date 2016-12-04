package client.request;

import junit.framework.TestCase;
import request.RepositionBoardRequest;

/**
 * Test case of Reposition Board Request
 * 
 * @author Qihang
 *
 */

public class TestRepositionBoardRequest extends TestCase{
	
	public void testRepositionBoardRequest(){
		
		RepositionBoardRequest RBR = new RepositionBoardRequest("aaa","AAA", 1, 0);
		assertTrue(RBR.name == "aaa");
		assertTrue(RBR.gameId == "AAA");
		assertTrue(RBR.rowChange == 1);
		assertTrue(RBR.colChange == 0);
		System.out.print(RBR.toString());
		
	}

}
