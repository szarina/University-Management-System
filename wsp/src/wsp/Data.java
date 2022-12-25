package wsp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;

public class Data implements Serializable{

	private static final long serialVersionUID = 1L;
	Vector <User> allUsers = new Vector<>();
	Vector <News> allNews = new Vector<>();
	Vector <Course> allCourses = new Vector<>();
	Vector <Book> allBooks= new Vector<>();
	Vector <Club> allOrganizations = new Vector<>();
	
	Data(){};
}
