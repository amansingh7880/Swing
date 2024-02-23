package guiswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Swingdemo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swingdemo frame = new Swingdemo();
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
	public Swingdemo() {
		setTitle("Notepad");
		setBackground(SystemColor.text);
		setForeground(SystemColor.textHighlightText);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Aman\\Downloads\\note.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500); // col row width and height
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 128, 128));
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new LineBorder(SystemColor.activeCaption, 2, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("                    My First Page");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(176, 11, 324, 36);
		contentPane.add(lblNewLabel);
	}
}
