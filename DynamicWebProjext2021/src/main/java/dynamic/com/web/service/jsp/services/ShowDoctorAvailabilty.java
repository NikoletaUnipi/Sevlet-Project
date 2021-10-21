package dynamic.com.web.service.jsp.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dynamic.com.web.service.DatabaseConnection;
import RetrieveDataFromDB.GetDoctors;
import mainpackage.Doctor;

public class ShowDoctorAvailabilty {
	
	public static String Show() throws ClassNotFoundException, SQLException {
		ArrayList<Doctor> d= new ArrayList<Doctor>();
		d=GetDoctors.getList();
		try{Connection connection = DatabaseConnection.initializeDatabase();
		 
		 String query = "select dateStart,doctor_id,Available from appointment ";
		 	Statement st = connection.createStatement();
		 	ResultSet res = st.executeQuery(query);
		 
		 	StringBuilder sb = new StringBuilder();
		 	
		 	while(res.next()) {
		 		
		 		if(res.getString("Available").equals("True")) {
		 			int counter=0;
		 			if(d.get(counter).getId() == res.getInt("doctor_id")) {
		 				sb.append("The "+d.get(counter).get_specialty()+" is available at: ");
		 			}
		 			while(d.get(counter).getId() != res.getInt("doctor_id")) {
		 				counter++;
		 			if(d.get(counter).getId() == res.getInt("doctor_id")) {
		 				sb.append("The "+d.get(counter).get_specialty()+" is available at: ");
		 				
		 			}
		 			}
		 				
		 			
		 			sb.append(res.getString("dateStart"));
		 			sb.append("\t");
		 			
		 		}
		 	
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
	
}
