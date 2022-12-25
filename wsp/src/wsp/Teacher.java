package wsp ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;


public class Teacher extends Employee
{
	private Titles title;
	private Faculty faculty;
	public double rating; 
	
	public Teacher(String FirstName, String LastName, String email, String password,
				   int salary, String ID, boolean isReasearcher, 
				   Titles title, Faculty faculty, double rating){
		super(FirstName, LastName, email, password, salary, ID, isReasearcher);
		this.title = title;
		this.faculty = faculty;
		this.rating = rating;
	}
	
	public void putMarks(Course c) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c.showStudents();
		System.out.println("Which student you want to put Mark? Enter index :");
		Integer index = Integer.parseInt(br.readLine());
		
		Vector <Student> students = c.getStudents();
		Student s  = students.get(index-1);
		
		System.out.println("Enter first Attesation : ");
		Integer x = Integer.parseInt(br.readLine());
		Mark m = new Mark();
		m.firstAttestation(x);
		System.out.println("Enter second Attesation : ");
		x = Integer.parseInt(br.readLine());
		m.secondAttestation(x);
		System.out.println("Enter FINAL  Attesation : ");
		x = Integer.parseInt(br.readLine());
		m.finalExam(x);
		s.takenCourses.put(c ,m);
		Database.saveData();
		System.out.println("Done!");
			
	}
	
	public void action() throws Exception {
		System.out.println("Write:");
		System.out.println("1 <- Send Message");
		System.out.println("2 <- See Message");
		System.out.println("3 <- See all your courses");
		System.out.println("4 <- See specific course students and specific student info.");
		System.out.println("5 <- Put mark to a student");
		System.out.println("6 <- see news");
		System.out.println("0 <- Quit");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int command = Integer.parseInt(br.readLine());
			if(command==1) {
				sendMessage();
			}
			else if (command==2) {
				showMessage();
				
			}
			else if (command==3) {
				showMyCourses();
			}
			else if (command==4) {
				showMyCourses();
				System.out.println("Which course? Enter index : ");
				Integer index = Integer.parseInt(br.readLine());
				Vector <Course > courses= getMyCourses();
				courses.get(index-1).showStudents();
				while(true) {
					System.out.println("Do you want student info ?: ");
					System.out.println("Yes/No  ");
					String answer = br.readLine();
					if(answer.equals("No"))
						break;
					Vector <Student> students = courses.get(index-1).getStudents();
					System.out.println("Enter index of a student :");
					index = Integer.parseInt(br.readLine());
					System.out.println(students.get(index-1));
				}
			}
			else if (command==5) {
				showMyCourses();
				System.out.println("Which course ? Enter index : ");
				Integer index = Integer.parseInt(br.readLine());
				Vector <Course > courses= getMyCourses();
				putMarks(courses.get(index-1));
			}
			else if(command==6) {
				Database.showNews();
			}
			else if (command==0) {
				break;
			}
		}
	}
	public Vector <Course> getMyCourses() {
		Vector<Course> temp = new Vector<>();
		for(Course c: Database.data.allCourses) {
			for(Teacher t: c.getTeachers()) {
				if(t.getFirstName() == this.getFirstName()) {
					temp.add(c);
				}
			}
		}
		return temp;
	}
	public void showMyCourses() {
		Vector<Course> temp =getMyCourses();
		int i =1;
		for(Course c : temp) {
			System.out.println(i+ ")"+ c);
			i++;
		}
		
	}
	
	public String toString() {
		return "Teacher  " +super.toString(); 
	
	}

	public final Titles getTitle() {
		return title;
	}

	public final void setTitle(Titles title) {
		this.title = title;
	}

	public final Faculty getFaculty() {
		return faculty;
	}

	public final void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public final double getRating() {
		return rating;
	}

	public final void setRating(double rating) {
		this.rating = rating;
	}
}

