package pack1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import pack1.entities.CustomerDao;

public class FindRental extends JFrame {

	private JPanel contentPane;
	String data[][];
	int r,c;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindRental frame = new FindRental();
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
	public FindRental() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 30, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 153));
		panel_1.setBounds(0, 5, 834, 606);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 834, 422);
		scrollPane.setBackground(new Color(153, 153, 255));
		scrollPane.setFont(new Font("Times New Roman", Font.BOLD, 18));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_1.add(scrollPane);
		
		String headings[]={"PropertyId","Apratment Type","Amenities","Furnish","Rental Type","Location","SecurityDeposit","Rent","OwnerName","OwnerContact"};
		data=new String[10][10];
		table = new JTable(data,headings);
		table.setFillsViewportHeight(true);
		table.setPreferredSize(new Dimension(950, 400));
		table.setMaximumSize(new Dimension(500, 160));
		table.setPreferredScrollableViewportSize(new Dimension(850, 400));
		table.setAlignmentX(Component.RIGHT_ALIGNMENT);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		table.setGridColor(new Color(153, 51, 51));
		table.setFont(new Font("Times New Roman", Font.BOLD, 20));
		table.setForeground(new Color(153, 153, 204));
		table.setBackground(new Color(204, 204, 255));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setFont(new Font("SnasSerif",Font.BOLD,12));
		for(int i=0;i<10;i++)
			//System.out.println(i);
		table.getColumnModel().getColumn(i).setPreferredWidth(120);
		//table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.setRowHeight(40);
		scrollPane.setViewportView(table);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 433, 834, 173);
		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 204));
		panel_1.add(panel);
		
		JLabel lblNewLabel = new JLabel("Select Apartment Type");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 175, 35);
		panel.add(lblNewLabel);
		
		JComboBox atype = new JComboBox();
		atype.setFont(new Font("Tahoma", Font.BOLD, 18));
		atype.setModel(new DefaultComboBoxModel(new String[] {"--Select Aprtment Type--", "1BHK", "2BHK", "3BHK"}));
		atype.setBounds(187, 19, 253, 22);
		panel.add(atype);
		
		JComboBox rtype = new JComboBox();
		rtype.setFont(new Font("Tahoma", Font.BOLD, 17));
		rtype.setModel(new DefaultComboBoxModel(new String[] {"--Select Retal Type--", "Weakly", "Monthly", "Half Yearly", "Quaterly", "Yearly"}));
		rtype.setBounds(187, 71, 214, 22);
		panel.add(rtype);
		
		JLabel lblNewLabel_1 = new JLabel("Select Reantal Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 63, 181, 35);
		panel.add(lblNewLabel_1);
		
		JLabel lblMax = new JLabel("Maximum Rent");
		lblMax.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMax.setBounds(450, 11, 110, 35);
		panel.add(lblMax);
		
		JTextField max = new JTextField();
		max.setFont(new Font("Tahoma", Font.BOLD, 17));
		max.setBounds(581, 19, 156, 22);
		panel.add(max);
		
		JLabel lblManimumRent = new JLabel("Minimum Rent");
		lblManimumRent.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblManimumRent.setBounds(449, 63, 111, 35);
		panel.add(lblManimumRent);
		
		JTextField min = new JTextField();
		min.setFont(new Font("Tahoma", Font.BOLD, 17));
		min.setBounds(581, 71, 156, 22);
		panel.add(min);
		
		JButton btnNewButton = new JButton("Find Rental Opction");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get the values of data
			  String aptype= String.valueOf(atype.getSelectedItem());
			  String rntype=String.valueOf(rtype.getSelectedItem());
			  Float minrent=Float.parseFloat(min.getText());
			  Float maxrent=Float.parseFloat(max.getText());
			  CustomerDao cdao=new CustomerDao();
			  String data1[][]=cdao.getRecords(aptype,rntype,minrent,maxrent);
			 
			  for(int r=0;r<data.length;r++)
			  {
				  for(int c=0;c<data[r].length;c++)
				  {
					  
					  data[r][c]=data1[r][c];
					  System.out.print(data[r][c]+"\t");
				  }
					  
				  System.out.println();
			  }
			  table.updateUI();			  
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(10, 116, 181, 51);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(241, 116, 99, 51);
		panel.add(btnNewButton_1);
		//panel_1.add(table);
		
		
		
	}
}
