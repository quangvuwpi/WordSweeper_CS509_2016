package client.view;


import client.model.Model;
import xml.Message;
import junit.framework.TestCase;

public class TestApplication extends TestCase{
	
	Model model;
	Application app;
	
	protected void setUp() throws Exception {
		Message.configure("wordsweeper.xsd");
		
		model = new Model();
		app = new Application(model);
	}
	public void testApplication() {
		
		
		app.start();
		app.switchToLogin();
		app.switchToBoard();
		app.switchToPracticeBoard();
		app.refreshRepositionableStatus();
		app.refreshPlayerStatus();
		app.refreshCurrentScore();
		app.refreshBoard();
		app.refreshScores();
		app.refreshWordHistory();
		
		
		
	}

}
