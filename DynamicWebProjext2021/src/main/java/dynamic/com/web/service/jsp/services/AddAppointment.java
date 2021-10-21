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
 * Servlet implementation class AddAppointment
 */
@WebServlet("/AddAppointment")
public class AddAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddAppointment() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{Connection connection = DatabaseConnection.initializeDatabase();
		 
		// String query = "select dateStart,doctor_id,Available from appointment";
		 Statement st = connection.createStatement();
		 int patientId = Integer.parseInt( request.getParameter("patientId"));
		 int doctorId=Integer.parseInt(request.getParameter("id"));
		 String time=request.getParameter("DateTime");
		 String availabilty="True";
		 int updateCount= st.executeUpdate("INSERT INTO appointment " + "VALUES ("+patientId+","+doctorId+","+time+","+availabilty+")");
		
		 System.out.print(updateCount);
		 if(updateCount==1) {
			 response.getWriter().append("The appointment was canceled succesfully!");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
