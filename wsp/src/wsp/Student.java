package wsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;


public class Student extends User implements Researcher
{
	private static final long serialVersionUID = 1L;
	HashMap <Course,Mark> takenCourses = new HashMap<>();
	private Vector<Book> takenBooks = new Vector<>();
	private Titles title;
	private Faculty faculty;
	private boolean isReasearcher;
	private int yearOfStudy;
	private int credits = 21;

	public Student(String FirstName, String LastName, String email, String password, String ID, Titles title, Faculty faculty,boolean isReasearcher, int yearOfStudy){
		super(FirstName, LastName, email, password,ID);
		this.title = title;
		this.faculty = faculty;
		this.isReasearcher = isReasearcher;
		this.yearOfStudy = yearOfStudy;
	}
	
	public void registerForCourses() throws Exception {
		System.out.println("Write Course Name (PP1,OOP etc.): ");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String courseName = br2.readLine();
		for(Course c: Database.data.allCourses) {
			if(courseName.equals(c.getShortName())) {
				if(this.credits >= c.getCredits()) {
					this.credits-= c.getCredits();
					this.takenCourses.put(c, new Mark());
					Database.saveData();
					return;
				}
				else {
					System.out.println("Sorry, you don't have enough credits :( ");
					return;
				}
			}
		}
		System.out.println("Sorry, no such course found");
	}
	
	public void addBook(Book b) {
		takenBooks.add(b);
	}
	
	public void deleteBook(Book b) {
		takenBooks.remove(b);
	}
	
	public void viewInfoTeacher() throws IOException {
		System.out.println("Write Teacher Name: ");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String teacherName = br2.readLine();
		for(User u: Database.data.allUsers) {
			if(u instanceof Teacher) {
				Teacher t = (Teacher) u;
				if(teacherName.equals(t.getFirstName())){
					System.out.println(t.toString());
					return;
				}
			}
		}
		System.out.println("Sorry, no such teacher");
	}
	
	public void viewMark() throws IOException {
		System.out.println("Write your Course Name: ");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String courseName = br2.readLine();
		Set <Course> temp = takenCourses.keySet();
		for(Course c: temp) {
			if(c.getShortName().equals(courseName)) {
				Mark m = takenCourses.get(c);
				System.out.println(m.getMark());
				return;
			}
		}
		System.out.println("Sorry, no such course found");
	}

	public void viewTranscript() {
		int gpa = 0;
		for(Course c: takenCourses.keySet())	{
			System.out.println(c.getFullName());
			Mark m = takenCourses.get(c);
			System.out.println(m.getMark());
			gpa += m.getMarkINT();
		}
		System.out.println("Your GPA : " + gpa/takenCourses.size());
	}
	
	public void rateTeacher() throws IOException {
		System.out.println("Write Teacher Last Name: ");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String teacherName = br2.readLine();
		for(Course c: takenCourses.keySet()) {
			for(Teacher t: c.getTeachers()) {
				if(teacherName.equals( t.getLastName())) {
					System.out.println("Enter your score to Teacher: ");
					int x =Integer.parseInt(br2.readLine());
					t.setRating((t.getRating()+x)/2);
				}
			}
		}
		System.out.println("Sorry, that teacher dont found!");
	}
	
	public void takeBook() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Write Title of the Book: ");
		String title = br.readLine();
		for(Book b: Database.data.allBooks) {
			if(title.equals(b.getTitle()) && b.getBookCount() > 0) {
				takenBooks.add(b);
				b.setBookCount(b.getBookCount()-1);
				System.out.println("Your take Book!");
				Database.saveData();
				return;
			}
		}
		System.out.println("This Book doesnt found :(");
	}
	
	public void myBooks() {
		for(Book b: takenBooks) {
			System.out.println("Book Author : "+b.getAuthor()+", Title : "+b.getTitle());
		}
	}
	
	public void joinClub() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Write Club Name: ");
		String clubName = br.readLine();	
		for(Club c: Database.data.allOrganizations) {
			if(clubName.equals(c.getName())) {
				c.addMember(this);
			}
		}
		System.out.println("Club wasnt Found :(");
	}
	
	public void action() throws Exception{
		System.out.println("1 <- View all courses");
		System.out.println("2 <- Register for Courses");
		System.out.println("3 <- View info about teacher of a specific course");
		System.out.println("4 <- View Marks");
		System.out.println("5 <- View Transcript");
		System.out.println("6 <- Rate teachers");
		System.out.println("7 <- Join to Student Organizations");
		System.out.println("8 <- Take Book");
		System.out.println("9 <- My Books");
		System.out.println("10 <- See news");
		System.out.println("0 <- Quit");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int command = Integer.parseInt(br.readLine());
			if(command == 1) {
				Database.showCourses();
			}
			else if(command == 2) {
				this.registerForCourses();
			}
			else if(command == 3) {
				this.viewInfoTeacher();
			}
			else if(command == 4) {
				this.viewMark();
			}
			else if(command == 5) {
				this.viewTranscript();
			}
			else if(command == 6) {
				this.rateTeacher();
			}
			else if(command == 7) {
				this.joinClub();
			}
			else if(command == 8) {
				this.takeBook();
			}
			else if(command == 9) {
				this.myBooks();
			}
			else if(command == 10) {
				Database.showNews();
			}
			else if (command==0) {
				break;
			}
			
		}
	}
	public String toString() {
		return "Student " + super.toString(); 
	}
}

