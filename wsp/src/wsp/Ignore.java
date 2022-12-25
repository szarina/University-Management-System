package wsp;

import java.util.Vector;

public class Ignore {
	public static void  main(String[] args) throws Exception {
		Database.addUser(new Admin("Amanov","Alimszhan","amanov@mail.ru","12345",40000,"0101"));
		/*Teacher t = new Teacher("Pakita","Shamoi","pakita@mail.ru","12345",100000,"0102",true,Titles.PhD,Faculty.FIT,4.9);
		Database.addUser(t);
		Vector <Teacher> teachers = new Vector<>();
		teachers.add(t);
		Database.addUser(new Admin("Zara","Saden","zara.saden","12345",40000,"0102"));
		Database.addCourse(new Course("Programming Principles I", "PP1", 4, teachers));
		Database.addUser(new Student("Abylkairkhan", "Sarsetaev", "a_sarsetaev@kbtu.kz", "qwerty", "21B031282", Titles.Bachelor, Faculty.FIT, false, 2));
		Database.addUser(new Manager("Dina", "Lina", "dina@kbtu.kz", "qwerty",120000, "030433",Faculty.OR));
		Database.addUser(new Librarian("Tateshka", "Maratovna", "librarian@kbtu.kz", "zxcvb", 150000, "67B035122"));*/
	}
}
