package mainpackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dynamic.com.web.service.DatabaseConnection;

public class Appointment {
	
	/*private Patient patient;
	private Doctor doctor;*/
	private int appointment_id;
	private int patient_id;
	private int doctor_id;
	private String dateStart;
	private String Availability;
	public Appointment() {}
	public Appointment(String d_Start,int p_id,int d_id,int id,String a){
		dateStart=d_Start;
		appointment_id=id;
		patient_id= p_id;
		doctor_id=d_id;
		Availability=a;
	}
	//Getters
	int get_id() {
		return appointment_id;
	}
	String get_dateStart() {
		return dateStart;
	}
	int get_patient() {
		return patient_id;
	}
	int get_doctor() {
		return doctor_id;
	}
	String get_availabilty() {
		return Availability;
	}
	
}
