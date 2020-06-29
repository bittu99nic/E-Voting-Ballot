package autovoting.java;

import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePage {

	private JFrame frmElectronicVotingWa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frmElectronicVotingWa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
		connection=sqlConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmElectronicVotingWa = new JFrame();
		frmElectronicVotingWa.setResizable(false);
		frmElectronicVotingWa.setTitle("Atomated Ballot Voting");
		frmElectronicVotingWa.setBounds(100, 100, 519, 481);
		frmElectronicVotingWa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmElectronicVotingWa.getContentPane().setLayout(null);
	
		JLabel labelAdmin = new JLabel("");
		labelAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		labelAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmElectronicVotingWa.setVisible(true);
				admin_login ad=new admin_login();
				ad.setVisible(true);
			}
		});
		labelAdmin.setBounds(52, 38, 157, 151);
		frmElectronicVotingWa.getContentPane().add(labelAdmin);
		
		JLabel lblNewLabel = new JLabel("ADMIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblNewLabel.setBounds(91, 200, 69, 14);
		frmElectronicVotingWa.getContentPane().add(lblNewLabel);
		
		JLabel labelUser = new JLabel("");
		labelUser.setHorizontalAlignment(SwingConstants.CENTER);
		labelUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmElectronicVotingWa.setVisible(true);
				User_module um=new User_module();
				um.setVisible(true);
			}
		});
		labelUser.setBounds(301, 38, 157, 151);
		frmElectronicVotingWa.getContentPane().add(labelUser);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblUser.setBounds(341, 200, 54, 14);
		frmElectronicVotingWa.getContentPane().add(lblUser);
		
		JLabel labelVoter = new JLabel("");
		labelVoter.setHorizontalAlignment(SwingConstants.CENTER);
		labelVoter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmElectronicVotingWa.setVisible(true);
				Voter_module vm=new Voter_module();
				vm.setVisible(true);
			}
		});
		labelVoter.setBounds(52, 239, 157, 151);
		frmElectronicVotingWa.getContentPane().add(labelVoter);
		
		JLabel lblVoter = new JLabel("VOTER");
		lblVoter.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoter.setForeground(Color.WHITE);
		lblVoter.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblVoter.setBounds(102, 401, 58, 14);
		frmElectronicVotingWa.getContentPane().add(lblVoter);
		
		JLabel labelReport = new JLabel("");
		labelReport.setHorizontalAlignment(SwingConstants.CENTER);
		labelReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmElectronicVotingWa.setVisible(true);
				Report_module rm=new Report_module();
				rm.setVisible(true);
			}
		});
		labelReport.setBounds(301, 239, 157, 151);
		frmElectronicVotingWa.getContentPane().add(labelReport);
		
		
		JLabel lblReport = new JLabel("REPORT");
		lblReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblReport.setForeground(Color.WHITE);
		lblReport.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblReport.setBounds(341, 401, 69, 14);
		frmElectronicVotingWa.getContentPane().add(lblReport);
		frmElectronicVotingWa.setIconImage(new ImageIcon(getClass().getResource("/appicon.png")).getImage());
		
		Image img = new ImageIcon(this.getClass().getResource("/admin.png")).getImage();
		labelAdmin.setIcon(new ImageIcon(img));
		
		JLabel labelbackground = new JLabel("");
		labelbackground.setBounds(0, 0, 513, 452);
		frmElectronicVotingWa.getContentPane().add(labelbackground);
		Image img2 = new ImageIcon(this.getClass().getResource("/homepage.png")).getImage();
		labelbackground.setIcon(new ImageIcon(img2));
		
		Image img3= new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		labelUser.setIcon(new ImageIcon(img3));
		
		Image img4 = new ImageIcon(this.getClass().getResource("/vote.png")).getImage();
		labelVoter.setIcon(new ImageIcon(img4));
		
		Image img5 = new ImageIcon(this.getClass().getResource("/report.png")).getImage();
		labelReport.setIcon(new ImageIcon(img5));
	}
}
