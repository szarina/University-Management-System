package wsp ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Librarian extends Employee
{	
	public Librarian(String FirstName, String LastName, String email, String password, int salary, String ID){
		super(FirstName, LastName, email, password, salary, ID, false);
	}

	public void getAllBooks() {
		for(Book b: Database.data.allBooks) {
			System.out.println(b);
		}
	}

	public void giveBook() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Write Title of the Book: ");
		String bookTitle = br.readLine();
		for(Book b: Database.data.allBooks) {
			if(b.getTitle().equals(bookTitle)) {
				System.out.println("Write the Student ID to whom you want to give the book: ");	
				String ID = br.readLine();
				for(User u: Database.data.allUsers) {
					if(u instanceof Student) {
						Student s = (Student) u;
						if(s.getID().equals(ID)) {
							if(b.getBookCount() > 0) {
								s.addBook(b);
								b.setBookCount(b.getBookCount()-1);
								Database.saveData();
								System.out.println("You gived the Book to " + ID);
								return;
							}
							else System.out.println("This book is Over");
						}
					}
				}
				System.out.println("That Student do not found!");
				return;
			}
		}
		System.out.println("That Book does not found!");
	}
	
	public void getBookBack() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Write Title of the Book: ");
		String bookTitle = br.readLine();
		for(Book b: Database.data.allBooks) {
			if(b.getTitle().equals(bookTitle)) {
				System.out.println("Write the Student ID to whom you want to get back the book: ");	
				String ID = br.readLine();
				for(User u: Database.data.allUsers) {
					if(u instanceof Student) {
						Student s = (Student) u;
						if(s.getID().equals(ID)) {
							s.deleteBook(b);
							b.setBookCount(b.getBookCount()+1);
							System.out.println("You take back the Book from " + ID);
							Database.saveData();
							return;
						}
					}
				}
				System.out.println("That Student do not found!");
				return;
			}
		}
		System.out.println("That Book does not found!");
	}
	
	public void addNewBook() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Write Book Author");
		String author =  br.readLine();
		System.out.println("Write Book Title");
		String title = br.readLine();
		System.out.println("Write Book Count");
		int cntBook = Integer.parseInt(br.readLine());
		Database.addBook(new Book(author, title, cntBook));
		Database.saveData();
		System.out.println("Book Added!");
	}
	
	public void action() throws Exception {
		System.out.println("1 <- View all Books");
		System.out.println("2 <- Give Book to Student");
		System.out.println("3 <- Take Book from Student");
		System.out.println("4 <- Add New Book");
		System.out.println("5 <- see news");
		System.out.println("0 <- Quit");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int command = Integer.parseInt(br.readLine());
			if(command == 1) {
				this.getAllBooks();
			}
			else if(command == 2) {
				this.giveBook();
			}
			else if(command == 3) {
				this.getBookBack();
			}
			else if(command == 4) {
				this.addNewBook();
			}
			else if(command==5) {
				Database.showNews();
			}
			else if (command==0) {
				break;
			}
		}
	}
}

