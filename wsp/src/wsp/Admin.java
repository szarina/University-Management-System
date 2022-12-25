package wsp ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Admin extends Employee
{
	public Admin(String FirstName, String LastName, String email, String password, int salary, String ID) {
		super(FirstName, LastName, email, password, salary, ID, false);
	}

	public Admin(){
		super();
	}

	public void action() throws Exception {
		System.out.println("Write:");
		System.out.println("1 <- Add User");
		System.out.println("2 <- Delete User");
		System.out.println("3 <- Update User");
		System.out.println("4 <- To See All Users");
		System.out.println("5 <- Send Message");
		System.out.println("6 <- See Messages");
		System.out.println("7 <- see News");
		System.out.println("0 <- QUIT");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int command = Integer.parseInt(br.readLine());
			if(command==1) {
				addUser();
			}
			else if (command==2) {
				System.out.println("Enter ID you wish to delete :");
				String ID = br.readLine();
				deleteUser(ID);
			}
			else if (command==3) {
				System.out.println("Enter ID you wish to update :");
				String ID = br.readLine();
				updateUser(ID);
			}
			else if (command==4) {
				Database.showUsers();
			}
			else if (command==5) {
				this.sendMessage();
			}
			else if(command==6) {
				this.showMessage();
			}
			else if(command==7) {
				Database.showNews();
			}
			else if (command==0) {
				break;
			}
		}
	}
	//readline  
	public void addUser() throws IOException {
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter first name :");
		String firstName = br2.readLine();
		
		System.out.println("Enter last name :");
		String lastName = br2.readLine();
		
		System.out.println("Enter email:");
		String email = br2.readLine();
		
		System.out.println("Enter password:");
		String password =br2.readLine();
		
		System.out.println("Enter ID:");
		String ID = br2.readLine();
		
		System.out.println("T - Teacher");
		System.out.println("S - Student");
		System.out.println("L- Librarian");
		System.out.println("M- Manager");
		String choice = br2.readLine();
		
		if(choice.equals("T")) {
			System.out.println("Enter salary:");
			int salary =Integer.parseInt(br2.readLine());
			
			System.out.println("Enter title Bachelor, Master, PhD :");
			Titles title = Titles.valueOf(br2.readLine());
			
			System.out.println("Enter faculty 	FIT, BS :");
			Faculty faculty = Faculty.valueOf(br2.readLine());
			
			System.out.println("Enter rating :");
			Double  rating =Double.parseDouble(br2.readLine());
			
			System.out.println("Enter Researcher status true/false:");
			Boolean isResearcher =  Boolean.parseBoolean(br2.readLine());
			
			Teacher t = new Teacher(firstName,lastName,email,password,salary,ID,isResearcher,title,faculty,rating);
			Database.addUser(t);
		}
		if(choice.equals("S")){
	
			System.out.println("Enter title Bachelor, Master, PhD :");
			Titles title = Titles.valueOf(br2.readLine());
			
			System.out.println("Enter faculty 	FIT, BS :");
			Faculty faculty = Faculty.valueOf(br2.readLine());
			
			
			System.out.println("Enter Researcher status true/false:");
			Boolean isResearcher =  Boolean.parseBoolean(br2.readLine());
			
			System.out.println("Enter year of study:");
			int yearOfStudy  =Integer.parseInt(br2.readLine());
			
			Student s =  new Student(firstName,lastName,email,password,ID,title,faculty,isResearcher,yearOfStudy);
			Database.addUser(s);}
		if(choice.equals("M")){
			System.out.println("Enter salary:");
			int salary =Integer.parseInt(br2.readLine());
			
			System.out.println("Enter OR or faculty  FIT, BS :");
			Faculty title = Faculty.valueOf(br2.readLine());
			
			Manager m = new Manager(firstName,lastName,email,password,salary,  ID, title);
			Database.addUser(m);
		}
		if(choice.equals("L")) {
			System.out.println("Enter salary:");
			int salary =Integer.parseInt(br2.readLine());
			
			Librarian l  =new Librarian(firstName,lastName,email,password,salary,ID);
			Database.addUser(l);
			
		}

		System.out.println("User  added successfully!");
    }			
	
	public void updateUser(String ID) throws IOException {
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		// Change password only
		System.out.println("Enter new password: ");
		String newPassword  = br2.readLine();
		User u = (User) Database.findUserByID(ID);
		Database.updateUser(u, newPassword);
		System.out.println("Updated!");
	}
	
	public void deleteUser(String ID) {
		User u = (User) Database.findUserByID(ID);
		Database.deleteUser(u);	
		System.out.println("Deleted!");
	}

	public String toString() {
		return "Admin " + super.toString();
	}
}



