<%@page import="RetrieveDataFromDB.GetDoctors"%>
<%@page import="dynamic.com.web.service.jsp.services.ShowDoctorAvailabilty"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="dynamic.com.web.service.DatabaseConnection" %> 
<%@ page import="java.util.ArrayList"%>
<%@ page import="mainpackage.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient's Page</title>
 <link rel="stylesheet" href="wsdl/style.css">
</head>
<body>
<div class="topNav">
			<h2>Local Hospital</h2>
			<div class="menu">
				<div class="choice"><a href="/DynamicWebProjext2021/index.html">Home</a></div>
				<div class="choice">Patients</div>
				<div class="choice">About Covid-19</div>
			</div>
		</div>
 <div style="margin-left:3em"><h2><span style="color:orange">${username} with id ${id}</span> welcome back to the hospital system</h2>
 
 
 <h2>User's appointments are:</h2>
 <%=mainpackage.Patient.Show((String) (request.getAttribute("id"))) %> 
 <hr>

 <h2>Check doctor availability</h2>

<%= dynamic.com.web.service.jsp.services.ShowDoctorAvailabilty.Show() %>
 <hr>
 <h2 style="">Cancel date</h2>
 <form action="CancelDate" method="get">
		<label for="DateTime">Date Time(for example 2022-02-01 14:10:10)</label>
		<input type="text" name="DateTime"><br>
		<label for="Doctor">Doctor</label>
		<input type="text" name="Doctor" ><br>
		<label for="id">id</label>
		<input type="text" name="id" value="${id}"><br>
		<input type="submit" value="Cancel">
</form>
<hr>
<h2 style="">Create date</h2>
 <form action="CreateDate" method="get">
		<label for="DateTime">Date Time(for example 2022-02-01 14:10:10)</label>
		<input type="text" name="DateTime"><br>
		<label for="Doctor">Doctor</label>
		<input type="text" name="Doctor" ><br>
		<label for="id">id</label>
		<input type="text" name="id" value="${id}"><br>
		<input type="submit" value="Create">
</form></div>
</body>
</html>