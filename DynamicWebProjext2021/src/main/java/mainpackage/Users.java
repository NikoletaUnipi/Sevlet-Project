package mainpackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import dynamic.com.web.service.DatabaseConnection;

public class Users {
	private int id;
	private String username;
	private String name;
	private String password;
	private String surname;
	private String type;
	private static int usersCounter=0;
	public Users(){
		usersCounter++;
	}
	public Users(int id,String username,String name,String password,String surname,String type){
		this.id=id;
		this.username=username;
		this.name=name;
		this.password=password;
		this.surname= surname;
		this.type=type;
		usersCounter++;
		
	}
	//Setters
	public void setUsername(String username) {
		this.username = username;
	}
	public void setName(String name ) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setType(String type) {
		this.type = type;
	}
	//Getters
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getSurname() {
		return surname;
	}
	public String getType() {
		return type;
	}
}
