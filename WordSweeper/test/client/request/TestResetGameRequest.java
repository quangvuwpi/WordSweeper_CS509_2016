package client.request;

import junit.framework.TestCase;
import request.ResetGameRequest;

/**
 * Test case of Reset Game Request
 * 
 * @author Qihang
 *
 */

public class TestResetGameRequest extends TestCase{
	
	public void testResetGameRequest(){
		
		ResetGameRequest RGR = new ResetGameRequest("AAA");

		System.out.print(RGR.toString());
		
	}

}
