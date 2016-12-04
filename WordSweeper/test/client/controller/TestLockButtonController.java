package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import client.model.Model;
import client.view.Application;
import request.LockGameRequest;
import xml.Message;
import junit.framework.TestCase;


/**
 * Test cases for LockButtonController
 * 
 * @author Qihang
 *
 */

public class TestLockButtonController extends TestCase{
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testLock() {
		
		Model model = new Model();
		Application app = new Application(model);
					
		LockButtonController LBC = new LockButtonController(app,model);
		
		assertTrue(LBC.model.game.gameId == null);
		
	}

}
