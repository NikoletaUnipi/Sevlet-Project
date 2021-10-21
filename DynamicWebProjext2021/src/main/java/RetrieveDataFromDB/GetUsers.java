package RetrieveDataFromDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dynamic.com.web.service.DatabaseConnection;
import mainpackage.Users;

public class GetUsers {
	public ArrayList<Users> ArrayList() throws SQLException,ClassNotFoundException {
        ArrayList<Users> ArrayListUsers = new ArrayList<Users>();
         
        try{Connection connection = DatabaseConnection.initializeDatabase();
		 
            String sql = "SELECT * FROM users ";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
             
            while (result.next()) {
                int id = result.getInt("id");
                String username = result.getString("username");
                String name = result.getString("name");
                String surname = result.getString("surname");
                String password = result.getString("password");
                String type= result.getString("type");
                Users user = new Users(id, username,name,password,surname,type);
                     
                ArrayListUsers.add(user);
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
         
        return ArrayListUsers;
    }
}
