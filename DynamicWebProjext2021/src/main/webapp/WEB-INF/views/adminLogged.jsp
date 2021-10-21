<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="dynamic.com.web.service.DatabaseConnection" %> 
<%@ page import="java.util.ArrayList"%>
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
 <div style="margin-left:3em"><h2><span style="color:orange">Admin ${username}</span> welcome back to the hospital system</h2>
</body>
</html>