import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;

public class WS extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WS frame = new WS();
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
	public WS() {
		setTitle("<");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 642, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton letter00 = new JButton("A");
		letter00.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter00.setBounds(30, 25, 68, 65);
		letter00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(letter00);
		
		JButton letter01 = new JButton("B");
		letter01.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter01.setBounds(110, 25, 68, 65);
		contentPane.add(letter01);
		
		JButton letter02 = new JButton("C");
		letter02.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter02.setBounds(190, 25, 68, 65);
		contentPane.add(letter02);
		
		JButton letter03 = new JButton("D");
		letter03.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter03.setBounds(270, 25, 68, 65);
		contentPane.add(letter03);
		
		JButton letter10 = new JButton("E");
		letter10.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter10.setBounds(30, 95, 68, 65);
		contentPane.add(letter10);
		
		JButton letter11 = new JButton("F");
		letter11.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter11.setBounds(110, 95, 68, 65);
		contentPane.add(letter11);
		
		JButton letter12 = new JButton("G");
		letter12.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter12.setBounds(190, 95, 68, 65);
		contentPane.add(letter12);
		
		JButton letter13 = new JButton("H");
		letter13.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter13.setBounds(270, 95, 68, 65);
		contentPane.add(letter13);
		
		JButton letter20 = new JButton("I");
		letter20.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter20.setBounds(30, 165, 68, 65);
		contentPane.add(letter20);
		
		JButton letter21 = new JButton("J");
		letter21.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter21.setBounds(110, 165, 68, 65);
		contentPane.add(letter21);
		
		JButton letter22 = new JButton("K");
		letter22.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter22.setBounds(190, 165, 68, 65);
		contentPane.add(letter22);
		
		JButton letter23 = new JButton("L");
		letter23.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter23.setBounds(270, 165, 68, 65);
		contentPane.add(letter23);
		
		JButton letter30 = new JButton("M");
		letter30.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter30.setBounds(30, 235, 68, 65);
		contentPane.add(letter30);
		
		JButton letter31 = new JButton("N");
		letter31.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter31.setBounds(110, 235, 68, 65);
		contentPane.add(letter31);
		
		JButton letter32 = new JButton("O");
		letter32.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter32.setBounds(190, 235, 68, 65);
		contentPane.add(letter32);
		
		JButton letter33 = new JButton("P");
		letter33.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29));
		letter33.setBounds(270, 235, 68, 65);
		contentPane.add(letter33);
		
		JButton btnUp = new JButton("^");
		btnUp.setBounds(30, 5, 308, 17);
		contentPane.add(btnUp);
		
		JButton btnDown = new JButton("v");
		btnDown.setBounds(30, 305, 308, 17);
		contentPane.add(btnDown);
		
		JButton btnRight = new JButton(">");
		btnRight.setBounds(340, 25, 25, 275);
		contentPane.add(btnRight);
		
		JButton btnLeft = new JButton("<");
		btnLeft.setBounds(5, 25, 22, 275);
		contentPane.add(btnLeft);
		
		table = new JTable();
		table.setBounds(395, 6, 231, 313);
		contentPane.add(table);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Wawati SC", Font.PLAIN, 23));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmit.setBounds(110, 335, 148, 66);
		contentPane.add(btnSubmit);
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.setFont(new Font("Wawati SC", Font.PLAIN, 13));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQuit.setBounds(458, 377, 117, 29);
		contentPane.add(btnQuit);
		
		JButton btnLock = new JButton("LOCK");
		btnLock.setFont(new Font("Wawati SC", Font.PLAIN, 13));
		btnLock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLock.setBounds(389, 340, 117, 29);
		contentPane.add(btnLock);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Wawati SC", Font.PLAIN, 13));
		btnReset.setBounds(515, 340, 117, 29);
		contentPane.add(btnReset);
	}
}
