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
 * Servlet implementation class CreateAppointmentsServlet
 */
@WebServlet("/CreateAppointmentsServlet")
public class CreateAppointmentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreateAppointmentsServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{Connection connection = DatabaseConnection.initializeDatabase();
		 
		 
		 Statement st = connection.createStatement();
		 int updateCount = st.executeUpdate("UPDATE appointment SET Available='False', patient_id='"+request.getParameter("id")+"' WHERE dateStart = '"+ request.getParameter("DateTime") +"'");
		 
		 System.out.print(updateCount);
		 if(updateCount==1) {
			 response.getWriter().append("The appointment was made succesfully!");
		 }else {
			 response.getWriter().append("Something went wrong");
		 }
		 
		 }catch(SQLException e) {
			 e.printStackTrace();
			 System.out.println(e);
			 
		}catch(ClassNotFoundException e) {
			 e.printStackTrace();
			 System.out.println(e);
			
		}
		

	}
		
}




