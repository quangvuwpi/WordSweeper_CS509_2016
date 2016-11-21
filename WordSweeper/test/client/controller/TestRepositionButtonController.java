package client.controller;

import client.model.Model;
import client.view.Application;
import junit.framework.TestCase;
import request.RepositionBoardRequest;

/**
 * JUnit test cases for RepositionButtonController
 * 
 * @author quangvu
 *
 */
public class TestRepositionButtonController extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Testing mouse click events
	 */
	public void testMouseClickedMouseEvent() {
		Model m = new Model();
		Application a = new Application(m);
		
		m.game.currentUser = "testUser";
		m.game.setGameId("testId");
		
		RepositionButtonController bc = new RepositionButtonController(a, m);
		
		RepositionBoardRequest up = bc.processMouseClicked("up");
		assertEquals("testUser", up.name);
		assertEquals("testId", up.gameId);
		assertEquals(0, up.colChange);
		assertEquals(-1, up.rowChange);
		
		RepositionBoardRequest down = bc.processMouseClicked("down");
		assertEquals("testUser", down.name);
		assertEquals("testId", down.gameId);
		assertEquals(0, down.colChange);
		assertEquals(1, down.rowChange);
		
		RepositionBoardRequest left = bc.processMouseClicked("left");
		assertEquals("testUser", left.name);
		assertEquals("testId", left.gameId);
		assertEquals(-1, left.colChange);
		assertEquals(0, left.rowChange);
		
		RepositionBoardRequest right = bc.processMouseClicked("right");
		assertEquals("testUser", right.name);
		assertEquals("testId", right.gameId);
		assertEquals(1, right.colChange);
		assertEquals(0, right.rowChange);
	}

}
