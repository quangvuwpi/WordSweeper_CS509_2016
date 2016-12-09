package client.view;


import client.model.Model;
import javax.swing.JButton;
import javax.swing.JLabel;
import junit.framework.TestCase;
import xml.Message;

/**
 * Test case of the WordSweeper class
 * 
 * @author Qihang
 *
 */


public class TestWordSweeper extends TestCase{
	

	
	Application app;
	Model model;
	
	JLabel lbUserId;
	JLabel lbGameId;
	JButton btnUp;
	JButton btnDown;
	JButton btnLeft;
	JButton btnRight;
	JButton btnLock;
	JButton btnReset;
	JButton btnSubmit;
	JLabel lb_score;
	
	BoardPanel gamePanel;
	BoardInfoPanel boardInfo;
	WordHistory wordsHistory;
	ScoreBoard scoreBoard;
	
	protected void setUp() throws Exception {
		Message.configure("wordsweeper.xsd");
		
		model = new Model();
		app = new Application(model);
	}
	
	public void testWordSweeper(){
		
		WordSweeper frame = new WordSweeper(app, model, true);
				
	}
	
	

}
