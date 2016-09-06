package sql_con;

import java.sql.*;  

public class sql_con_demo{
	public static void main(String args[]){  
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/new_schema","root","12345");  
		  
		//here sonoo is database name, root is username and password  
		  
		Statement stmt=con.createStatement();  
		  
		ResultSet rs=stmt.executeQuery("select * from login");  
		  
		while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
		  
		PreparedStatement ps = con.prepareStatement("update  login set name = ? where id = ?");
		ps.setString(1, "Amit Kumar");
		ps.setInt(2, 1);
		ps.executeUpdate();
		
		System.out.println("---------------------------------------------");
		rs=stmt.executeQuery("select * from login");  
		  
		while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
		
		
		
		
		con.close();  
		  
		}catch(Exception e){ System.out.println(e);}  
	  
		}  
	
}  
