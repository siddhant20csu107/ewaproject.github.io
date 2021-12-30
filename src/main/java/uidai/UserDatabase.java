package uidai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDatabase {
	public String validate(String mobile, String pass) throws SQLException {
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
	    String create_table = "create table if not exists registrationLogin (mobileNo VARCHAR(10) unique, Password VARCHAR(40), aadharNumber VARCHAR(12) unique)";
	    stmt.executeUpdate(create_table);
	    PreparedStatement pstmt = con.prepareStatement("insert into registrationLogin(mobileNo, Password) values(?,?)");
	    PreparedStatement pstmt1 = con.prepareStatement("UPDATE registrationLogin SET aadharNumber = ? WHERE mobileNo = ?;");
	    pstmt.setString(1,mobile);
	    pstmt.setString(2,pass);
	    int status=0;
	    String returningOnly="0";
	    try {
	    	status = pstmt.executeUpdate();
	    }
	    catch(Exception e) {
	    	status=0;
	    }
	    if(status!=0) {
	    	System.out.println("Added Successfully");
	    	boolean putting = true;
	    	while(putting) {
	    		RandomAadharNumber RandomAadhar = new RandomAadharNumber();
		    	String aadharNo = RandomAadhar.generateRandomNumber();
		    	pstmt1.setString(1, aadharNo);
		    	pstmt1.setString(2, mobile);
		    	int status1=0;
		    	try {
		    		status1 = pstmt1.executeUpdate();
		    	}
		    	catch(Exception e) {
		    		status1=0;
		    	}
		    	if(status1!=0) {
		    		System.out.println("Aadhar added successfully "+aadharNo);
		    		putting=false;
		    		returningOnly=aadharNo;
		    	}
		    	else {
		    		putting=true;
		    	}
	    	}
	    }
	    else {
	    	System.out.println("Already Exists");
	    	returningOnly="0";
	    }
	    return returningOnly; 
	}
}