package client.view;


import javax.swing.JPasswordField;
import javax.swing.JTextField;
import client.model.Model;
import xml.Message;

/**
 * Test case of the Login class
 * 
 * @author Qihang
 *
 */

public class TestLogin extends MouseEventTestCase{
	
	Application app;
	Model model;
	
	
	public JTextField userId;
	public JPasswordField password;
	public JTextField gameId;

	
	
	protected void setUp() throws Exception {
		Message.configure("wordsweeper.xsd");
		
		model = new Model();
		app = new Application(model);
	}
	
	public void testLogin(){
		
		
		Login log = new Login(app,model);
		
		assertTrue(log.setup());
		assertTrue(log.teardown());
		log.refresh();
		log.getUserName();
		log.getGameId();
		log.getPassword();
		
		testMouseClicked(log, log.btnPracticeGame);
		testMouseClicked(log, log.btnStart);
		testMouseClicked(log, log.btnNewGame);
		testMouseClicked(log, log.btnJoinGame);
	}

}
