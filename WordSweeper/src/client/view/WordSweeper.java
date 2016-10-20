package client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.model.Board;
import client.model.Model;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.SwingConstants;

public class WordSweeper extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	Application app;
	Model model;
	
	private String GameId = "";
	private String UserId = "";
	private Boolean ManagingUser = true;
	
	/**
	 * Launch the application.
	 */
	public static void main(Application app, Model model) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WordSweeper frame = new WordSweeper(app, model);
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
	public WordSweeper(Application app, Model model) {
		this.app = app;
		this.model = model;
		
		this.GameId = model.game.gameId;
		this.UserId = model.game.currentUser;
		this.ManagingUser = model.game.isManagingUser;
		
		setTitle("WordSweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 874, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUp = new JButton("^");
		btnUp.setBounds(31, 80, 308, 17);
		contentPane.add(btnUp);
		
		JButton btnDown = new JButton("v");
		btnDown.setBounds(31, 380, 308, 17);
		contentPane.add(btnDown);
		
		JButton btnRight = new JButton(">");
		btnRight.setBounds(341, 100, 25, 275);
		contentPane.add(btnRight);
		
		JButton btnLeft = new JButton("<");
		btnLeft.setBounds(6, 100, 22, 275);
		contentPane.add(btnLeft);
		
		JLabel lblNewLabel = new JLabel("GAME ID:");
		lblNewLabel.setFont(new Font("Wawati SC", Font.PLAIN, 26));
		lblNewLabel.setBounds(6, 6, 117, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lbGameId = new JLabel(GameId);
		lbGameId.setFont(new Font("Wawati SC", Font.PLAIN, 26));
		lbGameId.setBounds(135, 6, 117, 51);
		contentPane.add(lbGameId);
		
		JLabel lblPlayer = new JLabel("PLAYER:");
		lblPlayer.setFont(new Font("Wawati SC", Font.PLAIN, 26));
		lblPlayer.setBounds(271, 6, 117, 51);
		contentPane.add(lblPlayer);
		
		JLabel lbUserId = new JLabel(UserId);
		lbUserId.setFont(new Font("Wawati SC", Font.PLAIN, 26));
		lbUserId.setBounds(396, 6, 117, 51);
		contentPane.add(lbUserId);
		
		JLabel lblYourScore = new JLabel("Your Score:");
		lblYourScore.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		lblYourScore.setBounds(475, 80, 117, 17);
		contentPane.add(lblYourScore);
		
		JLabel lb_score = new JLabel("1,000,000");
		lb_score.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		lb_score.setBounds(620, 80, 117, 17);
		contentPane.add(lb_score);
		
		JLabel lblScore = new JLabel("SCORE BOARD:");
		lblScore.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		lblScore.setBounds(630, 119, 158, 17);
		contentPane.add(lblScore);
		
		JLabel lblPlayer_1 = new JLabel("PLAYER0");
		lblPlayer_1.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		lblPlayer_1.setBounds(580, 148, 117, 17);
		contentPane.add(lblPlayer_1);
		
		JLabel label_7 = new JLabel("1,000,000,000");
		label_7.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_7.setBounds(688, 148, 158, 17);
		contentPane.add(label_7);
		
		JLabel label_16 = new JLabel("PLAYER0");
		label_16.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_16.setBounds(580, 170, 117, 17);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("PLAYER0");
		label_17.setForeground(Color.PINK);
		label_17.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_17.setBounds(580, 192, 117, 17);
		contentPane.add(label_17);
		
		JLabel label_18 = new JLabel("1,000,000,000");
		label_18.setForeground(Color.PINK);
		label_18.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_18.setBounds(688, 192, 158, 17);
		contentPane.add(label_18);
		
		JLabel label_19 = new JLabel("1,000,000,000");
		label_19.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_19.setBounds(688, 170, 158, 17);
		contentPane.add(label_19);
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.setFont(new Font("Wawati SC", Font.PLAIN, 23));
		btnQuit.setBounds(560, 481, 148, 66);
		contentPane.add(btnQuit);
		
		JButton btnLock = new JButton("LOCK");
		btnLock.setFont(new Font("Wawati SC", Font.PLAIN, 23));
		btnLock.setBounds(469, 412, 148, 66);
		contentPane.add(btnLock);
		btnLock.setVisible(ManagingUser);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Wawati SC", Font.PLAIN, 23));
		btnReset.setBounds(664, 412, 148, 66);
		contentPane.add(btnReset);
		btnReset.setVisible(ManagingUser);
		
		WordHistory wordsHistory = new WordHistory();
		wordsHistory.setBounds(391, 119, 122, 275);
		contentPane.add(wordsHistory);
		
		BoardInfoPanel boardInfo = new BoardInfoPanel(wordsHistory);
		boardInfo.setBounds(6, 400, 240, 70);
		contentPane.add(boardInfo);
		
		BoardPanel gamePanel = new BoardPanel(model, model.game.board, boardInfo);
		gamePanel.setBounds(26, 100, 316, 281);
		contentPane.add(gamePanel);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Wawati SC", Font.PLAIN, 23));
		btnCancel.setBounds(266, 412, 100, 66);
		btnCancel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				gamePanel.cancel();
			}
		});
		add(btnCancel);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Wawati SC", Font.PLAIN, 23));
		btnSubmit.setBounds(111, 481, 148, 66);
		btnSubmit.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
//				System.out.print("\n "+ wordsHistory..lbSelectedWords.getText() +" \n");
				if(boardInfo.lbSelectedWords.getText() != null){
					wordsHistory.addWord(boardInfo.lbSelectedWords.getText());
					gamePanel.submit();
				}
			}
		});
		add(btnSubmit);
		
		JPanel scoreBoard = new JPanel();
		scoreBoard.setBounds(111, 481, 148, 66);
		contentPane.add(scoreBoard);
		
		JPanel playerScore = new JPanel();
		playerScore.setBounds(441, 69, 347, 38);
		contentPane.add(playerScore);
		
	}
}
