package client.model;

import junit.framework.TestCase;

public class TestGame extends TestCase {
	public void testGamestart(){
		Game g = new Game();
		
		assertTrue(g.getActive() == null);
	}
	
	

}
