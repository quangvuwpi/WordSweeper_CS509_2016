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

public class TestFindWordResponseController extends TestCase{
	
	Application app;
	Model model;
	
	protected void setUp() throws Exception {
		Message.configure("wordsweeper.xsd");
		
		model = new Model();
		app = new Application(model);
	}
	
	public void testProcess() {
		
		String xmlString = Message.responseHeader(UUID.randomUUID().toString()) +
				"<findWordResponse gameId='hg12jhd' name='player0' score='392489038'>" +
			  "</findWordResponse>" +
			"</response>";
		
		FindWordResponseController FWC = new FindWordResponseController(app,model);
		

		assertTrue(FWC.process(new Message(xmlString)));
			
		
	}

}
