package RetrieveDataFromDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dynamic.com.web.service.DatabaseConnection;
import mainpackage.Admin;

public class GetAdmins {
	public ArrayList<Admin> ArrayList() throws SQLException, ClassNotFoundException {
        ArrayList<Admin> ArrayListAdmin = new ArrayList<Admin>();
         
        try{Connection connection = DatabaseConnection.initializeDatabase();
		 
            String sql = "SELECT * FROM Admins ";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
             
            while (result.next()) {
                int id = result.getInt("user_id");
                String username = result.getString("username");
              
                
                Admin Admin = new Admin(id,username);
                     
                ArrayListAdmin.add(Admin);
            }          
             
        }catch(SQLException e) {
			 e.printStackTrace();
			 System.out.println(e);
			 throw e;
		}catch(ClassNotFoundException e) {
			 e.printStackTrace();
			 System.out.println(e);
			throw e;
		}  
         
        return ArrayListAdmin;
    }
}
