package client.messageController;

import java.util.UUID;
import client.model.Model;
import client.view.Application;
import junit.framework.TestCase;
import xml.Message;

/**
 * @author Qihang
 *
 */

public class TestConnectResponseController extends TestCase{
	
	Application app;
	Model model;
	
	protected void setUp() throws Exception {
		Message.configure("wordsweeper.xsd");
		
		model = new Model();
		app = new Application(model);
	}
	
	public void testProcess() {
		
		String xmlString = Message.responseHeader(UUID.randomUUID().toString()) +
				"<connectResponse id='hg12jhd'>" +
			  "</connectResponse>" +
			"</response>";
		
		ConnectResponseController CC = new ConnectResponseController();
		

		assertTrue(CC.process(new Message(xmlString)));

		
		
	}
	

}
