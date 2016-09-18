import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToWordsweeper = new JLabel("Welcome to WordSweeper CLINET");
		lblWelcomeToWordsweeper.setFont(new Font("Wawati SC", Font.BOLD | Font.ITALIC, 20));
		lblWelcomeToWordsweeper.setBounds(5, 5, 440, 16);
		contentPane.add(lblWelcomeToWordsweeper);
		
		JButton btnLogIn = new JButton("JOIN GAME");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogIn.setBounds(50, 73, 117, 29);
		contentPane.add(btnLogIn);
		
		JButton btnOfflineGame = new JButton("OFFLINE GAME");
		btnOfflineGame.setBounds(50, 155, 117, 29);
		contentPane.add(btnOfflineGame);
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.setBounds(50, 193, 117, 29);
		contentPane.add(btnQuit);
		
		textField = new JTextField();
		textField.setBounds(286, 94, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUserId = new JLabel("USER ID:");
		lblUserId.setBounds(213, 99, 61, 16);
		contentPane.add(lblUserId);
		
		JButton btnStart = new JButton("START!");
		btnStart.setBounds(299, 193, 117, 50);
		contentPane.add(btnStart);
		
		JButton btnNewGame = new JButton("NEW GAME");
		btnNewGame.setBounds(50, 114, 117, 29);
		contentPane.add(btnNewGame);
	}
}
