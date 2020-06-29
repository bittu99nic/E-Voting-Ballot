package autovoting.java;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin_login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_login frame = new admin_login();
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
	public admin_login() {
		setResizable(false);
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		textField.setBounds(64, 224, 214, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(122, 189, 84, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Serif", Font.BOLD, 15));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(122, 270, 84, 24);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JTextField userID = new JTextField("scott");
				JPasswordField pass=new JPasswordField("tiger");
				if(userID.getText().equals(textField.getText())&&pass.getText().equals(passwordField.getText())) {
				Admin_module ad=new Admin_module();
				ad.setVisible(true);
				dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect userId or password!!\n     Please Try Again!!!!");
				}
			}
		});
		btnNewButton.setBounds(122, 354, 89, 30);
		contentPane.add(btnNewButton);
		
		JLabel labelAdmin = new JLabel("");
		labelAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		labelAdmin.setBounds(64, 11, 214, 178);
		contentPane.add(labelAdmin);
		Image img2 = new ImageIcon(this.getClass().getResource("/adminlogin.png")).getImage();
		labelAdmin.setIcon(new ImageIcon(img2));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		passwordField.setEchoChar('*');
		passwordField.setBounds(64, 298, 214, 35);
		contentPane.add(passwordField);
		
		JLabel loginback = new JLabel("");
		loginback.setHorizontalAlignment(SwingConstants.CENTER);
		loginback.setBounds(0, 0, 354, 406);
		contentPane.add(loginback);
		Image img3 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		loginback.setIcon(new ImageIcon(img3));

		setIconImage(new ImageIcon(getClass().getResource("/appicon.png")).getImage());
	}
}
