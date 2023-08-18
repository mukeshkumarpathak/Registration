package in.sp.back;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
	private String URL="jdbc:mysql://localhost:3306/rdb";
	private String User="root";
	private String Password="";
	private String Driver="com.mysql.jdbc.Driver";
	
	public void loadDriver(String Driver)
	{
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Connection getConnection()
	{
		Connection connection=null;
		try {
			connection = DriverManager.getConnection(URL,User,Password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(connection);
	}
	
	
	public String insert(Member member)
	{
		loadDriver(Driver);
		Connection con=getConnection();
		String sql="insert into rmem values(?,?,?,?)";
		String result="Data entered successfully";
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,member.getUname());
			ps.setString(2,member.getPassword());
			ps.setString(3,member.getEmail());
			ps.setString(4,member.getPhone());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="Data not entered";
			
		}
		

		
		
		return(result);
	}
	
}
