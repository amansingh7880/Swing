package pack1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Aman\\Downloads\\icons8-home-120.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 120, 700, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rental Management System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(214, 37, 333, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Aman\\Downloads\\icons8-home-120.png"));
		lblNewLabel_1.setBounds(45, 11, 140, 134);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Aman\\Downloads\\images (3).jpeg"));
		lblNewLabel_2.setBounds(55, 131, 177, 319);
		contentPane.add(lblNewLabel_2);
		//customer login acction listener
		JButton btnNewButton = new JButton("Customer Login!!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLogin cl=new CustomerLogin();
				cl.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(261, 199, 231, 49);
		contentPane.add(btnNewButton);
		JButton btnLogin = new JButton("Property Owner Login!!");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OwnerLogin ol=new OwnerLogin();
				ol.setVisible(true);
				setVisible(false);
			}
		});
		btnLogin.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 17));
		btnLogin.setBackground(new Color(0, 128, 128));
		btnLogin.setBounds(261, 304, 231, 49);
		contentPane.add(btnLogin);
		
		JButton btnNewButton_1 = new JButton("Customer Signup");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerRegister cr=new CustomerRegister();
				cr.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.setForeground(new Color(230, 230, 250));
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton_1.setBounds(521, 193, 153, 62);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Owner Signup");
		btnNewButton_1_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1_1.setForeground(new Color(230, 230, 250));
		btnNewButton_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(521, 297, 153, 62);
		contentPane.add(btnNewButton_1_1);
	}
}
