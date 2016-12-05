package client.controller;


import java.awt.event.MouseEvent;
import javax.swing.JButton;

import client.ClientLauncher;
import client.MockServerAccess;
import client.model.Model;
import client.view.Application;
import client.view.MouseEventTestCase;
import junit.framework.TestCase;
import request.ExitGameRequest;
import xml.Message;




/**
 * Test cases for QuitButtonController
 * 
 * @author Qihang
 *
 */

public class TestQuitButtonController extends MouseEventTestCase {
	
	Application app;
	Model model;
	
	protected void setUp() throws Exception {
		Message.configure(ClientLauncher.xmlProtocol);
		
		model = new Model();
		app = new Application(model);
		
		app.setServerAccess(new MockServerAccess("dummy"));
	}

	
	public void testQuit() {
					
		QuitButtonController QBC = new QuitButtonController(app,model);
	
		JButton button = new JButton();
		MouseEvent e = new MouseEvent(button, 0, 0, 0, 0, 0, 0, false);
						
		model.game.setGameId(null);

		app.switchToLogin();
		
		assertTrue(QBC.model.game.gameId == null);
		
	}
	
	public void testMouseClickedMouseEvent() {
		testMouseClicked(new QuitButtonController(app, model));		
	}

}
