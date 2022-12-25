package wsp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Vector;

public class Club implements Serializable  {
	private static final long serialVersionUID = 1L;
	private String name;
	private Student president;
	private String info;
	private Vector<Student> members;
	
	private Club() {};
	
	private Club(String name, Student president, String info) {
		this.name = name;
		this.president = president;
		this.info = info;
	}
	
	public void addMember() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Write Student Name: ");
		String  studentName = br.readLine();
		for(User u: Database.data.allUsers) {
			if(u instanceof Student && u.getLastName().equals(studentName)) {
				members.add((Student) u);
				Database.saveData();
				System.out.println("Student Added!");
				return;
			}
		}
		System.out.println("Student doesnt found!");
	}
	
	public void addMember(Student s) throws Exception{
		members.add(s);
		Database.saveData();
	}
	
	public void kickMember() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Write Student Name: ");
		String  studentName = br.readLine();
		for(Student s: members) {
			if(s.getLastName().equals(studentName)) {
				members.remove(s);
				Database.saveData();
				System.out.println("Student Removed!");
				return;
			}
		}
		System.out.println("Student doesnt found!");
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Organization : " + name + "/n" + "President : " + president.toString() + " INFO : " + info;
	}
}
