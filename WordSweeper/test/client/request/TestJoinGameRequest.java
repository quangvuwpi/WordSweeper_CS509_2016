package client.request;

import junit.framework.TestCase;
import request.JoinGameRequest;

/**
 * Test case of Join Game Request
 * 
 * @author Qihang
 *
 */

public class TestJoinGameRequest extends TestCase{
	
	public void testJoinGameRequest(){
		
		JoinGameRequest JGR1 = new JoinGameRequest("aaa","AAA","123");
		
		System.out.print(JGR1.toString());
		
		assertTrue(JGR1.name == "aaa");
		assertTrue(JGR1.gameId == "AAA");
		assertTrue(JGR1.password == "123");
		
		JoinGameRequest JGR2 = new JoinGameRequest("aaa","AAA",null);
		
		System.out.print(JGR2.toString());
		
		assertTrue(JGR2.password == "");
	}

}
