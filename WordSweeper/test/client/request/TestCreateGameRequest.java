package client.request;

import junit.framework.TestCase;
import request.CreateGameRequest;

/**
 * Test case of Create Game Request
 * 
 * @author Qihang
 *
 */

public class TestCreateGameRequest extends TestCase{
	
	public void testCreateGameRequest(){
		
		CreateGameRequest CGR1 = new CreateGameRequest("AAA","123");
		
		System.out.print(CGR1.toString());
		
		assertTrue(CGR1.name == "AAA");
		assertTrue(CGR1.password == "123");
		
		CreateGameRequest CGR2 = new CreateGameRequest("AAA",null);
		
		System.out.print(CGR1.toString());
		
		assertTrue(CGR2.password == "");
	}
	

}