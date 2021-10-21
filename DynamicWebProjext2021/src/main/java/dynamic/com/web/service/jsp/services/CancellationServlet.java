package dynamic.com.web.service.jsp.services;

import java.io.IOException;
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

/**
 * Servlet implementation class CancellationServlet
 */
@WebServlet("/CancellationServlet")
public class CancellationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CancellationServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{Connection connection = DatabaseConnection.initializeDatabase();
		 
		 String query = "select dateStart,doctor_id,Available from appointment";
		 Statement st = connection.createStatement();
		 int updateCount = st.executeUpdate("UPDATE appointment SET Available='True', patient_id='"+request.getParameter("id")+"' WHERE dateStart = '"+ request.getParameter("DateTime") +"'");
		 	/*ResultSet res = st.executeQuery(query);
		 	String dateToBeCanceled = request.getParameter("DateTime");
		 	String answer = "This appointment was never made";
		 	while(res.next()) {
		 		if(Timestamp.valueOf(dateToBeCanceled)== res.getTimestamp("dateStart")) {
		 			answer= "appointment can be canceled";
		 		}
		 	
		 	}*/
		 System.out.print(updateCount);
		 if(updateCount==1) {
			 response.getWriter().append("The appointment was canceled succesfully!");
		 }else {
			 response.getWriter().append("Something went wrong");
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
		

	}

}
