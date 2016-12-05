package client.view;

import client.ClientLauncher;
import client.MockServerAccess;
import client.controller.QuitButtonController;
import client.model.Model;
import xml.Message;

public class TestQuitButtonController extends MouseEventTestCase {

	Application app;
	Model model;
	
	protected void setUp() throws Exception {
		Message.configure(ClientLauncher.xmlProtocol);
		
		model = new Model();
		app = new Application(model);
		
		app.setServerAccess(new MockServerAccess("dummy"));
	}

	public void testMouseClickedMouseEvent() {
		testMouseClicked(new QuitButtonController(app, model));		
	}

}
