package uidai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAddressInsertDatabase {
	public int validate(String aadharNo) throws SQLException{
		String url = "jdbc:mysql://localhost/";
		String user = "root";
		String password = "Siddhant@2002";
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Class not found");
		} 
		con = DriverManager.getConnection(url,user,password);
	    Statement stmt = con.createStatement();
	    String sql = "create database if not exists aadhar";
	    stmt.executeUpdate(sql);
	    System.out.println("Database created successfully...");  
	    String useDB = "use aadhar";
	    stmt.executeUpdate(useDB);
	    String create_table = "create table if not exists address (aadharNo VARCHAR(12) unique, hNo VARCHAR(40), street VARCHAR(40), area VARCHAR(40), landmark VARCHAR(40), town VARCHAR(40), subDistrict VARCHAR(40), district VARCHAR(40), state VARCHAR(40), pin INT(6), finalAddress VARCHAR(100))";
        stmt.executeUpdate(create_table);
        PreparedStatement pstmt = con.prepareStatement("insert into address(aadharNo) values (?)");
        pstmt.setString(1, aadharNo);
        int status = 0;
        status = pstmt.executeUpdate();
        return status;
	}
}
