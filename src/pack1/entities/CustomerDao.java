package pack1.entities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao {
Connection con;
//Statement st;
PreparedStatement st;
ResultSet rs;
public CustomerDao(){
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver connection created");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rental","root","root");
		System.out.println("Database is connected");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
//check login id id and password
public Customer checkLogin(int id,String password)
{
	Customer c=null;
	try {
		//st=con.createStatement();
		st=con.prepareStatement("select * from customer where customer_id= ? and password=?");
        st.setInt(1, id);
        st.setString(2, password);
		//rs=st.executeQuery("select * from customer where customer_id='"+id+"'and password='"+password+"'");
		rs=st.executeQuery();	
		if(rs.next())
		{
			c=new Customer();
			c.setCusromer_id(rs.getInt(1));
			c.setName(rs.getString(2));
			c.setPassword(rs.getString(3));
			c.setAddress(rs.getString(4));
			c.setPhone(rs.getLong(5));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return c;
	
}
public int saveRecords(Customer c)
{
	int status=0;
	try {
		st=con.prepareStatement("insert into customer values(?,?,?,?,?,?)");
		st.setInt(1,c.getCid());
		st.setString(2,c.getName());
		st.setString(3, c.getPassword());
		st.setString(4,c.getAddress());
		st.setLong(5,c.getPhone());
		st.setString(6,c.getGender());
		status=st.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
	
}
public int updateFeedback(int i, String text) {
	// TODO Auto-generated method stub
	int status=0;
	try {
		st=con.prepareStatement("update customer set feedback=? where customer_id=?");
		st.setString(1, text);
		st.setInt(2, i);
		status=st.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}
public String[][] getRecords(String aptype, String rntype, Float minrent, Float maxrent) {
	// TODO Auto-generated method stub
	String data[][]=null;
	try {
		CallableStatement cs=con.prepareCall("{call filterRecords(?,?,?,?)}");
		cs.setString(1,aptype);
		cs.setString(2,rntype);
		cs.setFloat(3,minrent);
		cs.setFloat(4,maxrent);
		data=new String[10][10];
		int r=0,c=0;
		rs=cs.executeQuery();
		while(rs.next())
		{
			 c=0;
			 data[r][c++]=String.valueOf(rs.getInt(1));//landlordid
			 data[r][c++]=rs.getString(2);//aptype
			 data[r][c++]=rs.getString(3);//amenties
			 data[r][c++]=rs.getString(4);//furnish
			 data[r][c++]=rs.getString(5);//rtype
			 data[r][c++]=rs.getString(6);//location
			 data[r][c++]=String.valueOf(rs.getFloat(7));//scercurity
			 data[r][c++]=String.valueOf(rs.getFloat(8));//rent
			 data[r][c++]=rs.getString(9);//owner Name
			 data[r++][c]=String.valueOf(rs.getLong(10));//phone
			 
			 
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return data;
}
}
