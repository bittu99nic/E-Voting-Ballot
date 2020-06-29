package autovoting.java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User_module extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_module frame = new User_module();
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
	public User_module() {
		setResizable(false);
		setTitle("User");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 437, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Buddy");
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(120, 11, 191, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hey!!! are you 18+ if yes then congratulations!!");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(30, 67, 374, 30);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Enjoy e-Voting");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Voter_module vm=new Voter_module();
				vm.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(127, 255, 0));
		btnNewButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnNewButton.setBounds(133, 277, 159, 30);
		contentPane.add(btnNewButton);
		
		JLabel label1 = new JLabel("");
		label1.setBounds(42, 11, 55, 48);
		contentPane.add(label1);
		
		JLabel label = new JLabel("");
		label.setBounds(334, 11, 55, 48);
		contentPane.add(label);
		setIconImage(new ImageIcon(getClass().getResource("/appicon.png")).getImage());
		
		Image img = new ImageIcon(this.getClass().getResource("/welcome1.png")).getImage();
		label.setIcon(new ImageIcon(img));
		Image img2 = new ImageIcon(this.getClass().getResource("/welcome2.png")).getImage();
		label1.setIcon(new ImageIcon(img2));
		
		Image img3 = new ImageIcon(this.getClass().getResource("/digital.png")).getImage();
		
		Image img5 = new ImageIcon(this.getClass().getResource("/userbg.png")).getImage();
		
		
		JLabel lblNewLabel_2 = new JLabel("You are eligible for all types of voting.");
		lblNewLabel_2.setForeground(new Color(0, 255, 0));
		lblNewLabel_2.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(71, 96, 287, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Introducing first version of e-Voting System.");
		lblNewLabel_3.setForeground(new Color(255, 255, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel_3.setBounds(42, 125, 347, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("A part of :");
		lblNewLabel_4.setForeground(new Color(255, 255, 224));
		lblNewLabel_4.setFont(new Font("MV Boli", Font.BOLD, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(120, 154, 191, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel labeldigital = new JLabel("");
		labeldigital.setHorizontalAlignment(SwingConstants.CENTER);
		labeldigital.setBounds(77, 175, 270, 104);
		contentPane.add(labeldigital);
		labeldigital.setIcon(new ImageIcon(img3));
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.RIGHT);
		background.setBounds(0, 0, 431, 334);
		contentPane.add(background);
		background.setIcon(new ImageIcon(img5));
	}
}
