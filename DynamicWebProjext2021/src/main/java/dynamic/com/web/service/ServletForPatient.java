package dynamic.com.web.service;

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

/**
 * Servlet implementation class ServletForPatient
 */
@WebServlet("/ServletForPatient")
public class ServletForPatient extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
    public ServletForPatient() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
			Connection connection = DatabaseConnection.initializeDatabase();
			System.out.println("Succesfully connected to database");
			String usernameInput = request.getParameter("userName");
				
			String query ="select * from patients where username='"+usernameInput+"'";
				
						
				 		Statement statement= connection.createStatement();
						
						
						ResultSet results = statement.executeQuery(query);
						
						String pass=request.getParameter("passWord");
						
						if(results.next()) {
							
							if(pass.equals(results.getString("password"))) {
									
								request.setAttribute("patient_name",usernameInput );
								request.setAttribute("id",results.getString("user_id") );
								RequestDispatcher dispatcher =request.getRequestDispatcher("WEB-INF/views/patientLogged.jsp");
								dispatcher.forward(request, response);
							}else {
								response.getWriter().println("password incorrect");
							}
						}else {
							response.getWriter().println("User doesn't exist in database");
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
