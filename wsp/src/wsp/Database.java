package wsp ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Vector;


public class Database implements Serializable
{
		
	private static final long serialVersionUID = 1L;
	static Data data = new Data();
	static {
		try {
			data = readData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static Data readData() throws Exception{
		FileInputStream fis = new FileInputStream("data.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);;
		data = (Data)ois.readObject();
		fis.close();
		ois.close();
		return data;
	}
	
	static void saveData() throws Exception {
		FileOutputStream fos = new FileOutputStream("data.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(data);
		fos.close();
		oos.close();
	}
	
	static void clearData() {
		PrintWriter writer;
		try {
			writer = new PrintWriter("data.ser");
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	static void addUser(User u ) {
		data.allUsers.add(u);
		try {
			saveData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void deleteUser(User u ) {
		data.allUsers.remove(u);
		try {
			saveData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void showUsers() {
		if(!data.allUsers.isEmpty()) {
			for(User  u: data.allUsers)
				System.out.println(u);
		}
		else 
			System.out.println("No users");
	}
	
	static void updateUser(User u,String newPassword ) {
		u.setPassword(newPassword);
		try {
			saveData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static Object findUser(String login,String password) {
		for(User  u: data.allUsers) {
			if(u.getEmail().equals(login)&& u.getPassword().equals(password)) {
				System.out.println("Logged in!");
				return (Object)u;					
			}
		}
		return null;
	}
	
	static Object findUserByID(String ID) {
		for(User  u: data.allUsers) {
			if(u.getID().equals(ID)) {
				return (Object)u;					
			}
		}
		return null;
	}
	
	static Object findUserByEmail(String email) {
		for(User  u: data.allUsers) {
			if(u.getEmail().equals(email)) {
				return (Object)u;					
			}
		}
		return null;
	}
	
	static Vector <Student> getStudents(){
		Vector <Student> students = new Vector<>();
		for(User  u: data.allUsers) {
			if(u instanceof Student) {
				students.add((Student)u);					
			}
		}
		return students;
	}
	
	static void addCourse(Course c) {
		data.allCourses.add(c);
		try {
			saveData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void deleteCourse(Course c) {
		data.allCourses.remove(c);
		try {
			saveData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void showNews() {
		int i =1;
		for(News n : data.allNews) {
			System.out.println(i+" )"+n);
		}
	}
	
	static void addNews(News n) {
		data.allNews.add(n);
		try {
			saveData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void deleteNews(News n) {
		data.allNews.remove(n);
		try {
			saveData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void showCourses() {
		for(Course c: Database.data.allCourses) {
			System.out.println(c);
		}
	}
	
	static void addBook(Book b) {
		data.allBooks.add(b);
		try {
			saveData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void deleteBook(Book b) {
		data.allBooks.remove(b);
		try {
			saveData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

