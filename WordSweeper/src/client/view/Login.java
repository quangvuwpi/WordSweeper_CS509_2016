package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

import client.ServerAccess;
import client.controller.CreateGameController;
import client.controller.JoinGameController;
import client.controller.PracticeGameController;
import client.model.Model;

public class Login extends JFrame implements MouseListener, IBoundary {
	
	final Application app;
	final Model model;
	
	private JPanel contentPane;
	public JTextField userId;
	private JLabel lbUserId;
	private JLabel lbPassword;
	public JPasswordField password;
	private JLabel lbGameId;
	public JTextField gameId;
	private JLabel btnNewGame;
	private JLabel btnJoinGame;
	private JLabel btnPracticeGame;
	private HashMap<String, Boolean> clickMap = new HashMap<String, Boolean>();
	private JButton btnStart;

	/**
	 * Create the frame.
	 */
	public Login(Application app, Model model) {
		this.app = app;
		this.model = model;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//setLayout(null);
		
		JLabel lblWelcomeToWordsweeper = new JLabel("Welcome to WordSweeper CLIENT");
		lblWelcomeToWordsweeper.setFont(new Font("Wawati SC", Font.BOLD | Font.ITALIC, 20));
		lblWelcomeToWordsweeper.setBounds(5, 5, 440, 16);
		contentPane.add(lblWelcomeToWordsweeper);
		
		lbUserId = new JLabel("USER ID:", JLabel.RIGHT);
		lbUserId.setBounds(265, 85, 60, 15);
		contentPane.add(lbUserId);
		
		userId = new JTextField();
		userId.setBounds(338, 81, 130, 26);
		contentPane.add(userId);
		userId.setColumns(10);
		
		lbGameId = new JLabel("GAME ID:", JLabel.RIGHT);
		lbGameId.setBounds(265, 115, 60, 15);
		lbGameId.setVisible(false);
		contentPane.add(lbGameId);
		
		gameId = new JTextField();
		gameId.setBounds(338, 111, 130, 26);
		gameId.setVisible(false);
		contentPane.add(gameId);
		
		lbPassword = new JLabel("PASSWORD:", JLabel.RIGHT);
		lbPassword.setBounds(245, 145, 80, 15);
		lbPassword.setVisible(false);
		contentPane.add(lbPassword);
		
		password = new JPasswordField();
		password.setBounds(338, 141, 130, 26);
		password.setVisible(false);
		contentPane.add(password);
		
		btnStart = new JButton("START!");
		btnStart.setName("Start");
		btnStart.setBounds(302, 196, 117, 50);
		btnStart.addMouseListener(this);
		contentPane.add(btnStart);

		/*Use Label as button to let Player choose game mode*/
		btnNewGame = new JLabel("NEW GAME", JLabel.CENTER);
		clickMap.put("NewGame", false);
		btnNewGame.addMouseListener(this);
		btnNewGame.setName("NewGame");
		btnNewGame.setFont(new Font("Wawati SC", Font.BOLD, 20));
		btnNewGame.setBounds(30, 110, 200, 30);
		contentPane.add(btnNewGame);
		
		btnPracticeGame = new JLabel("PRACTICE GAME", JLabel.CENTER);
		clickMap.put("PracticeGame", true);
		btnPracticeGame.setForeground(Color.PINK);
		btnPracticeGame.addMouseListener(this);
		btnPracticeGame.setName("PracticeGame");
		btnPracticeGame.setFont(new Font("Wawati SC", Font.BOLD, 20));
		btnPracticeGame.setBounds(30, 150, 200, 30);
		contentPane.add(btnPracticeGame);
		
		btnJoinGame = new JLabel("JOIN GAME", JLabel.CENTER);
		clickMap.put("JoinGame",false);
		btnJoinGame.setForeground(Color.BLACK);
		btnJoinGame.addMouseListener(this);
		btnJoinGame.setName("JoinGame");
		btnJoinGame.setFont(new Font("Wawati SC", Font.BOLD, 20));
		btnJoinGame.setBounds(30, 70, 200, 30);
		contentPane.add(btnJoinGame);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setBounds(30, 100, 200, 20);
		contentPane.add(separator);
		
		JSeparator separator2 = new JSeparator();
		separator2.setForeground(Color.DARK_GRAY);
		separator2.setBounds(30, 140, 200, 20);
		contentPane.add(separator2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String name = e.getComponent().getName();
		if(name == "Start"){
			model.game.currentUser = userId.getText();
			System.out.print(userId.getText());
			if(clickMap.get("NewGame"))			
				new CreateGameController(app, app.model).process();
			if(clickMap.get("JoinGame"))
				new JoinGameController(app, app.model).process();
			if(clickMap.get("PracticeGame"))
				new PracticeGameController(app, app.model).process();
		}
		else{
			if(name == "NewGame"){
				lbGameId.setVisible(false);
				gameId.setVisible(false);
				lbPassword.setVisible(true);
				password.setVisible(true);
				btnJoinGame.setForeground(Color.BLACK);
				btnPracticeGame.setForeground(Color.BLACK);
			}
			if(name == "JoinGame"){
				lbGameId.setVisible(true);
				gameId.setVisible(true);
				lbPassword.setVisible(true);
				password.setVisible(true);
				btnNewGame.setForeground(Color.BLACK);
				btnPracticeGame.setForeground(Color.BLACK);
			}
			if(name == "PracticeGame"){
				lbGameId.setVisible(false);
				gameId.setVisible(false);
				lbPassword.setVisible(false);
				password.setVisible(false);
				btnJoinGame.setForeground(Color.BLACK);
				btnNewGame.setForeground(Color.BLACK);
			}
			clickConfig(name);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent().getName() != "Start")
			e.getComponent().setForeground(Color.PINK);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		String name = e.getComponent().getName();
		if(name != "Start" && !clickMap.get(name)){
			e.getComponent().setForeground(Color.BLACK);
		}
	}
	
	private void clickConfig(String name){
		if(name != "Start"){
			if(name != "NewGame")
				clickMap.put("NewGame", false);
			if(name != "JoinGame")
				clickMap.put("JoinGame", false);
			if(name != "PracticeGame")
				clickMap.put("PracticeGame", false);
			clickMap.put(name, !clickMap.get(name));
		}
	}

	@Override
	public boolean setup() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean teardown() {
		// TODO Auto-generated method stub
		return true;
	}

}
