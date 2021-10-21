package mainpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import dynamic.com.web.service.DatabaseConnection;

import jakarta.servlet.ServletException;

public class Patient extends Users {
	private int id;
	final private String AMKA;	
	private ArrayList<String> appointments = new ArrayList<String>();
	public Patient(String AMKA,int id){
		super(); 
		this.id=id;
		this.AMKA = AMKA;
	}
	String get_AMKA() {
		return AMKA;
	}
	
	public static String Show(String p_id) {
			try{
			Connection connection = DatabaseConnection.initializeDatabase();
			 
			 String query = "select dateStart from appointment where patient_id='"+p_id+"'";
			 	Statement st = connection.createStatement();
			 	ResultSet res = st.executeQuery(query);
			 	
			 	StringBuilder sb = new StringBuilder();
			 	
			 	while(res.next()) {
			 		sb.append(res.getString("dateStart"));
			 	}
			 	return sb.toString();
			 }catch(SQLException e) {
				 e.printStackTrace();
				 System.out.println(e);
				 return "something went wrong";
			}catch(ClassNotFoundException e) {
				 e.printStackTrace();
				 System.out.println(e);
				 return "something went wrong";
			}
			
	}
	
	public void set_appointment(String a) {
		appointments.add(a);
	}
	
	
	
	
	
	String find_an_appointment(Doctor doctor) {
		
		String appointment="this doctor is full";
	
		return appointment;
	}
	
	String find_specialty(ArrayList<Doctor> doctors,String specialty) {
		String result="No doctor found with that specialty";
		
		return result;
	}
	
	/*static String show_doctor_appointments(String patient_id) {
		return Show(patient_id);
		
		
		
	}*/
	
}
