package pack1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import pack1.entities.Customer;
import pack1.entities.CustomerDao;
import javax.swing.ImageIcon;

public class CustomerRegister extends JFrame {

	private JPanel aptype;
	private JTextField uname;
	private JTextField houseno;
	private JTextField locality;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JFormattedTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerRegister frame = new CustomerRegister();
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
	public CustomerRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 20, 750, 700);
		aptype = new JPanel();
		aptype.setToolTipText("Select Multiple Opction ctrl key");
		aptype.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(aptype);
		aptype.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rental Management System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(205, 0, 333, 49);
		aptype.add(lblNewLabel);
		
		JLabel lblCustomerRegistraion = new JLabel("Customer Registraion");
		lblCustomerRegistraion.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerRegistraion.setForeground(new Color(0, 0, 0));
		lblCustomerRegistraion.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblCustomerRegistraion.setBounds(215, 36, 333, 26);
		aptype.add(lblCustomerRegistraion);
		
		JLabel lblNewLabel_3 = new JLabel("Enter User Id");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 73, 214, 38);
		aptype.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Enter Password");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(10, 122, 214, 38);
		aptype.add(lblNewLabel_3_1);
		
		JPasswordField upass = new JPasswordField("");
		upass.setFont(new Font("Tahoma", Font.BOLD, 18));
		upass.setBounds(247, 125, 346, 33);
		aptype.add(upass);
		
		JTextField userid = new JTextField("");
		userid.setFont(new Font("Tahoma", Font.BOLD, 18));
		userid.setBounds(247, 78, 346, 33);
		aptype.add(userid);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Name");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_2.setBounds(10, 171, 214, 38);
		aptype.add(lblNewLabel_3_1_2);
		
		uname = new JTextField("");
		uname.setFont(new Font("Tahoma", Font.BOLD, 18));
		uname.setBounds(247, 169, 346, 33);
		aptype.add(uname);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("House No");
		lblNewLabel_3_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_2_1.setBounds(10, 277, 127, 38);
		aptype.add(lblNewLabel_3_1_2_1);
		
		houseno = new JTextField("");
		houseno.setFont(new Font("Tahoma", Font.BOLD, 18));
		houseno.setBounds(145, 277, 153, 38);
		aptype.add(houseno);
		
		JLabel lblNewLabel_3_1_2_1_1 = new JLabel("Locality");
		lblNewLabel_3_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_2_1_1.setBounds(324, 277, 107, 38);
		aptype.add(lblNewLabel_3_1_2_1_1);
		
		locality = new JTextField("");
		locality.setFont(new Font("Tahoma", Font.BOLD, 18));
		locality.setBounds(441, 277, 152, 38);
		aptype.add(locality);
		
		JLabel lblNewLabel_3_1_2_1_2 = new JLabel("City");
		lblNewLabel_3_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_2_1_2.setBounds(10, 328, 127, 38);
		aptype.add(lblNewLabel_3_1_2_1_2);
		
		JLabel lblNewLabel_3_1_2_1_1_1 = new JLabel("State");
		lblNewLabel_3_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_2_1_1_1.setBounds(324, 327, 107, 38);
		aptype.add(lblNewLabel_3_1_2_1_1_1);
		Data ob=new Data();
		//get total number of city
		int count=0;
		for(int r=0;r<ob.citystate.length;r++)
			for(int c=0;c<ob.citystate[r].length;c++)
				count++;
		
		System.out.println(count);
		String cities[]=new String[count];
		int i=0;
		for(int r=0;r<ob.citystate.length;r++)
			for(int c=0;c<ob.citystate[r].length;c++,i++)
		{
			cities[i]=ob.citystate[r][c];
		}
		JComboBox city = new JComboBox(cities);
		city.setBounds(145, 340, 153, 26);
		aptype.add(city);
		AutoCompleteDecorator.decorate(city);
		
		JComboBox state = new JComboBox(ob.state);
		state.setBounds(440, 340, 153, 26);
		aptype.add(state);
		AutoCompleteDecorator.decorate(state);
		
		JLabel lblNewLabel_3_1_2_1_2_1 = new JLabel("Gender");
		lblNewLabel_3_1_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_2_1_2_1.setBounds(10, 388, 127, 49);
		aptype.add(lblNewLabel_3_1_2_1_2_1);
		
		JRadioButton male = new JRadioButton("Male");
		buttonGroup.add(male);
		male.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 17));
		male.setBounds(115, 404, 109, 23);
		aptype.add(male);
		
		JRadioButton female = new JRadioButton("FeMale");
		buttonGroup.add(female);
		female.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 17));
		female.setBounds(277, 404, 109, 23);
		aptype.add(female);
		
		JLabel lblNewLabel_3_1_2_1_2_1_1 = new JLabel("Select Apartement Type");
		lblNewLabel_3_1_2_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1_2_1_2_1_1.setBounds(10, 448, 198, 49);
		aptype.add(lblNewLabel_3_1_2_1_2_1_1);
		
		JCheckBox onebhk = new JCheckBox("1BHK");
		onebhk.setFont(new Font("Tahoma", Font.BOLD, 15));
		onebhk.setBounds(224, 463, 97, 23);
		aptype.add(onebhk);
		
		JCheckBox twobhk = new JCheckBox("2BHK");
		twobhk.setSelected(true);
		twobhk.setFont(new Font("Tahoma", Font.BOLD, 15));
		twobhk.setBounds(334, 463, 97, 23);
		aptype.add(twobhk);
		
		JCheckBox threebhk = new JCheckBox("3BHK");
		threebhk.setFont(new Font("Tahoma", Font.BOLD, 15));
		threebhk.setBounds(441, 463, 97, 23);
		aptype.add(threebhk);
		
		JLabel lblNewLabel_3_1_2_1_2_1_1_1 = new JLabel("Select Rental Type");
		lblNewLabel_3_1_2_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1_2_1_2_1_1_1.setBounds(10, 508, 173, 49);
		aptype.add(lblNewLabel_3_1_2_1_2_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(171, 515, 117, 72);
		aptype.add(scrollPane);
		
		JList rtype = new JList();
		rtype.setToolTipText("Select multiple list ctrl key");
		rtype.setFont(new Font("Tahoma", Font.BOLD, 15));
		rtype.setModel(new AbstractListModel() {
			String[] values = new String[] {"Weakly", "Monthly", "Quaterly", "HalfYearly", "Yearly"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(rtype);
		
		JButton register = new JButton("Register");
		register.setFont(new Font("Sylfaen", Font.BOLD, 20));
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get all the value
				Customer c=new Customer();
				c.setCusromer_id(Integer.parseInt(userid.getText()));
				c.setName(uname.getText());
				c.setPassword(new String(upass.getPassword()));
				String add=houseno.getText()+","+locality.getText()+","+city.getSelectedItem()+","+state.getSelectedItem();
				c.setAddress(add);
				c.setPhone(Long.parseLong(phone.getText()));
				c.setGender(male.isSelected()?"male":"female");
				c.setAtype(onebhk.isSelected()?"1BHK ":" "+(twobhk.isSelected()?"2BHK ":" ")+(threebhk.isSelected()?"3BHK ":" "));  
				c.setRtype(rtype.getSelectedValuesList().toString());	
				CustomerDao cdao=new CustomerDao();
				int saveRecords=cdao.saveRecords(c);
				if(saveRecords==1)
					JOptionPane.showMessageDialog(getParent(),"Records save Successfully!");
				else
					JOptionPane.showMessageDialog(getParent(),"Records unable");
			}
		});
		register.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		register.setBounds(102, 608, 117, 42);
		aptype.add(register);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userid.setText("");
				upass.setText("");
				uname.setText("");
				phone.setText("");
				houseno.setText("");
				locality.setText("");
			}
		});
		reset.setFont(new Font("Sylfaen", Font.BOLD, 20));
		reset.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		reset.setBounds(277, 608, 117, 42);
		aptype.add(reset);		
		JLabel lblNewLabel_3_1_2_2 = new JLabel("Mobile No");
		lblNewLabel_3_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_2_2.setBounds(10, 222, 214, 38);
		aptype.add(lblNewLabel_3_1_2_2);
		
		phone = new JFormattedTextField();
		phone.setFont(new Font("Tahoma", Font.BOLD, 18));
		phone.setBounds(247, 220, 346, 33);
		aptype.add(phone);
		
		JButton Back = new JButton("");
		Back.setIcon(new ImageIcon("C:\\Users\\Aman\\Downloads\\icons8-back.gif"));
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp=new HomePage();
				hp.setVisible(true);
				setVisible(false);
			}
		});
		Back.setFont(new Font("Sylfaen", Font.BOLD, 20));
		Back.setBackground(SystemColor.activeCaption);
		Back.setBounds(461, 608, 97, 42);
		aptype.add(Back);
	}
}
