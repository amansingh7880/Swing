package pack1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pack1.entities.Customer;
import pack1.entities.CustomerDao;

public class CustomerLogin extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField pass;
	private JButton login;
	private JButton reset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerLogin frame = new CustomerLogin();
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
	public CustomerLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Aman\\Downloads\\icons8-home-120.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 120, 650, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rental Management System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setBounds(248, 50, 333, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Aman\\Downloads\\icons8-home-120.png"));
		lblNewLabel_1.setBounds(78, 11, 140, 134);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Login Page");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(217, 96, 344, 49);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter User Id");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(58, 176, 189, 49);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Enter Password");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(58, 258, 189, 49);
		contentPane.add(lblNewLabel_3_1);
		
		userid = new JTextField();
		userid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				login.setEnabled(true);
				reset.setEnabled(true);
				
			}
		});
		userid.setFont(new Font("Tahoma", Font.BOLD, 18));
		userid.setBackground(new Color(240, 255, 240));
		userid.setHorizontalAlignment(SwingConstants.CENTER);
		userid.setBounds(231, 179, 273, 46);
		contentPane.add(userid);
		userid.setColumns(10);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.BOLD, 18));
		pass.setBackground(new Color(240, 255, 240));
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.setBounds(231, 269, 273, 49);
		contentPane.add(pass);
		//login button actionlistener get value
		login = new JButton("Login!");
		login.setEnabled(false);
		login.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//get value
				String id=userid.getText();
				String password=new String(pass.getPassword());
				System.out.println(id+" "+password);
			    CustomerDao cdao=new CustomerDao();
				Customer c= cdao.checkLogin(Integer.parseInt(id), password);
			//if(id.equals("user101") && password.equals("12345"))
				
				if(c!=null)
				{
					 JOptionPane.showMessageDialog(getParent(), "Login Successfull!!");
					 CustomerProfile cp=new CustomerProfile(c);
					 cp.setVisible(true);
					 setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(getParent(), "Usrid and password not match!!");
					
				}
			}
		});
		login.setBackground(new Color(100, 149, 237));
		login.setFont(new Font("Tahoma", Font.BOLD, 20));
		login.setBounds(147, 379, 130, 49);
		contentPane.add(login);
		
		reset = new JButton("Reset");
		reset.setEnabled(false);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userid.setText("");
				pass.setText("");
			}
		});
		reset.setBackground(new Color(100, 149, 237));
		reset.setFont(new Font("Tahoma", Font.BOLD, 20));
		reset.setBounds(342, 379, 130, 49);
		contentPane.add(reset);
		// back button action listener
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp=new HomePage();
				hp.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\Users\\Aman\\Downloads\\icons8-double-left.gif"));
		btnBack.setBounds(277, 462, 81, 49);
		contentPane.add(btnBack);
	}
}
