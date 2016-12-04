package client.controller;



import client.view.Application;
import client.view.ILogin;
import junit.framework.TestCase;



/**
 * Test case for controller to send a Create Game Request to the server.
 * 
 * @author Qihang
 */
public class TestCreateGameController extends TestCase {


	Application app;
	ILogin login;

	protected void setUp() throws Exception {
		super.setUp();
	}


	public void testCreateGameProcess() {
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
		CreateGameController CGC = new CreateGameController(app, login);

		
		assertEquals("abc", CGC.login.getUserName());		
		assertEquals("123", CGC.login.getPassword());

	}


	
}
