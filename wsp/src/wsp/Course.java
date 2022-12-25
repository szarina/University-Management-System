package wsp ;

import java.io.*;
import java.util.Objects;
import java.util.Vector;

public class Course implements Serializable
{
	private String fullname;
	private String shortname;
	private int credits;
	private Vector <Teacher> teachers;
	
	public Course(){}
	
	public Course(String fullname, String shortname, int credits, Vector <Teacher> teachers){
		this.fullname = fullname;
		this.shortname = shortname;
		this.credits = credits;
		this.teachers = teachers;
	}

	public String getFullName() {
		return fullname;
	}
	
	public String getShortName() {
		return shortname;
	}
	

	public void setName(String fullname) {
		this.fullname = fullname;
	}
	
	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Vector<Teacher> getTeachers() {
		return teachers;
	}
	
	public Vector <Student > getStudents() {
		Vector <Student > students = Database.getStudents();
		Vector <Student > res  = new Vector<>();
		for (Student s: students) {
			if(s.takenCourses.containsKey(this))
				res.add(s);
		}
		return res;
	}
	
	public void showStudents() {
		Vector <Student > students =getStudents();
		int i = 1;
		for (Student s: students) {
			System.out.println(i +" ) " + s.getLastName() + " "  +s.getFirstName() +" "+ s.takenCourses.get(this).getMarkINT() );
			i++;
		}
	}
	
	public void addTeacher(Teacher t) throws Exception {
		this.teachers.add(t);
		Database.saveData();
	}

	public String toString() {
		return shortname + " : " + fullname + " Credits : " + credits + "\n";
	}

	public int hashCode() {
		return Objects.hash(credits, fullname, shortname, teachers);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return credits == other.credits && Objects.equals(fullname, other.fullname)
				&& Objects.equals(shortname, other.shortname) && Objects.equals(teachers, other.teachers);
	}
}

