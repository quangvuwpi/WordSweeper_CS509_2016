package client.request;

import junit.framework.TestCase;
import request.ExitGameRequest;

/**
 * Test case of Exit Game Request
 * 
 * @author Qihang
 *
 */

public class TestExitGameRequest extends TestCase{
	
	public void testExitGameRequest(){
		
		ExitGameRequest EGR = new ExitGameRequest("aaa","AAA");

		System.out.print(EGR.toString());
		
	}

}
