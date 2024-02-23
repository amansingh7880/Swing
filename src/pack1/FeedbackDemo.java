package pack1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pack1.entities.CustomerDao;

public class FeedbackDemo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FeedbackDemo frame = new FeedbackDemo();
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
	public FeedbackDemo(int i) {
		setBounds(550, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome In"+i);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setBounds(0, 0, 534, 84);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Your Feedback");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 105, 189, 49);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 149, 401, 159);
		contentPane.add(scrollPane);
		
		JTextArea feedback = new JTextArea();
		feedback.setFont(new Font("Monospaced", Font.BOLD, 15));
		scrollPane.setViewportView(feedback);
		
		JButton btnNewButton = new JButton("SubmitFeedback");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerDao cdao=new CustomerDao();
				int status=cdao.updateFeedback(i,feedback.getText());
				if(status==1)
				{
					JOptionPane.showMessageDialog(getParent(), "Feedback Submit Successfully!!");
					setVisible(false);
				
				}
				else
				{
					JOptionPane.showMessageDialog(getParent(), "Unable Feedback Sumited");
				}
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton.setBounds(260, 310, 151, 51);
		contentPane.add(btnNewButton);
	}
}
