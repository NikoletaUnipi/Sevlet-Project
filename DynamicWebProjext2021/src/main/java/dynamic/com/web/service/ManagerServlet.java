package dynamic.com.web.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ManagerServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try{
			//Connection with database usersdb
			Connection connection = DatabaseConnection.initializeDatabase();
			System.out.println("Succesfully connected to database");
			String usernameInput = request.getParameter("userName");//username input
				
			String query ="select * from users where username='"+usernameInput+"'";
				
				 		Statement statement= connection.createStatement();						
						
						ResultSet results = statement.executeQuery(query);
						
						String pass=request.getParameter("passWord");
						//while there are more results
						if(results.next()) {
							//if the input password is correct	
							if(HashNSalt.CheckForEquality(pass, results.getString("salt") , results.getString("password"))){
									
								request.setAttribute("username",usernameInput );
								request.setAttribute("id",results.getString("id") );
								String typeOfUser =results.getString("type");
								switch(typeOfUser) {
									case "admin":
										RequestDispatcher dispatcher0 =request.getRequestDispatcher("WEB-INF/views/adminLogged.jsp");
										dispatcher0.forward(request, response);
										break;
									case "doctor":
										RequestDispatcher dispatcher1 =request.getRequestDispatcher("WEB-INF/views/doctorLogged.jsp");
										dispatcher1.forward(request, response);
										break;
									case "patient":
										RequestDispatcher dispatcher2 =request.getRequestDispatcher("WEB-INF/views/patientLogged.jsp");
										dispatcher2.forward(request, response);
										break;
									default:
										break;
									
								}
								
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
