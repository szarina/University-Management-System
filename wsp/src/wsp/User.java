package wsp ;

import java.io.Serializable;
import java.util.Vector;

public abstract class User implements Serializable
{
	private String FirstName;	
	private String LastName;
	private String email;
	private String password;
	private String ID;
	
	private Vector <Paper> papers= new Vector<>(); 
	public User() {};
	public User(String FirstName, String LastName, String email, String password,String ID){
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.email = email;
		this.password = password;
		this.ID= ID;
	}

	public void viewAllNews() {
		// TODO implement me	
	}
	public final String getFirstName() {
		return FirstName;
	}
	public  void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public  void setLastName(String lastName) {
		LastName = lastName;
	}
	public  String getEmail() {
		return email;
	}
	public  void setEmail(String email) {
		this.email = email;
	}
	public  String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return this.getFirstName()+" "+this.getEmail()+" " + this.getID();
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public abstract void action () throws Exception;
}

