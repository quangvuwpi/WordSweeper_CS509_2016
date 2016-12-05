package client.view;

import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import client.model.Model;
import xml.Message;
import junit.framework.TestCase;

public class TestLogin extends TestCase{
	
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
		
		
	}

}
