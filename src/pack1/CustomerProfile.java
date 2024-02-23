package pack1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pack1.entities.Customer;



public class CustomerProfile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CustomerProfile frame = new CustomerProfile();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public CustomerProfile(Customer cs) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Aman\\Downloads\\icons8-home-120.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome In "+cs.getName());
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-46, 91, 576, 84);
		contentPane.add(lblNewLabel);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLogin cl=new CustomerLogin();
				cl.setVisible(true);
				setVisible(false);
			}
		});
		logout.setHorizontalAlignment(SwingConstants.CENTER);
		logout.setForeground(Color.RED);
		logout.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		logout.setBounds(498, 0, 136, 52);
		contentPane.add(logout);
		
		JButton btnNewButton = new JButton("Submit Feedback");
		btnNewButton.setBackground(new Color(204, 204, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FeedbackDemo fd=new FeedbackDemo(cs.getCid());
				fd.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(102, 153, 255));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Stencil", Font.BOLD, 17));
		btnNewButton.setBounds(116, 186, 223, 44);
		contentPane.add(btnNewButton);
		
		JButton btnSubmitFeedback = new JButton("Find Property Details");
		btnSubmitFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindRental fd=new FindRental();
				fd.setVisible(true);
				setVisible(false);
			}
		});
		btnSubmitFeedback.setForeground(new Color(102, 153, 255));
		btnSubmitFeedback.setFont(new Font("Stencil", Font.BOLD, 17));
		btnSubmitFeedback.setBorder(null);
		btnSubmitFeedback.setBackground(new Color(204, 204, 255));
		btnSubmitFeedback.setBounds(116, 265, 223, 44);
		contentPane.add(btnSubmitFeedback);
	}
}
