package client.controller;

import client.model.Model;
import client.view.Application;
import client.view.MouseEventTestCase;

public class TestCancelButtonController extends MouseEventTestCase {

	Application app;
	Model model;
	
	protected void setUp() throws Exception {
		model = new Model();
		app = new Application(model);
	}

	public void testMouseClickedMouseEvent() {
		CancelButtonController bc = new CancelButtonController(app, model);
		
		testMouseClicked(bc);
	}

}
