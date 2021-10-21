package dynamic.com.web.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dynamic.com.web.service.DatabaseConnection;
import mainpackage.*;
import java.sql.Timestamp;
import java.util.HashMap; 

/**
 * Servlet implementation class DoctorServlet
 */
@WebServlet("/DoctorServlet")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DoctorServlet() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{Connection connection = DatabaseConnection.initializeDatabase();
		 
		 String query = "select dateStart,doctor_id,Available from appointment";
		 	Statement st = connection.createStatement();
		 	ResultSet res = st.executeQuery(query);
		 	String dateToBeCanceled = request.getParameter("DateTime");
		 	String answer = "This appointment was never made";
		 	 
		 	while(res.next()) {
		 		if(Timestamp.valueOf(dateToBeCanceled)== res.getTimestamp("dateStart")) {
		 			answer= "appointment can be canceled";
		 		}
		 	
		 	}
		 
		 }catch(SQLException e) {
			 e.printStackTrace();
			 System.out.println(e);
			 //return "something went wrong";
		}catch(ClassNotFoundException e) {
			 e.printStackTrace();
			 System.out.println(e);
			// return "something went wrong";
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	public static String createHTMLSelectSection(){
		String select="";
		try{Connection connection = DatabaseConnection.initializeDatabase();
		 
		 String query = "select user_id,specialty,username from doctors ";
		 	Statement st = connection.createStatement();
		 	ResultSet res = st.executeQuery(query);
		 
		 	
		 	while(res.next()) {
		 		select+= "<option value='" +res.getString("user_id")+" '>"+res.getString("username")+", "+res.getString("specialty")+"</option>";
		 	}
		 	
		 	
		 }catch(SQLException e) {
			 e.printStackTrace();
			 System.out.println(e);
			
		}catch(ClassNotFoundException e) {
			 e.printStackTrace();
			 System.out.println(e);
			
		}
		return select;
	}


}
