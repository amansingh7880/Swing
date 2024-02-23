package pack1.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OwnerDao {
	Connection con;
	Statement st;
	ResultSet rs;
	public OwnerDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Connection created");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rental","root","root");
			System.out.println("Database is connceted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//checklogin userid and password for owner
	public Owner checkLogin(int id,String password)
	{
		Owner ow=null;
		try {
			st=con.createStatement();
			rs=st.executeQuery("select * from landlord where landlord_id='"+id+"' and password='"+password+"'");
			//rs=st.executeQuery("select * from customer where customer_id='"+id+"'and password='"+password+"'");
			if(rs.next())
			{
				ow=new Owner();
				ow.setLandlord_id(rs.getInt(1));
				ow.setName(rs.getString(2));
				ow.setPassword(rs.getString(3));
				ow.setAddress(rs.getString(4));
				ow.setPhone(rs.getLong(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ow;
	}
}
