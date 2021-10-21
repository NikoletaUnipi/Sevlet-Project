package mainpackage;

public class Admin extends Users{
	private int admin_id;
	private String username;
	public Admin(int id,String username){
		super();
		this.admin_id=id;
		this.username=username;
	}
	//Getters
	public String get_username() {
		return username;
	}
	public int get_admin_id() {
		return admin_id;
	}
	public Doctor add_new_doctor(int id,String specialty,String name) {
		
		Doctor doctor= new Doctor(id,admin_id, specialty, name);
		return doctor;
	}
}
