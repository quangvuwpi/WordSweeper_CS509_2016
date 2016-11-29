/**
 * 
 */
package client.messageController;

import java.util.UUID;
import client.model.Model;
import client.view.Application;
import junit.framework.TestCase;
import utility.XMLParser;
import xml.Message;

/**
 * @author quangvu
 *
 */
public class TestBoardResponseController extends TestCase {
	
	Application app;
	Model model;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		Message.configure("wordsweeper.xsd");
		
		model = new Model();
		app = new Application(model);
	}

	/**
	 * Test method for {@link client.messageController.BoardResponseController#process(xml.Message)}.
	 */
	public void testProcess() {
		model.game.currentUser = "player0";
		model.game.setBoard(XMLParser.parseXmlBoard("ACOWEFGHIJKLWALL"));
		
		String xmlString = Message.responseHeader(UUID.randomUUID().toString()) +
				"<boardResponse gameId='hg12jhd' size='1' managingUser='player0' bonus='4,3' contents='ABCGBCJDH...HDJHJD'>" +
			      "<player name='player0' score='392489038' position='4,6' board='AFERKSOEROIERPOR'/>" +
			  "</boardResponse>" +
			"</response>";
		
		BoardResponseController bc = new BoardResponseController(app, model);
		bc.process(new Message(xmlString));

		assertTrue(model.game.isManagingUser);
		assertEquals(1, model.game.playerCount());
		assertEquals("hg12jhd", model.game.gameId);
		assertEquals("AFERKSOEROIERPOR", model.game.board.toString());
		
		//Player p0 = model.game.getPlayer(model.game.currentUser);
		//assertEquals("player0", p0.name);
		//assertEquals(392489038, p0.score);
		//assertEquals(new Position(3,5), p0.position); // offset by 1
		
		
	}

}
