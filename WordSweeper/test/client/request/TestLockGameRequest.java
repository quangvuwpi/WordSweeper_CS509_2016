package client.request;

import junit.framework.TestCase;
import request.LockGameRequest;

/**
 * Test case of Lock Game Request
 * 
 * @author Qihang
 *
 */

public class TestLockGameRequest extends TestCase{
	
	public void testLockGameRequest(){
		
		LockGameRequest LGR = new LockGameRequest("AAA");

		System.out.print(LGR.toString());
		
	}

}
