package pack1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

import pack1.entities.Owner;
import pack1.entities.OwnerDao;

public class OwnerLogin extends JFrame {

	private JPanel contentPane;
	private JTextField ownerid;
	private JPasswordField pass;
	private JButton reset;
	private JButton login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OwnerLogin frame = new OwnerLogin();
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
	public OwnerLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 120, 600, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Aman\\Downloads\\icons8-home-120.png"));
		lblNewLabel_1.setBounds(30, 11, 140, 134);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Rental Management System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(199, 37, 333, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Enter UserId");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(30, 215, 185, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Enter Password");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(30, 315, 185, 36);
		contentPane.add(lblNewLabel_2_1);
		
		ownerid = new JTextField();
		ownerid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				login.setEnabled(true);
				reset.setEnabled(true);
			}
		});
		ownerid.setFont(new Font("Tahoma", Font.BOLD, 18));
		ownerid.setHorizontalAlignment(SwingConstants.CENTER);
		ownerid.setBounds(185, 212, 290, 49);
		contentPane.add(ownerid);
		ownerid.setColumns(10);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.BOLD, 18));
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.setBounds(185, 309, 290, 54);
		contentPane.add(pass);
		
		login = new JButton("Login!!");
		login.setEnabled(false);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get text
				String user=ownerid.getText();
				String password=new String(pass.getPassword());
				System.out.println(user+""+password);
				OwnerDao odao=new OwnerDao();
				Owner ow=odao.checkLogin(Integer.parseInt(user), password);
				//if(user.equals("user101") && password.equals("12345"))
				if(ow!=null)
				{
					JOptionPane.showMessageDialog(getParent(), "Login successfully!!");
					OwnerProfile op=new OwnerProfile(ow);
					op.setVisible(true);
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(getParent(), "user id and password not match        !!");
				}
				
			}
		});
		login.setBackground(new Color(135, 206, 250));
		login.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		login.setBounds(54, 403, 140, 49);
		contentPane.add(login);
		
		reset = new JButton("Reset");
		reset.setEnabled(false);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ownerid.setText("");
				pass.setText("");
				
			}
		});
		reset.setBackground(new Color(135, 206, 250));
		reset.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		reset.setBounds(267, 403, 140, 49);
		contentPane.add(reset);
		
		JButton btnReset_1 = new JButton("");
		btnReset_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp=new HomePage();
				hp.setVisible(true);
				setVisible(false);
			}
		});
		btnReset_1.setIcon(new ImageIcon("C:\\Users\\Aman\\Downloads\\icons8-back.gif"));
		btnReset_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnReset_1.setBackground(new Color(135, 206, 250));
		btnReset_1.setBounds(205, 487, 102, 49);
		contentPane.add(btnReset_1);
		
		JLabel lblNewLabel_3 = new JLabel("PropertyOwner Login");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(0, 128, 128));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(156, 97, 362, 62);
		contentPane.add(lblNewLabel_3);
	}

}
