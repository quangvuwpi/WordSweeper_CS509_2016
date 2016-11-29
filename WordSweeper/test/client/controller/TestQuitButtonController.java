package client.controller;


import client.model.Model;
import client.view.Application;
import junit.framework.TestCase;



/**
 * Test cases for QuitButtonController
 * 
 * @author Qihang
 *
 */

public class TestQuitButtonController extends TestCase {
	
	Application app;
	Model model;

	
	public void testQuit() {
					
		new QuitButtonController(app,model);
	
		
	}

}
