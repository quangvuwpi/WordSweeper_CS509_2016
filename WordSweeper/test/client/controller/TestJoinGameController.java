package client.controller;

import client.view.Application;
import client.view.ILogin;
import junit.framework.TestCase;


/**
 * Test case for controller to send a Join Game Request to the server.
 * 
 * @author Qihang
 */

public class TestJoinGameController extends TestCase {
	
	Application app;
	ILogin login;

	protected void setUp() throws Exception {
		super.setUp();
	}

	
	public void testJoinGameProcess() {
		ILogin login = new ILogin() {

			@Override
			public String getUserName() {
				return "abc";
			}

			@Override
			public String getPassword() {
				return "123";
			}

			@Override
			public String getGameId() {
				return null;
			}
		};
		JoinGameController JGC = new JoinGameController(app, login);

		
		assertEquals("abc", JGC.login.getUserName());		
		assertEquals("123", JGC.login.getPassword());
		

	}

}
