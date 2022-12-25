package wsp ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class Manager extends Employee
{
	private Faculty title;
	
	public Manager(String FirstName, String LastName, String email, String password,
			   int salary, String ID, Faculty title){
		super(FirstName, LastName, email, password, salary, ID, false);
		this.title = title;
	}
	public void action() throws Exception {
		System.out.println("Write:");
		System.out.println("1 <- add Course");
		System.out.println("2 <- assign Course  ");
		System.out.println("3 <- view all Courses ");
		System.out.println("4 <- to see all users");
		System.out.println("5 <- send Messages");
		System.out.println("6 <- see Messages");
		System.out.println("7 <- create News");
		System.out.println("8 <- see News");
		System.out.println("9 <- delete News");
		System.out.println("10 <- statistical Report");
		System.out.println("0 <- to QUIT");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int command = Integer.parseInt(br.readLine());
			if(command==1) {
				addCourse();
			}
			else if (command==2) {
				assignCourse();
			}
			else if (command==3) {
				Database.showCourses();
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
			else if (command==7) {
				this.createNews();
			}
			else if (command==8) {
				Database.showNews();
			}
			else if (command==9) {
				deleteNews();
			}
			else if (command==10) {
				statisticReport();
			}
			else if (command==0) {
				break;
			}
		}
	}
	public void addCourse() throws Exception {
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter full name : ");
		String fullName = br2.readLine();
		
		System.out.println("Enter short name : ");
		String shortName = br2.readLine();
		
		System.out.println("Enter credits : ");
		Integer credits = Integer.parseInt(br2.readLine());
		Vector <Teacher> teachers = new Vector <>();
		
		Course c = new Course(fullName,shortName,credits,teachers);
		Database.addCourse(c);	
	}
	
	public void assignCourse() throws Exception {
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Write Course Name (PP1,OOP etc.): ");
		String courseName = br2.readLine();
		for(Course c: Database.data.allCourses) {
			if(courseName.equals(c.getShortName())) {
				System.out.println("Write ID : ");
				String ID = br2.readLine();
				User u = (User) Database.findUserByID(ID);
				if(u!=null && u instanceof Teacher) {
					c.addTeacher((Teacher)u);//already saves data here
				}
				else {
					System.out.println("No such user");
				}
				
				return;
			}
				
		}		
		
		System.out.println("No such course exists");
		// TODO implement me	
	}


	
	public void statisticReport() {
		System.out.println("There are " + Database.data.allUsers.size()+" users in the system!");
		System.out.println("There are " + Database.data.allCourses.size()+" courses in the system!");	
		System.out.println("There are " + Database.data.allBooks.size()+" types of books in library!");	
		System.out.println("There are " + Database.data.allNews.size()+" news in the system!");	
		System.out.println("There are " + Database.data.allOrganizations.size()+" clubs !");	
	}
	
	public void createNews() throws Exception {
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter title : ");
		String title = br2.readLine();
		System.out.println("Enter content : ");
		String content = br2.readLine();
		
		Database.addNews(new News(title,content));
	}
	
	public void viewInfo(User u) {
		// TODO implement me	
	}
	
	public void viewRequests() {
		// TODO implement me	
	}
	
	public void deleteNews() throws Exception {
		Database.showNews();
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter index you want to delete: ");
		
		Integer index = Integer.parseInt(br2.readLine());
		Database.deleteNews(Database.data.allNews.get(index-1));
	}
	
	public void viewCourses() {
		for(Course c: Database.data.allCourses) {
			System.out.println(c);
		}
	}
	public String toString() {
		return "Manager " + super.toString();
	}
}


