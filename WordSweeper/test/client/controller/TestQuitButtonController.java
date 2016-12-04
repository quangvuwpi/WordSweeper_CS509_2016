package client.controller;


import java.awt.event.MouseEvent;
import javax.swing.JButton;
import client.model.Model;
import client.view.Application;
import junit.framework.TestCase;
import request.ExitGameRequest;
import xml.Message;




/**
 * Test cases for QuitButtonController
 * 
 * @author Qihang
 *
 */

public class TestQuitButtonController extends TestCase {
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	
	public void testQuit() {
		
		Model model = new Model();
		Application app = new Application(model);
					
		QuitButtonController QBC = new QuitButtonController(app,model);
	
		JButton button = new JButton();
		MouseEvent e = new MouseEvent(button, 0, 0, 0, 0, 0, 0, false);
						
		model.game.setGameId(null);

		app.switchToLogin();
		
		assertTrue(QBC.model.game.gameId == null);
		
	}

}
