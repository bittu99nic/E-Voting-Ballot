package autovoting.java;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import student.info.sqlConnection;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

public class Voter_module extends JFrame {

	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField textFieldfn;
	private JTextField textFieldm;
	private JTextField textFieldd;
	private JTextField textFieldln;
	private JPasswordField passwordField;
	private JLabel UIDLABEL;
	private JTable table;
	private JComboBox comboBox_1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voter_module frame = new Voter_module();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField textField_ln;
	private JTextField textField_fn;
	private JPasswordField passwordField_1;
	private JTextField textField_uid;
	private JTextField textField_pn;
	private JTextField textFieldvuid;
	private JPasswordField passwordField_2;
	
	public void refreshTable() {
		try {
			String query4="select first_name,last_name,party_name from nomination_info";
			PreparedStatement pst4=connection.prepareStatement(query4);
			ResultSet rs4=pst4.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs4));
			}
			catch(Exception e3) {
				e3.getStackTrace();
			}
	}
	
	public void comboBoxadd() {
		try {
			comboBox.removeAllItems();
			String query2="select * from election_info";
			PreparedStatement pst2=connection.prepareStatement(query2);
			ResultSet rs2=pst2.executeQuery();
			
			while(rs2.next()) {
				comboBox.addItem(rs2.getString("Election_SD")+"-"+rs2.getString("Election_ED"));
				
			}
		}catch(Exception e4) {
			e4.printStackTrace();
		}
	}
	
	public void comboBoxadd1() {
		try {
			comboBox_1.removeAllItems();
			String query2="select distinct(party_name) from nomination_info";
			PreparedStatement pst2=connection.prepareStatement(query2);
			ResultSet rs2=pst2.executeQuery();
			
			while(rs2.next()) {
				comboBox_1.addItem(rs2.getString("party_name"));
				
			}
		}catch(Exception e4) {
			e4.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 * 
	 */
	public Voter_module() {
		setResizable(false);
		
		connection=sqlConnection.dbConnector();
		setTitle("Voter");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 502, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBounds(0, 0, 486, 324);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Voter Registration", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setForeground(new Color(250, 240, 230));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 32, 81, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mobile no.:");
		lblNewLabel_1.setForeground(new Color(250, 240, 230));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 82, 81, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("D.O.B:");
		lblNewLabel_2.setForeground(new Color(250, 240, 230));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 131, 81, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setForeground(new Color(250, 240, 230));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 182, 81, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("UID:");
		lblNewLabel_4.setForeground(new Color(250, 240, 230));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 233, 81, 14);
		panel.add(lblNewLabel_4);
		
		textFieldfn = new JTextField();
		textFieldfn.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		textFieldfn.setBounds(114, 25, 131, 28);
		panel.add(textFieldfn);
		textFieldfn.setColumns(10);
		
		textFieldm = new JTextField();
		textFieldm.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		textFieldm.setColumns(10);
		textFieldm.setBounds(114, 75, 131, 28);
		panel.add(textFieldm);
		
		textFieldd = new JTextField();
		textFieldd.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		textFieldd.setColumns(10);
		textFieldd.setBounds(114, 124, 131, 28);
		panel.add(textFieldd);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBackground(new Color(175, 238, 238));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int c;
					String mb=textFieldm.getText();
					String query1="select * from voter_info where mobile_no='"+mb+"'";
					PreparedStatement pst1=connection.prepareStatement(query1);
					ResultSet rs=pst1.executeQuery();
					c=0;
					while(rs.next()) {
							c++;
					}
					if(c==0) {
					String query="insert into voter_info values(?,?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.setString(1,textFieldfn.getText());
					pst.setString(2,textFieldln.getText());
					pst.setString(3,textFieldm.getText());
					pst.setString(4,textFieldd.getText());
					pst.setString(5,passwordField.getText());
					double min  =1800000000;
					double max = 2100000000;
					double udd =(Math.random()*((max-min)+1))+min;
					int ui = (int)udd;
					String uid = Integer.toString(ui);
					UIDLABEL.setText(uid);
					pst.setString(6,uid);
					pst.executeQuery();
					JOptionPane.showMessageDialog(null,"You are Registered!!!!\n Please note your UID.");
					textFieldfn.setText("");
					textFieldln.setText("");
					textFieldm.setText("");
					textFieldd.setText("");
					passwordField.setText("");
					UIDLABEL.setText("XXXXXXXXX");
					pst.close();
					}
					else {
						JOptionPane.showMessageDialog(null, "You are already Registered!!");
						c=0;
					}
				}
				catch(Exception e3) {
					e3.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton.setBounds(300, 219, 120, 28);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("(dd/mm/yyyy)");
		lblNewLabel_5.setForeground(new Color(250, 240, 230));
		lblNewLabel_5.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_5.setBounds(268, 125, 131, 28);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Last Name:");
		lblNewLabel_6.setForeground(new Color(250, 240, 230));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_6.setBounds(255, 32, 69, 14);
		panel.add(lblNewLabel_6);
		
		textFieldln = new JTextField();
		textFieldln.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		textFieldln.setColumns(10);
		textFieldln.setBounds(340, 25, 131, 28);
		panel.add(textFieldln);
		
		UIDLABEL = new JLabel("XXXXXXXXX");
		UIDLABEL.setForeground(new Color(250, 240, 230));
		UIDLABEL.setFont(new Font("Georgia", Font.BOLD, 12));
		UIDLABEL.setBounds(114, 229, 104, 22);
		panel.add(UIDLABEL);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		passwordField.setBounds(114, 175, 131, 28);
		panel.add(passwordField);
		
		JLabel lblautoGeneratedAfter = new JLabel("(auto generated after registration)");
		lblautoGeneratedAfter.setForeground(new Color(250, 240, 230));
		lblautoGeneratedAfter.setHorizontalAlignment(SwingConstants.CENTER);
		lblautoGeneratedAfter.setFont(new Font("Rockwell", Font.PLAIN, 11));
		lblautoGeneratedAfter.setBounds(0, 253, 245, 14);
		panel.add(lblautoGeneratedAfter);
		
		JLabel background1 = new JLabel("");
		background1.setBounds(0, 0, 481, 296);
		panel.add(background1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Nomination", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField_ln = new JTextField();
		textField_ln.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		textField_ln.setColumns(10);
		textField_ln.setBounds(321, 90, 131, 28);
		panel_1.add(textField_ln);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setForeground(new Color(250, 240, 230));
		lblLastName.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblLastName.setBounds(217, 97, 81, 14);
		panel_1.add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setForeground(new Color(250, 240, 230));
		lblFirstName.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblFirstName.setBounds(217, 49, 81, 14);
		panel_1.add(lblFirstName);
		
		textField_fn = new JTextField();
		textField_fn.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		textField_fn.setColumns(10);
		textField_fn.setBounds(321, 42, 131, 28);
		panel_1.add(textField_fn);
		
		JLabel label_2 = new JLabel("Password:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(new Color(250, 240, 230));
		label_2.setFont(new Font("Rockwell", Font.BOLD, 12));
		label_2.setBounds(217, 146, 81, 14);
		panel_1.add(label_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		passwordField_1.setEchoChar('*');
		passwordField_1.setBounds(321, 139, 131, 28);
		panel_1.add(passwordField_1);
		
		JLabel lblPassword = new JLabel("Voter UID:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setForeground(new Color(250, 240, 230));
		lblPassword.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblPassword.setBounds(217, 194, 81, 14);
		panel_1.add(lblPassword);
		
		textField_uid = new JTextField();
		textField_uid.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		textField_uid.setColumns(10);
		textField_uid.setBounds(321, 187, 131, 28);
		panel_1.add(textField_uid);
		
		JButton btnNewButton_1 = new JButton("Nominate Me");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int c;
					String ud=textField_uid.getText();
					String query1="select first_name,last_name,password,voter_uid from voter_info where voter_uid='"+ud+"'";
					PreparedStatement pst1=connection.prepareStatement(query1);
					ResultSet rs=pst1.executeQuery();
					c=0;
					while(rs.next()) {
						c++;
					}
					if(c==1) {
						String query="insert into nomination_info values(?,?,?,?)";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.setString(1,textField_fn.getText());
						pst.setString(2,textField_ln.getText());
						pst.setString(3,textField_uid.getText());
						pst.setString(4,textField_pn.getText());
						pst.executeQuery();
						String pn=textField_pn.getText();
						String query3="select * from report_info where party_name='"+pn+"'";
						PreparedStatement pst2=connection.prepareStatement(query3);
						ResultSet rs2=pst2.executeQuery();
						
						int k;
						k=0;
						while(rs2.next())
							k++;
						if(k==0) {
							String query2="insert into report_info values(?,?)";
							PreparedStatement ps=connection.prepareStatement(query2);
							ps.setString(1,pn);
							ps.setString(2,"0");
							ps.executeQuery();
							ps.close();
						
						}
						JOptionPane.showMessageDialog(null,"Congratulation!!!!\n You are Nominated.");
						textField_fn.setText("");
						textField_ln.setText("");
						textField_uid.setText("");
						textField_pn.setText("");
						passwordField_1.setText("");
						pst.close();
					}else {
						JOptionPane.showMessageDialog(null,"You are not registered in Voter List!!\n First Register as a Voter.");
					}
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null,e2);
				}
			}
		});
		btnNewButton_1.setBackground(new Color(175, 238, 238));
		btnNewButton_1.setFont(new Font("Cambria", Font.BOLD, 12));
		btnNewButton_1.setBounds(278, 240, 112, 33);
		panel_1.add(btnNewButton_1);
		
		textField_pn = new JTextField();
		textField_pn.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		textField_pn.setColumns(10);
		textField_pn.setBounds(114, 245, 131, 28);
		panel_1.add(textField_pn);
		
		JLabel lblPartyName = new JLabel("Party Name");
		lblPartyName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPartyName.setForeground(new Color(250, 240, 230));
		lblPartyName.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblPartyName.setBounds(10, 252, 81, 14);
		panel_1.add(lblPartyName);
		
		JLabel nominationicon = new JLabel("");
		nominationicon.setBounds(25, 24, 189, 185);
		panel_1.add(nominationicon);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Online Voting", null, panel_2, null);
		panel_2.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI Black", Font.BOLD, 9));
		comboBox.setBounds(84, 89, 134, 27);
		panel_2.add(comboBox);
		
		textFieldvuid = new JTextField();
		textFieldvuid.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		textFieldvuid.setBounds(84, 38, 134, 27);
		panel_2.add(textFieldvuid);
		textFieldvuid.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Voter UID:");
		lblNewLabel_7.setForeground(new Color(175, 238, 238));
		lblNewLabel_7.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(0, 44, 74, 14);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Schedule:");
		lblNewLabel_8.setForeground(new Color(175, 238, 238));
		lblNewLabel_8.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(0, 94, 74, 14);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Password:");
		lblNewLabel_9.setForeground(new Color(175, 238, 238));
		lblNewLabel_9.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setBounds(0, 143, 74, 14);
		panel_2.add(lblNewLabel_9);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		comboBox_1.setBounds(84, 189, 134, 27);
		panel_2.add(comboBox_1);
		
		JLabel lblNewLabel_10 = new JLabel("Party:");
		lblNewLabel_10.setForeground(new Color(175, 238, 238));
		lblNewLabel_10.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setBounds(0, 195, 74, 14);
		panel_2.add(lblNewLabel_10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 105, 180), new Color(221, 160, 221), new Color(75, 0, 130), new Color(72, 61, 139)));
		scrollPane.setBounds(228, 44, 243, 229);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 228, 225));
		table.setForeground(new Color(75, 0, 130));
		table.setFont(new Font("Rockwell", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Cast Vote");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				
				String party;
				party=comboBox_1.getSelectedItem().toString();
				String ps,ud;
				ps=passwordField_2.getText();
				ud=textFieldvuid.getText();
				String query1="select * from voter_info where password='"+ps+"' and voter_uid='"+ud+"'";
				int c;
				c=0;
				PreparedStatement pst=connection.prepareStatement(query1);
				ResultSet rs=pst.executeQuery();
				while(rs.next()) {
					c++;
				}
				if(c==1) {
					int m;
					m=0;
					String query3="select * from report_info where party_name='"+party+"'";
					PreparedStatement pst3=connection.prepareStatement(query3);
					ResultSet rs3=pst3.executeQuery();
					while(rs3.next()) {
						m++;
					}
					if(m==1) {
						String query5="select * from report_info where party_name='"+party+"'";
						String result;
						int res=1;
						PreparedStatement pst5=connection.prepareStatement(query5);
						ResultSet rs5=pst5.executeQuery();
						while(rs5.next()) {
							result=rs5.getString("vote");
							res=Integer.parseInt(result);
							res++;
						}
						result=Integer.toString(res);
						String query6="update report_info set vote='"+result+"' where party_name='"+party+"'";
						PreparedStatement pst6=connection.prepareStatement(query6);
						pst6.executeQuery();
						pst6.close();
						JOptionPane.showMessageDialog(null,"You successfully voted "+party+"!!");
						textFieldvuid.setText("");
						passwordField_2.setText("");
					}else {
						String query4="insert into report_info values(?,?)";
						PreparedStatement pst4=connection.prepareStatement(query4);
						pst4.setString(1,party);
						pst4.setString(2,"1");
						pst4.executeQuery();
						pst.close();
						JOptionPane.showMessageDialog(null,"You successfully voted "+party+"!!");
						textFieldvuid.setText("");
						passwordField_2.setText("");
					}
					
				}else {
					JOptionPane.showMessageDialog(null,"Sorry you are not Registered for Voting!!");
				}
				
			}catch(Exception e2) {
				JOptionPane.showMessageDialog(null,e2);
			}
			}
		});
		btnNewButton_2.setBackground(new Color(224, 255, 255));
		btnNewButton_2.setFont(new Font("Cambria", Font.BOLD, 12));
		btnNewButton_2.setBounds(78, 240, 113, 27);
		panel_2.add(btnNewButton_2);
		
		JLabel lblNewLabel_11 = new JLabel("Nominees");
		lblNewLabel_11.setForeground(new Color(175, 238, 238));
		lblNewLabel_11.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(310, 19, 74, 14);
		panel_2.add(lblNewLabel_11);
		
		setIconImage(new ImageIcon(getClass().getResource("/appicon.png")).getImage());
		
		Image img2 = new ImageIcon(this.getClass().getResource("/bg1.png")).getImage();
		background1.setIcon(new ImageIcon(img2));
		Image img7 = new ImageIcon(this.getClass().getResource("/nicon.png")).getImage();
		nominationicon.setIcon(new ImageIcon(img7));
		
		JLabel background2 = new JLabel("");
		background2.setBounds(0, 0, 481, 296);
		panel_1.add(background2);
		
		Image img6 = new ImageIcon(this.getClass().getResource("/bg2.png")).getImage();
		background2.setIcon(new ImageIcon(img6));
		
		Image img8 = new ImageIcon(this.getClass().getResource("/bg3.png")).getImage();
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		passwordField_2.setEchoChar('*');
		passwordField_2.setBounds(84, 136, 134, 27);
		panel_2.add(passwordField_2);
		
		JLabel refresh = new JLabel("");
		refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refreshTable();
				comboBoxadd();
				comboBoxadd1();
			}
		});
		refresh.setBounds(236, 11, 37, 27);
		panel_2.add(refresh);
		
		JLabel background3 = new JLabel("");
		background3.setBounds(0, 0, 481, 309);
		panel_2.add(background3);
		background3.setIcon(new ImageIcon(img8));
		refreshTable();
		comboBoxadd();
		comboBoxadd1();
		
		Image img9= new ImageIcon(this.getClass().getResource("/refresh.png")).getImage();
		refresh.setIcon(new ImageIcon(img9));
	}
}
