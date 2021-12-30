<!DOCTYPE html>
<html>
<head>
<script src="cities.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: #FEF5E7;
  overflow-x: hidden;
}

* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

/* Add padding to containers */
.container {
  padding: 15px;
  background-color: white;
}
 
/* Full-width input fields */
input[type=text], input[type=password], input[type=number] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus, input[type=number]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
h1{
font-size: 50px;
font-family: Georgia;

}
/* Set a style for the submit button */
.submitbtn {
   background: linear-gradient(to right, #2ECC71 ,#82E0AA);
  color: white;
  font-size: 30px;
  padding: 12px 16px;
  margin: 2px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.submitbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

</style>
<title>UIDAI</title>
</head>
<body>

<form action = "UpdateServlet" method = "post">
  <div class="container">

<table>
 		<tr>
 			<td>
 				<img src = "https://hranker.com/blog/wp-content/uploads/2021/03/government-of-india.jpg" style = "float: left; width:200px;height:90px; margin-right:162px">
 			</td>
 			<td>
 				<h1 style = "font-size: 30px">UIDAI - Unique Identification Authority Of India</h1>
 			</td>
 			<td>
 				<img src = "https://theindiasaga.com/wp-content/uploads/2020/06/cat_politics183-750x400.png"style = "float: right; width:200px; height:100px; margin-left:170px">
 			</td>
 		</tr>
 	</table> 
  
<p style= "color: white; text-align: center; font-size: 200%;  background: linear-gradient(to right, #2ECC71 ,#82E0AA); padding: 10px 14px;"><b><i>WELCOME TO UPDATE YOUR AADHAAR CORNER</i></b></p>
 
<p style = "color: red; background-color:#F0FFF0; font-size: 100%; padding: 8px 12px;"><marquee scrollamount="12"> <b>Note: All * are mandatory fields.&emsp;&emsp;&emsp;&emsp;Please Provide Us Your Details Correctly</b></marquee></p>
    
    <label for="adhar"><b>Aadhar number <span style="color: #ff0000">*</span></b></label>
    <%
   //get parameters from the request
   String uadharname = request.getParameter("uadhar");
	%>
   <input type="text" name="adhar" disabled value="<%=uadharname%>">
   <%out.println("<input type='hidden' name='uaadhar' value='"+uadharname+"'>"); %>

    <label for="hNo"><b>House No <span style="color: #ff0000">*</span></b></label>
    <input type="text" placeholder="Enter House no" name = "hNo" required>

    <label for="street"><b>Street/Road/Lane</b></label>
    <input type="text" placeholder="Enter Street/Road/Lane" name = "street">

    <label for="area"><b>Area/Locality/Sector <span style="color: #ff0000">*</span></b></label>
    <input type="text" placeholder="Enter Area/Locality/Sector" name = "area" required>

    <label for="lmark"><b>Landmark</b></label>
    <input type="text" placeholder="Enter Landmark" name = "landmark">

    <label for="vill"><b>Village/Town/City <span style="color: #ff0000">*</span></b></label>
    <input type="text" placeholder="Enter Village/Town/City" name = "town" required>

    <label for="sd"><b>Sub-District <span style="color: #ff0000">*</span></b></label>
    <input type="text" placeholder="Enter Sub-District" name = "subDistrict" required>

    <label for="dist"><b>District <span style="color: #ff0000">*</span></b></label>
    <input type="text" placeholder="Enter District" name = "district" required>
    
    
    <label for="state"><b>State <span style="color: #ff0000">*</span></b></label><br>
    <select style="min-height:40px;width: 100%;" id="state" name="state" required>
    <option disabled selected="selected">State / Union Territory</option>
      <option>Andaman and Nicobar Islands</option>
      <option>Andhra Pradesh</option>
      <option>Arunachal Pradesh</option>
      <option>Assam</option>
      <option>Bihar</option>
      <option>Chandigarh</option>
      <option>Chhattisgarh</option>
      <option>Dadra & Nagar Haveli and Daman & Diu</option>
      <option>Delhi</option>
      <option>Goa</option>
      <option>Gujarat</option>
      <option>Haryana</option>
      <option>Himachal Pradesh</option>
      <option>Jammu and Kashmir</option>
      <option>Jharkhand</option>
      <option>Karnataka</option>
      <option>Kerala</option>
      <option>Ladakh</option>
      <option>Lakshadweep</option>
      <option>Madhya Pradesh</option>
      <option>Maharashtra</option>
      <option>Manipur</option>
      <option>Meghalaya</option>
      <option>Mizoram</option>
      <option>Nagaland</option>
      <option>Odisha</option>
      <option>Puducherry</option>
      <option>Punjab</option>
      <option>Rajasthan</option>
      <option>Sikkim</option>
      <option>Tamil Nadu</option>
      <option>Telangana</option>
      <option>Tripura</option>
      <option>Uttar Pradesh</option>
      <option>Uttarakhand</option>
      <option>West Bengal</option>
    </select>
    <br><br>

    <label for="pin"><b>Pincode <span style="color: #ff0000">*</span></b></label>
    <input type="text" class = "input-field" placeholder="Enter pincode" name = "pincode" minlength = "6" maxlength = "6" required>
    <hr>
    
    <select onchange="print_city('state', this.selectedIndex);" id="sts" name ="stt" class="form-control" required></select>
<select id ="state" class="form-control" required></select>
<script language="javascript">print_state("sts");</script>
    
    <button type="submit" class="submitbtn">Update Me</button>
  </div>
  
</form>
</body>
</html>