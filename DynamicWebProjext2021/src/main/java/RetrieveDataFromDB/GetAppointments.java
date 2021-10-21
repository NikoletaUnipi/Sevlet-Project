package RetrieveDataFromDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dynamic.com.web.service.DatabaseConnection;
import mainpackage.Appointment;

public class GetAppointments {
	public ArrayList<Appointment> ArrayList() throws SQLException, ClassNotFoundException {
        ArrayList<Appointment> ArrayListAppointment = new ArrayList<Appointment>();
         
        try{Connection connection = DatabaseConnection.initializeDatabase();
		 
            String sql = "SELECT * FROM appointment ";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
             
            while (result.next()) {
                int id = result.getInt("appointment_id");
                int patient_id = result.getInt("patient_id");
                int doctor_id=result.getInt("doctor_id");
                String d_Start = result.getString("dateStart");
                String a= result.getString("Available");
                Appointment appointment = new Appointment(d_Start, patient_id, doctor_id,id, a);
                     
                ArrayListAppointment.add(appointment);
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
         
        return ArrayListAppointment;
    }
}
