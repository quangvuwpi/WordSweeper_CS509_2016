package client.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.controller.BoardController;
import client.controller.CancelButtonController;
import client.controller.LockButtonController;
import client.controller.PracticeSubmitButtonController;
import client.controller.QuitButtonController;
import client.controller.RepositionButtonController;
import client.controller.ResetButtonController;
import client.controller.SubmitButtonController;
import client.model.Model;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;

public class WordSweeper extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
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
	
	/**
	 * Launch the application.
	 */
	public static void main(Application app, Model model) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WordSweeper frame = new WordSweeper(app, model, true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WordSweeper(Application app, Model model, Boolean practiceMode) {
		this.app = app;
		this.model = model;
		
		setTitle("WordSweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 874, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUp = new JButton("^");
		btnUp.setName("up");
		btnUp.setBounds(31, 80, 308, 17);
		btnUp.addMouseListener(new RepositionButtonController(app, model));
		contentPane.add(btnUp);
		btnUp.setVisible(model.game.repositionable[0]);
		
		btnDown = new JButton("v");
		btnDown.setName("down");
		btnDown.setBounds(31, 380, 308, 17);
		btnDown.addMouseListener(new RepositionButtonController(app, model));
		contentPane.add(btnDown);
		btnDown.setVisible(model.game.repositionable[1]);
		
		btnRight = new JButton(">");
		btnRight.setName("right");
		btnRight.setBounds(341, 100, 25, 275);
		btnRight.addMouseListener(new RepositionButtonController(app, model));
		contentPane.add(btnRight);
		btnRight.setVisible(model.game.repositionable[3]);
		
		btnLeft = new JButton("<");
		btnLeft.setName("left");
		btnLeft.setBounds(6, 100, 22, 275);
		btnLeft.addMouseListener(new RepositionButtonController(app, model));
		contentPane.add(btnLeft);
		btnLeft.setVisible(model.game.repositionable[2]);
		
		JLabel lblNewLabel = new JLabel("GAME ID:");
		lblNewLabel.setFont(new Font("Wawati SC", Font.PLAIN, 26));
		lblNewLabel.setBounds(6, 6, 124, 51);
		contentPane.add(lblNewLabel);
		
		lbGameId = new JLabel(model.game.gameId);
		lbGameId.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		lbGameId.setBounds(142, 6, 321, 51);
		contentPane.add(lbGameId);
		
		JLabel lblPlayer = new JLabel("PLAYER:");
		lblPlayer.setFont(new Font("Wawati SC", Font.PLAIN, 26));
		lblPlayer.setBounds(475, 6, 117, 51);
		contentPane.add(lblPlayer);
		
		lbUserId = new JLabel(model.game.currentUser);
		lbUserId.setFont(new Font("Wawati SC", Font.PLAIN, 26));
		lbUserId.setBounds(620, 6, 117, 51);
		contentPane.add(lbUserId);
		
		JLabel lblYourScore = new JLabel("Your Score:");
		lblYourScore.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		lblYourScore.setBounds(475, 80, 117, 17);
		contentPane.add(lblYourScore);
		
		lb_score = new JLabel("0");
		lb_score.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		lb_score.setBounds(620, 80, 117, 17);
		contentPane.add(lb_score);
		
		JLabel lblScore = new JLabel("SCORE BOARD:");
		lblScore.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		lblScore.setBounds(630, 119, 158, 17);
		contentPane.add(lblScore);
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.setFont(new Font("Wawati SC", Font.PLAIN, 23));
		btnQuit.setBounds(560, 481, 148, 66);
		btnQuit.addMouseListener(new QuitButtonController(app, model));
		contentPane.add(btnQuit);
		
		btnLock = new JButton("LOCK");
		btnLock.setFont(new Font("Wawati SC", Font.PLAIN, 23));
		btnLock.setBounds(469, 412, 148, 66);
		btnLock.addMouseListener(new LockButtonController(app, model));
		contentPane.add(btnLock);
		btnLock.setVisible(model.game.isManagingUser);
		
		btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Wawati SC", Font.PLAIN, 23));
		btnReset.setBounds(664, 412, 148, 66);
		btnReset.addMouseListener(new ResetButtonController(app, model));
		contentPane.add(btnReset);
		btnReset.setVisible(model.game.isManagingUser);
		
		wordsHistory = new WordHistory(model.game);
		wordsHistory.setBounds(378, 148, 166, 249);
		contentPane.add(wordsHistory);
		
		boardInfo = new BoardInfoPanel(model.game, model.game.board);
		boardInfo.setBounds(6, 400, 240, 70);
		contentPane.add(boardInfo);
		
		BoardController bc = new BoardController(app, model.game.board);
		gamePanel = new BoardPanel(model.game, model.game.board, bc);
		gamePanel.setBounds(26, 100, 316, 281);
		contentPane.add(gamePanel);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Wawati SC", Font.PLAIN, 23));
		btnCancel.setBounds(266, 412, 100, 66);
		btnCancel.addMouseListener(new CancelButtonController(app, model));
		getContentPane().add(btnCancel);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Wawati SC", Font.PLAIN, 23));
		btnSubmit.setBounds(111, 481, 148, 66);
		if (practiceMode) {
			btnSubmit.addMouseListener(new PracticeSubmitButtonController(app, model, wordsHistory));
		} else {
			btnSubmit.addMouseListener(new SubmitButtonController(app, model, wordsHistory));
		}		
		getContentPane().add(btnSubmit);
		
		JPanel playerScore = new JPanel();
		playerScore.setBounds(441, 69, 347, 38);
		contentPane.add(playerScore);		
		
		scoreBoard = new ScoreBoard(model.game);
		scoreBoard.setBounds(560, 143, 300, 250);
		contentPane.add(scoreBoard);
		
		JLabel lblWordHistory = new JLabel("WORD HISTORY:");
		lblWordHistory.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		lblWordHistory.setBounds(380, 119, 178, 17);
		contentPane.add(lblWordHistory);
	}
	
	public void refreshPlayerStatus() {
		btnLock.setVisible(model.game.isManagingUser);
		btnReset.setVisible(model.game.isManagingUser);		
	}
	
	public void refreshRepositionStatus() {
		boolean[] movable = model.game.repositionable;
		btnUp.setVisible(movable[0]);	
		btnDown.setVisible(movable[1]);	
		btnLeft.setVisible(movable[2]);	
		btnRight.setVisible(movable[3]);	
	}
	
	public void refreshCurrentScore() {
		boardInfo.refresh();
	}
	
	public void refreshBoard() {
		gamePanel.refresh();
	}
	
	public void refreshWordHistory() {
		wordsHistory.refresh();
	}
	
	public void refreshScores() {
		lb_score.setText(Long.toString(model.game.getScore()));
		scoreBoard.refresh();
	}
}
