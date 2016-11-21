package client.controller;

import client.model.Board;
import junit.framework.TestCase;
import utility.XMLParser;

public class TestPracticeSubmitButtonController extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testPackBoard() {
		Board board = XMLParser.parseXmlBoard("abcdefghijklmnop");		
		
		PracticeSubmitButtonController.packBoard(board);	
	}

}
