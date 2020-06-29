package autovoting.java;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import student.info.sqlConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;

public class Admin_module extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldZone;
	private JTextField textFieldESD;
	private JTextField textFieldEED;
	private JTextField textFieldNSD;
	private JTextField textFieldNED;
	
	Connection connection=null;
	private final Action action = new SwingAction();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_module frame = new Admin_module();
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
	public Admin_module() {
		setResizable(false);
		connection=sqlConnection.dbConnector();
		setTitle("Admin");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 426, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Election Data");
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 21));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(116, 11, 181, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Type:");
		lblNewLabel_1.setForeground(new Color(224, 255, 255));
		lblNewLabel_1.setFont(new Font("Bell MT", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 62, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnPar = new JRadioButton("Parliament");
		buttonGroup.add(rdbtnPar);
		rdbtnPar.setAction(action);
		rdbtnPar.setBackground(Color.BLACK);
		rdbtnPar.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnPar.setForeground(new Color(216, 191, 216));
		rdbtnPar.setBounds(105, 58, 109, 23);
		contentPane.add(rdbtnPar);
		
		JRadioButton rdbtnAsm = new JRadioButton("Assembly");
		buttonGroup.add(rdbtnAsm);
		rdbtnAsm.setBackground(Color.BLACK);
		rdbtnAsm.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnAsm.setForeground(new Color(216, 191, 216));
		rdbtnAsm.setBounds(230, 58, 109, 23);
		contentPane.add(rdbtnAsm);
		
		JLabel lblNewLabel_2 = new JLabel("Zone(Area):");
		lblNewLabel_2.setForeground(new Color(224, 255, 255));
		lblNewLabel_2.setFont(new Font("Bell MT", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 115, 71, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldZone = new JTextField();
		textFieldZone.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		textFieldZone.setBounds(105, 106, 127, 29);
		contentPane.add(textFieldZone);
		textFieldZone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Election Date");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Georgia", Font.PLAIN, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(116, 146, 181, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Start Date:");
		lblNewLabel_4.setForeground(new Color(224, 255, 255));
		lblNewLabel_4.setFont(new Font("Bell MT", Font.BOLD, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(10, 187, 71, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setForeground(new Color(224, 255, 255));
		lblEndDate.setFont(new Font("Bell MT", Font.BOLD, 13));
		lblEndDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndDate.setBounds(10, 235, 71, 14);
		contentPane.add(lblEndDate);
		
		JLabel label = new JLabel("End Date:");
		label.setForeground(new Color(224, 255, 255));
		label.setFont(new Font("Bell MT", Font.BOLD, 13));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 363, 71, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Start Date:");
		label_1.setForeground(new Color(224, 255, 255));
		label_1.setFont(new Font("Bell MT", Font.BOLD, 13));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(10, 315, 71, 14);
		contentPane.add(label_1);
		
		JLabel lblNominationDate = new JLabel("Nomination Date");
		lblNominationDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblNominationDate.setForeground(Color.WHITE);
		lblNominationDate.setFont(new Font("Georgia", Font.PLAIN, 17));
		lblNominationDate.setBounds(116, 274, 181, 24);
		contentPane.add(lblNominationDate);
		
		JLabel lblNewLabel_5 = new JLabel("(dd/mm/yyyy)");
		lblNewLabel_5.setForeground(new Color(224, 255, 255));
		lblNewLabel_5.setFont(new Font("Bell MT", Font.BOLD, 13));
		lblNewLabel_5.setBounds(254, 187, 85, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel label_2 = new JLabel("(dd/mm/yyyy)");
		label_2.setForeground(new Color(224, 255, 255));
		label_2.setFont(new Font("Bell MT", Font.BOLD, 13));
		label_2.setBounds(254, 235, 85, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("(dd/mm/yyyy)");
		label_3.setForeground(new Color(224, 255, 255));
		label_3.setFont(new Font("Bell MT", Font.BOLD, 13));
		label_3.setBounds(254, 315, 85, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("(dd/mm/yyyy)");
		label_4.setForeground(new Color(224, 255, 255));
		label_4.setFont(new Font("Bell MT", Font.BOLD, 13));
		label_4.setBounds(254, 363, 85, 14);
		contentPane.add(label_4);
		
		textFieldESD = new JTextField();
		textFieldESD.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		textFieldESD.setColumns(10);
		textFieldESD.setBounds(105, 180, 127, 29);
		contentPane.add(textFieldESD);
		
		textFieldEED = new JTextField();
		textFieldEED.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		textFieldEED.setColumns(10);
		textFieldEED.setBounds(105, 230, 127, 29);
		contentPane.add(textFieldEED);
		
		textFieldNSD = new JTextField();
		textFieldNSD.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		textFieldNSD.setColumns(10);
		textFieldNSD.setBounds(105, 310, 127, 29);
		contentPane.add(textFieldNSD);
		
		textFieldNED = new JTextField();
		textFieldNED.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		textFieldNED.setColumns(10);
		textFieldNED.setBounds(105, 360, 127, 29);
		contentPane.add(textFieldNED);
		
		JButton btnNewButton = new JButton("Release Election Schedule");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnPar.setActionCommand("Parliament");
				rdbtnAsm.setActionCommand("Assembly");
				try {
					String query="insert into election_info values(?,?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,buttonGroup.getSelection().getActionCommand());
					pst.setString(2,textFieldZone.getText());
					pst.setString(3,textFieldESD.getText());
					pst.setString(4,textFieldEED.getText());
					pst.setString(5,textFieldNSD.getText());
					pst.setString(6,textFieldNED.getText());
					pst.executeQuery();
					JOptionPane.showMessageDialog(null,"Date Realesed SUCCESSFULLY!!!!!");
					pst.close();
					dispose();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(105, 405, 192, 35);
		contentPane.add(btnNewButton);
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		background.setBounds(0, 0, 410, 460);
		contentPane.add(background);
		setIconImage(new ImageIcon(getClass().getResource("/appicon.png")).getImage());
		
		Image img = new ImageIcon(this.getClass().getResource("/adminbg.png")).getImage();
		background.setIcon(new ImageIcon(img));
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Parliament");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
