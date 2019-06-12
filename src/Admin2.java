import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Admin2 extends JFrame {

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
					Admin2 frame = new Admin2();
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
	public Admin2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("AdminLogin");
		lblAdminLogin.setBounds(187, 11, 65, 14);
		contentPane.add(lblAdminLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(61, 50, 59, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(61, 92, 46, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					   Class.forName("oracle.jdbc.driver.OracleDriver");
					   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","meena","8263");
					   Statement stmt=(Statement) con.createStatement();
					   ResultSet rs=((java.sql.Statement) stmt).executeQuery("select * from admin");
					   while(rs.next())
						   System.out.println(rs.getInt(1)+""+rs.getInt(2));
					   con.close();
				   }
				catch(Exception e1) {
					   System.out.println(e1);
				   }
			       }
			       }
			
		);
		btnLogin.setBounds(18, 212, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset.setBounds(187, 212, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setBounds(335, 212, 89, 23);
		contentPane.add(btnExit);
		
		textField = new JTextField();
		textField.setBounds(213, 47, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(213, 89, 86, 20);
		contentPane.add(passwordField);
	}

}
