package client.controller;

import client.model.Board;
import client.model.Model;
import client.view.Application;
import client.view.WordHistory;
import junit.framework.TestCase;
import utility.XMLParser;



public class TestPracticeSubmitButtonController extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testPracticeSubmit() {
		Model model = new Model();
		Application app = new Application(model);
		WordHistory history = new WordHistory(model.game);
		PracticeSubmitButtonController PBC = new PracticeSubmitButtonController(app,model,history);
		
		assertTrue(PBC.model.game.gameId == null);
	}
	
	public void testPackBoard() {
		Board board = XMLParser.parseXmlBoard("abcdefghijklmnop");		
		
		PracticeSubmitButtonController.packBoard(board);	
	}

}
