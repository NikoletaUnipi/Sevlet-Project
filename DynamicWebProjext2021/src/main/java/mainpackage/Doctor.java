package mainpackage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import dynamic.com.web.service.DatabaseConnection;
public class Doctor extends Users{
	private int id;
	private String username;
	private String specialty;
	private int admin_id;
	public Doctor(int id,int admin_id,String specialty,String name){
		super();
		this.specialty = specialty;
		this.username = name;
		this.id=id;
		this.admin_id=admin_id;
	}
	
	
	void initialize_doctor_availability() {
	
	}
	
	
	public static String Show(String p_id) {
		try{
		Connection connection = DatabaseConnection.initializeDatabase();
		 
		 String query = "select dateStart,doctor_id from appointment where doctor_id='"+p_id+"'";
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
	//getters
	public int getId() {
		return id;
	}
	public String get_specialty() {
		return specialty;
	}
	
	public String get_username() {
		return username;
	}
}
