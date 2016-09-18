import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;

public class WordSweeper extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WordSweeper frame = new WordSweeper();
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
	public WordSweeper() {
		setTitle("WordSweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 874, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton letter00 = new JButton("A");
		letter00.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter00.setBounds(31, 100, 68, 65);
		letter00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(letter00);
		
		JButton letter01 = new JButton("B");
		letter01.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter01.setBounds(111, 100, 68, 65);
		contentPane.add(letter01);
		
		JButton letter02 = new JButton("C");
		letter02.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter02.setBounds(191, 100, 68, 65);
		contentPane.add(letter02);
		
		JButton letter03 = new JButton("D");
		letter03.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter03.setBounds(271, 100, 68, 65);
		contentPane.add(letter03);
		
		JButton letter10 = new JButton("E");
		letter10.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter10.setBounds(31, 170, 68, 65);
		contentPane.add(letter10);
		
		JButton letter11 = new JButton("F");
		letter11.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter11.setBounds(111, 170, 68, 65);
		contentPane.add(letter11);
		
		JButton letter12 = new JButton("G");
		letter12.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter12.setBounds(191, 170, 68, 65);
		contentPane.add(letter12);
		
		JButton letter13 = new JButton("H");
		letter13.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter13.setBounds(271, 170, 68, 65);
		contentPane.add(letter13);
		
		JButton letter20 = new JButton("I");
		letter20.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter20.setBounds(31, 240, 68, 65);
		contentPane.add(letter20);
		
		JButton letter21 = new JButton("J");
		letter21.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter21.setBounds(111, 240, 68, 65);
		contentPane.add(letter21);
		
		JButton letter22 = new JButton("K");
		letter22.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter22.setBounds(191, 240, 68, 65);
		contentPane.add(letter22);
		
		JButton letter23 = new JButton("L");
		letter23.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter23.setBounds(271, 240, 68, 65);
		contentPane.add(letter23);
		
		JButton letter30 = new JButton("M");
		letter30.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter30.setBounds(31, 310, 68, 65);
		contentPane.add(letter30);
		
		JButton letter31 = new JButton("N");
		letter31.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter31.setBounds(111, 310, 68, 65);
		contentPane.add(letter31);
		
		JButton letter32 = new JButton("O");
		letter32.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter32.setBounds(191, 310, 68, 65);
		contentPane.add(letter32);
		
		JButton letter33 = new JButton("P");
		letter33.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter33.setBounds(271, 310, 68, 65);
		contentPane.add(letter33);
		
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
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Wawati SC", Font.PLAIN, 23));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmit.setBounds(111, 481, 148, 66);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("GAME ID:");
		lblNewLabel.setFont(new Font("Wawati SC", Font.PLAIN, 26));
		lblNewLabel.setBounds(6, 6, 117, 51);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("0000");
		label.setFont(new Font("Wawati SC", Font.PLAIN, 26));
		label.setBounds(135, 6, 117, 51);
		contentPane.add(label);
		
		JLabel lblPlayer = new JLabel("PLAYER:");
		lblPlayer.setFont(new Font("Wawati SC", Font.PLAIN, 26));
		lblPlayer.setBounds(271, 6, 117, 51);
		contentPane.add(lblPlayer);
		
		JLabel label_2 = new JLabel("0000");
		label_2.setFont(new Font("Wawati SC", Font.PLAIN, 26));
		label_2.setBounds(396, 6, 117, 51);
		contentPane.add(label_2);
		
		JLabel lblYourScore = new JLabel("Your Score:");
		lblYourScore.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		lblYourScore.setBounds(475, 80, 117, 17);
		contentPane.add(lblYourScore);
		
		JLabel lb_score = new JLabel("1,000,000");
		lb_score.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		lb_score.setBounds(620, 80, 117, 17);
		contentPane.add(lb_score);
		
		JLabel lblYourWords = new JLabel("Your Words:");
		lblYourWords.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		lblYourWords.setBounds(396, 119, 117, 17);
		contentPane.add(lblYourWords);
		
		JLabel lblScore = new JLabel("SCORE BOARD:");
		lblScore.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		lblScore.setBounds(630, 119, 158, 17);
		contentPane.add(lblScore);
		
		JLabel lblTeam = new JLabel("TEAM");
		lblTeam.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		lblTeam.setBounds(396, 148, 117, 17);
		contentPane.add(lblTeam);
		
		JLabel lblPlayer_1 = new JLabel("PLAYER0");
		lblPlayer_1.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		lblPlayer_1.setBounds(580, 148, 117, 17);
		contentPane.add(lblPlayer_1);
		
		JLabel label_7 = new JLabel("1,000,000,000");
		label_7.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_7.setBounds(688, 148, 158, 17);
		contentPane.add(label_7);
		
		JLabel label_3 = new JLabel("TEAM");
		label_3.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_3.setBounds(396, 170, 117, 17);
		contentPane.add(label_3);
		
		JLabel label_5 = new JLabel("TEAM");
		label_5.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_5.setBounds(396, 192, 117, 17);
		contentPane.add(label_5);
		
		JLabel label_4 = new JLabel("TEAM");
		label_4.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_4.setBounds(396, 214, 117, 17);
		contentPane.add(label_4);
		
		JLabel label_6 = new JLabel("TEAM");
		label_6.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_6.setBounds(396, 236, 117, 17);
		contentPane.add(label_6);
		
		JLabel label_9 = new JLabel("TEAM");
		label_9.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_9.setBounds(396, 258, 117, 17);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("TEAM");
		label_10.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_10.setBounds(396, 280, 117, 17);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("TEAM");
		label_11.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_11.setBounds(396, 302, 117, 17);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("TEAM");
		label_12.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_12.setBounds(396, 324, 117, 17);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("TEAM");
		label_13.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_13.setBounds(396, 346, 117, 17);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("TEAM");
		label_14.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_14.setBounds(396, 368, 117, 17);
		contentPane.add(label_14);
		
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
		
		JLabel label_8 = new JLabel("PLAYER0");
		label_8.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_8.setBounds(580, 192, 117, 17);
		contentPane.add(label_8);
		
		JLabel label_15 = new JLabel("1,000,000,000");
		label_15.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_15.setBounds(688, 192, 158, 17);
		contentPane.add(label_15);
		
		JLabel label_20 = new JLabel("1,000,000,000");
		label_20.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_20.setBounds(688, 214, 158, 17);
		contentPane.add(label_20);
		
		JLabel label_21 = new JLabel("PLAYER0");
		label_21.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_21.setBounds(580, 214, 117, 17);
		contentPane.add(label_21);
		
		JLabel label_24 = new JLabel("PLAYER0");
		label_24.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_24.setBounds(580, 236, 117, 17);
		contentPane.add(label_24);
		
		JLabel label_25 = new JLabel("PLAYER0");
		label_25.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_25.setBounds(580, 258, 117, 17);
		contentPane.add(label_25);
		
		JLabel label_26 = new JLabel("PLAYER0");
		label_26.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_26.setBounds(580, 280, 117, 17);
		contentPane.add(label_26);
		
		JLabel label_27 = new JLabel("PLAYER0");
		label_27.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_27.setBounds(580, 302, 117, 17);
		contentPane.add(label_27);
		
		JLabel label_30 = new JLabel("1,000,000,000");
		label_30.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_30.setBounds(688, 302, 158, 17);
		contentPane.add(label_30);
		
		JLabel label_31 = new JLabel("1,000,000,000");
		label_31.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_31.setBounds(688, 280, 158, 17);
		contentPane.add(label_31);
		
		JLabel label_32 = new JLabel("1,000,000,000");
		label_32.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_32.setBounds(688, 258, 158, 17);
		contentPane.add(label_32);
		
		JLabel label_33 = new JLabel("1,000,000,000");
		label_33.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_33.setBounds(688, 236, 158, 17);
		contentPane.add(label_33);
		
		JLabel label_22 = new JLabel("PLAYER0");
		label_22.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_22.setBounds(580, 368, 117, 17);
		contentPane.add(label_22);
		
		JLabel label_23 = new JLabel("1,000,000,000");
		label_23.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_23.setBounds(688, 368, 158, 17);
		contentPane.add(label_23);
		
		JLabel label_34 = new JLabel("1,000,000,000");
		label_34.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_34.setBounds(688, 346, 158, 17);
		contentPane.add(label_34);
		
		JLabel label_35 = new JLabel("PLAYER0");
		label_35.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_35.setBounds(580, 346, 117, 17);
		contentPane.add(label_35);
		
		JLabel label_36 = new JLabel("PLAYER0");
		label_36.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_36.setBounds(580, 324, 117, 17);
		contentPane.add(label_36);
		
		JLabel label_37 = new JLabel("1,000,000,000");
		label_37.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		label_37.setBounds(688, 324, 158, 17);
		contentPane.add(label_37);
		
		JLabel lblAeijk = new JLabel("A");
		lblAeijk.setFont(new Font("Wawati SC", Font.PLAIN, 26));
		lblAeijk.setBounds(31, 418, 117, 51);
		contentPane.add(lblAeijk);
		
		JLabel label_28 = new JLabel("100");
		label_28.setFont(new Font("Wawati SC", Font.PLAIN, 26));
		label_28.setBounds(135, 418, 117, 51);
		contentPane.add(label_28);
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.setFont(new Font("Wawati SC", Font.PLAIN, 23));
		btnQuit.setBounds(560, 481, 148, 66);
		contentPane.add(btnQuit);
		
		JButton btnLock = new JButton("LOCK");
		btnLock.setFont(new Font("Wawati SC", Font.PLAIN, 23));
		btnLock.setBounds(469, 412, 148, 66);
		contentPane.add(btnLock);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Wawati SC", Font.PLAIN, 23));
		btnReset.setBounds(664, 412, 148, 66);
		contentPane.add(btnReset);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Wawati SC", Font.PLAIN, 23));
		btnCancel.setBounds(266, 412, 100, 66);
		contentPane.add(btnCancel);
		
	}
}
