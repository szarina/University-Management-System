package wsp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Run {
	public static void login() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Write login:");
		String login = br.readLine();
		System.out.println("Write password:");
		String password = br.readLine();
		User u = (User) Database.findUser(login, password);
		if(u!=null) {
			System.out.println("Welcome " +u.toString()+ "!");
			userAction(u);		
		}
		else
		{
			System.out.println("Login or password is wrong!");
		}
	} 
	
	public static void userAction(User u ) throws Exception {
		//for now; when we write everything - polymorphism
		u.action();
	}
	
	//"amanov@mail.ru","12345" - Admin
	// a_sarsetaev@kbtu.kz , qwerty - Student
	public static void main(String[] args) throws Exception {
		while(true) {
			login();
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Do you wish to log in again: Yes/No");
			if(br2.readLine().equals("No"))
				break;
		}

	
}}
