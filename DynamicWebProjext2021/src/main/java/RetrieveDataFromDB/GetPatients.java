package RetrieveDataFromDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dynamic.com.web.service.DatabaseConnection;
import mainpackage.Patient;



public class GetPatients {
	public ArrayList<Patient> ArrayList() throws SQLException, ClassNotFoundException {
        ArrayList<Patient> ArrayListPatient = new ArrayList<Patient>();
         
        try{Connection connection = DatabaseConnection.initializeDatabase();
		 
            String sql = "SELECT * FROM patients ";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
             
            while (result.next()) {
                int id = result.getInt("user_id");
               // String username = result.getString("username");
                String AMKA = result.getString("AMKA");
                //String password = result.getString("password");
                Patient patient = new Patient(AMKA,id);
                     
                ArrayListPatient.add(patient);
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
         
        return ArrayListPatient;
    }
}
