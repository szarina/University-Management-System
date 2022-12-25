package wsp ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Vector;

public class Employee extends User implements Serializable
{
	private int salary;	
	private boolean isReasearcher;
	private  Vector <String> messages;
	
	public Employee() {};
	public Employee(String FirstName, String LastName, String email, String password, int salary, String ID, boolean isReasearcher){
		super(FirstName, LastName, email, password,ID);
		this.salary = salary;
		this.isReasearcher = isReasearcher;
		this.messages = new Vector<>();
	}
	
	public void sendMessage() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the email of that person : ");
		String email = br.readLine();
		User u = (User) Database.findUserByEmail(email);
		if(u==null || !(u instanceof Employee)) {
			System.out.println("Incorrect login");
		}
		else
		{
			System.out.println("Enter text : ");
			String text = br.readLine();
			((Employee) u).addMessage(text +"\n   from "+ this.getEmail());
		}
	}
	
	public void addMessage(String message) throws Exception {
		this.messages.add(message);
		Database.saveData();
	}
	
	public void showMessage() {
		for(String s : this.messages) {
			System.out.println(s);
		}
	}
	
	public void action() throws Exception{
		/*if(this.isReasearcher!=true) {
			System.out.println("1 <- see all Research Papers");
			System.out.println("2 <- delete  Research Paper");
			System.out.println("3 <- add  Research Paper");
		}
		System.out.println();
		return;*/
	}
}

