package RetrieveDataFromDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dynamic.com.web.service.DatabaseConnection;
import mainpackage.Doctor;

public class GetDoctors {
	public static ArrayList<Doctor> getList() throws SQLException, ClassNotFoundException {
        ArrayList<Doctor> ArrayListDoctor = new ArrayList<Doctor>();
         
        try{Connection connection = DatabaseConnection.initializeDatabase();
		 
            String sql = "SELECT * FROM Doctors ";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
             
            while (result.next()) {
                int id = result.getInt("user_id");
                String username = result.getString("username");
                String specialty = result.getString("specialty");
                int admin_id = result.getInt("admin_id");
                
                Doctor Doctor = new Doctor(id,admin_id,specialty,username);
                     
                ArrayListDoctor.add(Doctor);
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
         
        return ArrayListDoctor;
    }
}
