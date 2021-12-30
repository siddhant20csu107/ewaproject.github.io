package uidai;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String aadharNo = request.getParameter("uaadhar");
		String hNo = request.getParameter("hNo");
		String street = request.getParameter("street");
		String area = request.getParameter("area");
		String landmark = request.getParameter("landmark");
		String town = request.getParameter("town");
		String subDistrict = request.getParameter("subDistrict");
		String district = request.getParameter("district");
		String state = request.getParameter("state");
		String pincode = request.getParameter("pincode");
		
		String regex = "[0-9]+";

        Pattern p = Pattern.compile(regex);
  
        // Find match between given string and regular expression using Pattern.matcher()
        Matcher aadh = p.matcher(aadharNo);
        Matcher pinc = p.matcher(pincode);
        
        boolean aadharDigit = aadh.matches(); //returns true only if aadhar number contains all digits
        boolean pinDigit = pinc.matches(); //returns true only if pincode contains all digits
        
        //Sets the content type as HTML
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (aadharDigit && pinDigit)   //This loop is only executed if aadhar number and pincode contains only digits
		{
		
			//Stores the user input
			UserUpdateInput use = new UserUpdateInput(aadharNo,hNo,street, area, landmark, town, subDistrict, district, state, pincode);
			
			UserUpdateDatabase database = new UserUpdateDatabase();

			try 
			{
				if (database.getConnection() != null) //This loop is only executed if connection is established properly
				{
					database.insertAndFormatting(use);  //Inserts and formats the data

					String fadd = database.selectAddress(use.getAadharNo());  //Returns formatted address
					
					if(fadd!=null)    //Prints the formatted address alongwith aadhar number
					{
						
						out.println("<html>"
								+"<head>"
								+"<style>"
								+ "div {"
								+ "  background-color: #F8F8FF;"
								+ "  width: 1100px;"
								+ "  height: 450px;"
								+ "  border: 10px solid 	#191970;"
								+ "  padding: 50px;"
								+ "  margin-left: 20px;"
								+ "  margin-right: 20px;"
								+ "  margin-top: 20px;"
								+ "  margin-bottom: 20px;"
								+ "}"
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
								+ "</style>"
								+"<title>"
								+"Address"
								+"</title>"
								+"</head>"
								+"<body>"
								+"<div>"
								+"<br><p><center><font size = 1600px; color = #8B4513><b><u> FORMATTED ADDRESS </u></b></font></center></p>"
								+"<br><br><p><center><font size = 30px><b>Aadhar number: </b>"+use.getAadharNo()+"</font></center></p>"
								+"<p><center><font size = 30px><b>Addresss: </b>"+fadd+"</font></center></p>"
								+"<br><br><p><center><font size =150px; color = #000000>Updated Successfully!!<br>Thank you!!</font></center></p>"
								+ "<center><form>"
								+ "<input type=\"button\" class=\"button1\" value=\"Go back To Change Information!\" onclick=\"history.back()\">"
								+ "</form>"
								+ "<form action=\"AuthServlet\">"
								+ "<input type='hidden' name='uadhar' value='"+aadharNo+"'>"
								+ "<input type='submit' class=\"button1\" value='Proceed Further To Main Menu'>"
								+ "</form></center><br><br><br>\r\n"
								+"</div>"
								+"</body>"
								+"</html>");
						
					} 
					
					else      // It is printed if finalAddress value is not found
					{	
						out.println("<html>"
								+ "<head>"
								+ "<style>"
								+ "h1{color: red}"
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
								+ "</style>"
								+ "</head>"
								+"<body>"
								+"<h1>Error!! Final Address Not Found!</h1>"
								+ "<form>"
								+ "<input type=\"button\" class=\"button1\" value=\"Go back!\" onclick=\"history.back()\">"
								+ "</form>"
								+"</body>"
								+"</html");
					}
				}
			}
			
			catch (Exception e) {
		
				out.println("<html>"
						+ "<head>"
						+ "<style>"
						+ "h1{color: red}"
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
						+ "</style>"
						+ "</head>"
						+"<body>"
						+"<h1>Connection not established!!</h1>"
						+ "<form>"
						+ "<input type=\"button\" class=\"button1\" value=\"Go back!\" onclick=\"history.back()\">"
						+ "</form>"
						+"</body>"
						+"</html");	  
			}
		}
		else if (aadharDigit == false)  //It is executed when aadhar number contains one or more alphabet/ special character
		{
		        out.println("<html>"
				+"<head>"
				+"<style>"
				+ "div {"
				+ "  background-color: #F8F8FF;"
				+ "  width: 600px;"
				+ "  height: 150px;"
				+ "  border: 10px solid 	#191970;"
				+ "  padding: 50px;"
				+ "  margin-left: 300px;"
				+ "  margin-right: 20px;"
				+ "  margin-top: 150px;"
				+ "  margin-bottom: 20px;"
				+ "}"
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
				+ "</style>"
				+"<title>"
				+"Address"
				+"</title>"
				+"</head>"
				+"<body>"
				+"<div>"				
				+"<br><p><center><font size = 2000px; color = #8B4513><b> Incorrect Aadhar number!! </b></font></center></p>"	 
				+ "<form>"
				+ "<input type=\"button\" class=\"button1\" value=\"Go back!\" onclick=\"history.back()\">"
				+ "</form>"
				+"</div>"
				+"</body>"
				+"</html>");
		}
			
		else if(pinDigit==false)  //It is executed when pincode contains one or more alphabet/ special character
		{
		    out.println("<html>"
				+"<head>"
				+"<style>"
				+ "div {"
				+ "  background-color: #F8F8FF;"
				+ "  width: 600px;"
				+ "  height: 150px;"
				+ "  border: 10px solid 	#191970;"
				+ "  padding: 50px;"
				+ "  margin-left: 300px;"
				+ "  margin-right: 20px;"
				+ "  margin-top: 150px;"
				+ "  margin-bottom: 20px;"
				+ "}"
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
				+ "</style>"
				+"<title>"
				+"Address"
				+"</title>"
				+"</head>"
				+"<body>"
				+"<div>"				
				+"<br><p><center><font size = 2000px; color = #8B4513><b> Incorrect Pincode!! </b></font></center></p>"
				+ "<form>"
				+ "<input type=\"button\" class=\"button1\" value=\"Go back!\" onclick=\"history.back()\">"
				+ "</form>"
				+"</div>"
				+"</body>"
				+"</html>");
		}
		
		}
}
