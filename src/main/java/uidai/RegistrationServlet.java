package uidai;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("upass");
		String AbleToAddOrNot = "0";
		UserDatabase checking = new UserDatabase();
		try {
			AbleToAddOrNot = checking.validate(mobile,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!"0".equals(AbleToAddOrNot)) {
			UserAddressInsertDatabase checking1 = new UserAddressInsertDatabase();
			int verifying = 0;
			try {
				verifying = checking1.validate(AbleToAddOrNot);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String aadharNo = AbleToAddOrNot;
			out.println("  \r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					 
					+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "<style>\r\n"
					+ "body {\r\n"
					+ "  overflow-x: hidden;\r\n"
					+ "  overflow-y: hidden;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "* {\r\n"
					+ "  margin: 0;\r\n"
					+ "  padding: 0;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".admin{\r\n"
					+ "	height: 100%;\r\n"
					+ "	width: 100%;\r\n"
					+ "	background-image: linear-gradient(rgba(0,0,0,0.4),rgba(0,0,0,0.4)),url(\"https://t4.ftcdn.net/jpg/01/30/50/59/360_F_130505941_aHM5DQifhmVGcs80xVUPPMfDjg5BBm3c.jpg\");\r\n"
					+ " 	background-position: center;\r\n"
					+ " 	background-size: cover;\r\n"
					+ " 	position: absolute;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".form-box{\r\n"
					+ "	width: 380px;\r\n"
					+ "	height: 400px;\r\n"
					+ "	background-image: url(\"https://media.istockphoto.com/vectors/abstract-white-background-vector-id1142563796?k=20&m=1142563796&s=612x612&w=0&h=kZABOtzW6eQOMZvDuLHiNsh-mM_2o9slZKq6-GN6W64=\");\r\n"
					+ "	position: relative;\r\n"
					+ "	margin: 6% auto;\r\n"
					+ "	/background: white;/\r\n"
					+ "	padding: 5px;\r\n"
					+ "	border-style: solid;\r\n"
					+ "	border-color:#F1C40F;\r\n"
					+ "	border-width: 8px;\r\n"
					+ "}\r\n"
					+ ".button1 {\r\n"
					+ "  background: linear-gradient(to right, #ff105f,#ffad06);\r\n"
					+ "  border: none;\r\n"
					+ "  color: white;\r\n"
					+ "  cursor: pointer;\r\n"
					+ "  padding: 14px 40px;\r\n"
					+ "  text-align: center;\r\n"
					+ "  display: inline-block;\r\n"
					+ "  text-decoration: none;\r\n"
					+ "  font-size: 25px;\r\n"
					+ "  border-radius: 8px;\r\n"
					+ "  transition-duration: 0.4s;\r\n"
					+ "  width: 50%;\r\n"
					+ "  margin-left: 60px;\r\n"
					+ "  \r\n"
					+ "}\r\n"
					+ " \r\n"
					+ ".button2 {\r\n"
					+ "  background: linear-gradient(to right, #ff105f,#ffad06);\r\n"
					+ "  border: none;\r\n"
					+ "  color: white;\r\n"
					+ "  cursor: pointer;\r\n"
					+ "  padding: 14px 40px;\r\n"
					+ "  text-align: center;\r\n"
					+ "  display: inline-block;\r\n"
					+ "  text-decoration: none;\r\n"
					+ "  font-size: 25px;\r\n"
					+ "  border-radius: 8px;\r\n"
					+ "  transition-duration: 0.4s;\r\n"
					+ "  width: 50%;\r\n"
					+ "  margin-left: 60px;\r\n"
					+ "  \r\n"
					+ "}\r\n"
					+ "</style>\r\n"
					+ "\r\n"
					+ "<title>UIDAI</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<table>\r\n"
					+ " 		<tr>\r\n"
					+ " 			<td>\r\n"
					+ " 				<img src = \"https://hranker.com/blog/wp-content/uploads/2021/03/government-of-india.jpg\" style = \"float: left; width:200px;height:90px; margin-right:240px\">\r\n"
					+ " 			</td>\r\n"
					+ " 			<td>\r\n"
					+ " 				<h1 style = \"font-size: 30px\">UIDAI - Unique Identification Authority Of India</h1>\r\n"
					+ " 			</td>\r\n"
					+ " 			<td>\r\n"
					+ " 				<img src = \"https://theindiasaga.com/wp-content/uploads/2020/06/cat_politics183-750x400.png\"style = \"float: right; width:200px; height:100px; margin-left:250px\">\r\n"
					+ " 			</td>\r\n"
					+ " 		</tr>\r\n"
					+ " 	</table> \r\n"
					+ "	<div class = \"admin\">\r\n"
					+ "		<div class = \"form-box\">\r\n"
					+ "				<h1 style=\"font-size: 30px; margin-top: 20px;\">SuccessFully Registered!</h1><br><br><br><br>\r\n"
					+ "             <h3 style=\"font-size: 30px; margin-top: 20px;\">Your New Aadhar Number: "+aadharNo+"</h3><br><br><br><br>\r\n"
					
					+ "<form action=\"AuthServlet\">"
					+ "<input type='hidden' name='uadhar' value='"+aadharNo+"'>"
					+ "<input type='submit' class=\"button1\" value='Proceed Further'>"
					+ "</form><br><br><br>\r\n"
					
					+ "		</div>\r\n"
					+ "	</div>\r\n"
					+ "	 \r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
		else {
			out.println("  \r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					 
					+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "<style>\r\n"
					+ "body {\r\n"
					+ "  overflow-x: hidden;\r\n"
					+ "  overflow-y: hidden;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "* {\r\n"
					+ "  margin: 0;\r\n"
					+ "  padding: 0;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".admin{\r\n"
					+ "	height: 100%;\r\n"
					+ "	width: 100%;\r\n"
					+ "	background-image: linear-gradient(rgba(0,0,0,0.4),rgba(0,0,0,0.4)),url(\"https://t4.ftcdn.net/jpg/01/30/50/59/360_F_130505941_aHM5DQifhmVGcs80xVUPPMfDjg5BBm3c.jpg\");\r\n"
					+ " 	background-position: center;\r\n"
					+ " 	background-size: cover;\r\n"
					+ " 	position: absolute;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".form-box{\r\n"
					+ "	width: 380px;\r\n"
					+ "	height: 400px;\r\n"
					+ "	background-image: url(\"https://media.istockphoto.com/vectors/abstract-white-background-vector-id1142563796?k=20&m=1142563796&s=612x612&w=0&h=kZABOtzW6eQOMZvDuLHiNsh-mM_2o9slZKq6-GN6W64=\");\r\n"
					+ "	position: relative;\r\n"
					+ "	margin: 6% auto;\r\n"
					+ "	/background: white;/\r\n"
					+ "	padding: 5px;\r\n"
					+ "	border-style: solid;\r\n"
					+ "	border-color:#F1C40F;\r\n"
					+ "	border-width: 8px;\r\n"
					+ "}\r\n"
					+ ".button1 {\r\n"
					+ "  background: linear-gradient(to right, #ff105f,#ffad06);\r\n"
					+ "  border: none;\r\n"
					+ "  color: white;\r\n"
					+ "  cursor: pointer;\r\n"
					+ "  padding: 14px 40px;\r\n"
					+ "  text-align: center;\r\n"
					+ "  display: inline-block;\r\n"
					+ "  text-decoration: none;\r\n"
					+ "  font-size: 25px;\r\n"
					+ "  border-radius: 8px;\r\n"
					+ "  transition-duration: 0.4s;\r\n"
					+ "  width: 50%;\r\n"
					+ "  margin-left: 60px;\r\n"
					+ "  \r\n"
					+ "}\r\n"
					+ " \r\n"
					+ ".button2 {\r\n"
					+ "  background: linear-gradient(to right, #ff105f,#ffad06);\r\n"
					+ "  border: none;\r\n"
					+ "  color: white;\r\n"
					+ "  cursor: pointer;\r\n"
					+ "  padding: 14px 40px;\r\n"
					+ "  text-align: center;\r\n"
					+ "  display: inline-block;\r\n"
					+ "  text-decoration: none;\r\n"
					+ "  font-size: 25px;\r\n"
					+ "  border-radius: 8px;\r\n"
					+ "  transition-duration: 0.4s;\r\n"
					+ "  width: 50%;\r\n"
					+ "  margin-left: 60px;\r\n"
					+ "  \r\n"
					+ "}\r\n"
					+ "</style>\r\n"
					+ "\r\n"
					+ "<title>UIDAI</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<table>\r\n"
					+ " 		<tr>\r\n"
					+ " 			<td>\r\n"
					+ " 				<img src = \"https://hranker.com/blog/wp-content/uploads/2021/03/government-of-india.jpg\" style = \"float: left; width:200px;height:90px; margin-right:240px\">\r\n"
					+ " 			</td>\r\n"
					+ " 			<td>\r\n"
					+ " 				<h1 style = \"font-size: 30px\">UIDAI - Unique Identification Authority Of India</h1>\r\n"
					+ " 			</td>\r\n"
					+ " 			<td>\r\n"
					+ " 				<img src = \"https://theindiasaga.com/wp-content/uploads/2020/06/cat_politics183-750x400.png\"style = \"float: right; width:200px; height:100px; margin-left:250px\">\r\n"
					+ " 			</td>\r\n"
					+ " 		</tr>\r\n"
					+ " 	</table> \r\n"
					+ "	<div class = \"admin\">\r\n"
					+ "		<div class = \"form-box\">\r\n"
					+ "				<h1 style=\"font-size: 30px; margin-top: 20px;\">Mobile Already Registered!</h1><br><br><br><br>\r\n"
					
					+ "<form>"
					+ "<input type=\"button\" class=\"button1\" value=\"Go back!\" onclick=\"history.back()\">"
					+ "</form>"
					
					+ "		</div>\r\n"
					+ "	</div>\r\n"
					+ "	 \r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
	}

}
