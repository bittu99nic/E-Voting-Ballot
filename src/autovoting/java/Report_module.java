package autovoting.java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

public class Report_module extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JComboBox comboBox;
	private JLabel win;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report_module frame = new Report_module();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void refreshTable() {
		try {
			String query4="select * from election_info";
			PreparedStatement pst4=connection.prepareStatement(query4);
			ResultSet rs4=pst4.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs4));
			}
			catch(Exception e3) {
				e3.getStackTrace();
			}
	}
	public void refreshTable_1() {
		try {
			String query4="select * from report_info";
			PreparedStatement pst4=connection.prepareStatement(query4);
			ResultSet rs4=pst4.executeQuery();
			
			table_1.setModel(DbUtils.resultSetToTableModel(rs4));
			
			pst4.close();
			}
			catch(Exception e3) {
				e3.getStackTrace();
			}
	}
	public void partywin() {
		try {
			String query="select * from report_info";
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet rs4=ps.executeQuery();
			int max=-1;
			while(rs4.next()) {
				if(Integer.parseInt(rs4.getString("vote"))>max) {
					max=Integer.parseInt(rs4.getString("vote"));
					win.setText(rs4.getString("party_name"));
				}else {
					win.setText("Draw");
				}
			}
			
		}catch(Exception e3) {
			e3.getStackTrace();
		}
	}
	
	Connection connection=null;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	
	public void refreshTable_2() {
		try {
			String query4="select first_name,last_name,dob,mobile_no,voter_uid from voter_info";
			PreparedStatement pst4=connection.prepareStatement(query4);
			ResultSet rs4=pst4.executeQuery();
			
			table_2.setModel(DbUtils.resultSetToTableModel(rs4));
			
			pst4.close();
			}
			catch(Exception e3) {
				e3.getStackTrace();
			}
	}
	/**
	 * Create the frame.
	 */
	public Report_module() {
		setResizable(false);
		setTitle("Report");
		connection=sqlConnection.dbConnector();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 505, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 489, 325);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Voter Enquiry", null, panel, null);
		panel.setLayout(null);
		
		JLabel mlabel = new JLabel("");
		mlabel.setBackground(new Color(0, 0, 0));
		mlabel.setForeground(new Color(255, 228, 225));
		mlabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		mlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		mlabel.setBounds(40, 178, 81, 26);
		panel.add(mlabel);
		
		JLabel fnlabel = new JLabel("");
		fnlabel.setBackground(new Color(0, 0, 0));
		fnlabel.setForeground(new Color(255, 228, 225));
		fnlabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		fnlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		fnlabel.setBounds(40, 117, 81, 26);
		panel.add(fnlabel);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		textFieldSearch.setBounds(101, 21, 214, 37);
		panel.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Search:");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 228, 225));
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 32, 81, 20);
		panel.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Voter_UID", "Mobile_no"}));
		comboBox.setFont(new Font("Segoe UI Emoji", Font.BOLD, 12));
		comboBox.setBounds(325, 21, 81, 37);
		panel.add(comboBox);
		
		JLabel lnlabel = new JLabel("");
		lnlabel.setBackground(new Color(0, 0, 0));
		lnlabel.setForeground(new Color(255, 228, 225));
		lnlabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		lnlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lnlabel.setBounds(246, 117, 81, 26);
		panel.add(lnlabel);
		
		JLabel fntext = new JLabel("");
		fntext.setForeground(new Color(224, 255, 255));
		fntext.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		fntext.setBounds(131, 117, 119, 26);
		panel.add(fntext);
		
		JLabel lntext = new JLabel("");
		lntext.setForeground(new Color(224, 255, 255));
		lntext.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lntext.setBounds(337, 117, 125, 26);
		panel.add(lntext);
		
		JLabel mtext = new JLabel("");
		mtext.setForeground(new Color(224, 255, 255));
		mtext.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		mtext.setBounds(131, 178, 119, 26);
		panel.add(mtext);
		
		JLabel doblabel = new JLabel("");
		doblabel.setBackground(new Color(0, 0, 0));
		doblabel.setForeground(new Color(255, 228, 225));
		doblabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		doblabel.setHorizontalAlignment(SwingConstants.RIGHT);
		doblabel.setBounds(246, 178, 81, 26);
		panel.add(doblabel);
		
		JLabel dobtext = new JLabel("");
		dobtext.setForeground(new Color(224, 255, 255));
		dobtext.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		dobtext.setBounds(337, 178, 125, 26);
		panel.add(dobtext);
		
		JLabel uidlabel = new JLabel("");
		uidlabel.setBackground(new Color(0, 0, 0));
		uidlabel.setForeground(new Color(255, 228, 225));
		uidlabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		uidlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		uidlabel.setBounds(120, 236, 76, 26);
		panel.add(uidlabel);
		
		JLabel uidtext = new JLabel("");
		uidtext.setForeground(new Color(224, 255, 255));
		uidtext.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		uidtext.setBounds(206, 236, 168, 26);
		panel.add(uidtext);
		
		JLabel minibg = new JLabel("");
		minibg.setHorizontalAlignment(SwingConstants.CENTER);
		minibg.setBounds(50, 95, 370, 195);
		panel.add(minibg);
		
		JLabel welcome = new JLabel("");
		welcome.setBackground(new Color(75, 0, 130));
		welcome.setForeground(new Color(248, 248, 255));
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font("Mongolian Baiti", Font.BOLD, 21));
		welcome.setBounds(55, 80, 370, 26);
		panel.add(welcome);
		
		JLabel searchicon = new JLabel("");
		searchicon.setHorizontalAlignment(SwingConstants.CENTER);
		searchicon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int c;
					c=0;
					String selection=(String)comboBox.getSelectedItem();
					String query="select * from voter_info where "+selection+"=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textFieldSearch.getText());
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
						c++;
						minibg.setIcon(new ImageIcon());
						welcome.setText("Welcome Voter");
						fnlabel.setText("First name:");
						lnlabel.setText("Last name:");
						mlabel.setText("Mobile no.:");
						doblabel.setText("D.O.B:");
						uidlabel.setText("Voter UID:");
						fntext.setText(rs.getString("first_name"));
						lntext.setText(rs.getString("last_name"));
						mtext.setText(rs.getString("mobile_no"));
						uidtext.setText(rs.getString("voter_uid"));
						dobtext.setText(rs.getString("dob"));
					}
					if(c==0) {
						welcome.setText("OOOOOPS!! You are not registered!");
						Image img8 = new ImageIcon(this.getClass().getResource("/minibg.png")).getImage();
						minibg.setIcon(new ImageIcon(img8));
						fnlabel.setText("");
						lnlabel.setText("");
						mlabel.setText("");
						doblabel.setText("");
						uidlabel.setText("");
						fntext.setText("");
						lntext.setText("");
						mtext.setText("");
						uidtext.setText("");
						dobtext.setText("");
					}
				}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(null,e3);
				}
			}
		});
		searchicon.setBounds(416, 11, 46, 55);
		panel.add(searchicon);
		
		JLabel background1 = new JLabel("");
		background1.setBounds(0, 0, 484, 297);
		panel.add(background1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Result Enquiry", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(255, 182, 193));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(25, 81, 182, 205);
		panel_1.add(label);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(229, 11, 233, 275);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(255, 218, 185));
		table_1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 165, 0), new Color(0, 255, 0), new Color(0, 255, 0), new Color(255, 165, 0)), null));
		scrollPane_1.setViewportView(table_1);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Schedule Enquiry", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 461, 276);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(175, 238, 238));
		table.setForeground(new Color(47, 79, 79));
		table.setFont(new Font("Rockwell", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Voter List", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(21, 11, 442, 275);
		panel_3.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setBackground(new Color(255, 228, 225));
		table_2.setFont(new Font("Rockwell", Font.BOLD, 11));
		table_2.setForeground(new Color(139, 0, 139));
		scrollPane_2.setViewportView(table_2);
		
		JLabel background4 = new JLabel("");
		background4.setBounds(0, 0, 484, 297);
		panel_3.add(background4);
		setIconImage(new ImageIcon(getClass().getResource("/appicon.png")).getImage());
		
		Image img2 = new ImageIcon(this.getClass().getResource("/minibg1.png")).getImage();
		minibg.setIcon(new ImageIcon(img2));
		
		Image img5 = new ImageIcon(this.getClass().getResource("/mini3.png")).getImage();
		label.setIcon(new ImageIcon(img5));
		
		JLabel lblNewLabel_1 = new JLabel("Congratulations  to");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(255, 165, 0));
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(41, 21, 148, 26);
		panel_1.add(lblNewLabel_1);
		
		win = new JLabel("");
		win.setForeground(new Color(255, 235, 205));
		win.setHorizontalAlignment(SwingConstants.CENTER);
		win.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		win.setBounds(36, 48, 53, 33);
		panel_1.add(win);
		
		JLabel lblNewLabel_3 = new JLabel("Supporters!!");
		lblNewLabel_3.setForeground(new Color(0, 255, 0));
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(97, 48, 110, 34);
		panel_1.add(lblNewLabel_3);
		
		JLabel background2 = new JLabel("");
		background2.setBounds(0, 0, 484, 297);
		panel_1.add(background2);
		
		
		Image img3 = new ImageIcon(this.getClass().getResource("/background1.png")).getImage();
		background1.setIcon(new ImageIcon(img3));
		
		Image img4 = new ImageIcon(this.getClass().getResource("/searchicon.png")).getImage();
		searchicon.setIcon(new ImageIcon(img4));
		
		Image img7 = new ImageIcon(this.getClass().getResource("/background2.png")).getImage();
		background2.setIcon(new ImageIcon(img7));
		
		Image img9 = new ImageIcon(this.getClass().getResource("/background3.png")).getImage();
		JLabel background3 = new JLabel("");
		background3.setBounds(0, 0, 484, 297);
		panel_2.add(background3);
		background3.setIcon(new ImageIcon(img9));
		background4.setIcon(new ImageIcon(img9));
		
		refreshTable_1();
		refreshTable_2();
		refreshTable();
		partywin();
	}
}
