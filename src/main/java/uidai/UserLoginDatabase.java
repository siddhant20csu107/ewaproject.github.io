package uidai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserLoginDatabase {
	public String validate(String mobile, String pass) throws SQLException, ClassNotFoundException{
		boolean status=false;
		String returningOnly="0";
		String url = "jdbc:mysql://localhost/";
		String user = "root";
		String password = "Siddhant@2002";
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
		con = DriverManager.getConnection(url,user,password);
	    Statement stmt = con.createStatement();
	    String sql = "create database if not exists aadhar";
	    stmt.executeUpdate(sql);
	    System.out.println("Database created successfully...");  
	    String useDB = "use aadhar";
	    stmt.executeUpdate(useDB);
	    String create_table = "create table if not exists registrationLogin (mobileNo VARCHAR(10) unique, Password VARCHAR(40), aadharNumber VARCHAR(12) unique)";
	    stmt.executeUpdate(create_table);
	    PreparedStatement pstmt = con.prepareStatement("select * from registrationLogin where mobileNo = ? and Password = ? ");
	    PreparedStatement pstmt1 = con.prepareStatement("select * from registrationLogin where mobileNo = ?");
	    pstmt.setString(1, mobile);
        pstmt.setString(2, pass);
        ResultSet rs = pstmt.executeQuery();
        status = rs.next();
        if(status==true) {
			pstmt1.setString(1,mobile);
			ResultSet rs1 = pstmt1.executeQuery();
			while (rs1.next()) {
				returningOnly = rs1.getString(3);
			}
		}
		else {
			returningOnly="0";
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return returningOnly;
	}
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
