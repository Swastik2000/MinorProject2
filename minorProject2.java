/*
 * Name: Subashish Behera
 * Redg. No. = 1941012553
 * Section = R
 * Branch - CSE
 */


 class Author{
	
	 private String name;
	private String email;
    private char gender;
	
	public Author(String name, String email, char gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getGender() {
		return gender;
	}
	
	public String toString() {
		String gen;
		if (gender == 'm') {
			gen = "Male";
		}else if(gender == 'f') {
			gen = "Female";
		}else {
			gen = "unassigned";
		}
		
		return ("Author[name = " + name + ", email = " + email + ", gender = " + gen + "]");
	}
	
}

 class Book {
	
	private String name;
	private double price;
	private int qty;
	private Author author;
	
	public Book(String name, Author author, double price, int qty) {
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.author = author;
	}

	public String getName1() {
		return name;
	}
	public String getAuthor() {
		return author.getName();
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String toString1() {
		return ("Book[name = " + name + ", " + author.toString() + ", price = " + price + ", quantity = " + qty + "");
	}
}
 
 class Library{
	 
	 int c = 0;
	 Book bk[] = new Book[1000];
	 public void set(Book b) {
		 bk[c] = b;
		 c++;
	 }
	 
	 public void print() {
		 for(int i = 0; i < c; i++) {
				System.out.println("Book name: " + bk[i].getName1() + ", Author: " + bk[i].getAuthor() + ", Quantity: " + bk[i].getQty());
			}
	 }
	 
	 public void displayInventory() {
		 for(int i = 0; i < c; i++) {
				System.out.println(bk[i].toString1());
			}
	 }
 }

 class Date {
	
	int dd, mm, yyyy;
	Date(int dd, int mm, int yyyy) {
		this.dd = dd;
		this.mm = mm;
		this.yyyy = yyyy;
	}
	
	public int getDD() {
		return dd;
	}
	public int getMM() {
		return mm;
	}
	public int getYYYY() {
		return yyyy;
	}
	
	public String toString2() {
		return ("" + dd + "/" + mm + "/" + yyyy + "");
	}
}

 class Student {

	String name;
	int roll;
	Date issueDate;
	Date returnDate;
	int issuePeriod, fine;
	Library library;
	static int ibc = 0;
	
	public Student(String name, int roll, Date issueDate, Date returnDate, Library library) {
		this.name = name;
		this.roll = roll;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.library = library;
		this.issuePeriod = 21;
		
	}
	
	public String getName2() {
		return name;
	}
	public int getRoll() {
		return roll;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public void setIssuePeriod(int issuePeriod){
		this.issuePeriod = issuePeriod;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	public int getFine(int fine){
		return fine;
	}
	
	public void issueBook(Book b1, Date issueDate) {
		
		this.issueDate = issueDate;
		System.out.println();
		System.out.println("List of available books: ");
		library.print();
		System.out.println();
		System.out.println("You want to issue the following book: " + b1.getName1() + " by " + b1.getAuthor());
		
		if (Student.ibc < 5) {
		 if(b1.getQty() == 0) {
		    	System.out.println("Book not available");
		 }else {
		    	int x = b1.getQty() - 1;
			    b1.setQty(x);
			    ibc++;
			    System.out.println("Book issued successfully");
		 }
		}else {
			    System.out.println("Book issue limit reached");
		}
	}
	
	public void depositBook(Book b2, Date returnDate) {
		
		this.returnDate = returnDate;
		int y = b2.getQty();
		b2.setQty(y + 1);
		System.out.println();
		System.out.println("You deposited the book: " + b2.getName1() + " by " + b2.getAuthor());
		
		if(Student.ibc > 0) {
			ibc--;
		}
		
		int x = getDays.getDifference(issueDate, returnDate);
		if(x - issuePeriod > 0) {
			setFine(x - issuePeriod);
			System.out.println("Your delay fine is: rs." + fine);
		}else {
			System.out.println("All clear");
		}
	}
	
}

 /**
  * Method for finding difference between two dates.
  */
 class getDays{
	    int d, m, y;
	    public getDays() { 
	    	
	    }
	    
	    static int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	static int countLeapYears(Date d) { 
	    int years = d.yyyy;  
	    
	    if (d.mm <= 2)  { 
	        years--; 
	    } 
	    return years / 4 - years / 100 + years / 400; 
	} 
	
	/**
     * Takes two date variables as parameters
     * @return the difference in days between the two dates
     */
	static int getDifference(Date d1, Date d2) { 
	    int n1 = d1.yyyy * 365 + d1.dd; 
	    
	    for (int i = 0; i < d1.mm - 1; i++)  { 
	        n1 += monthDays[i]; 
	    } 
	    
	    n1 += countLeapYears(d1); 
	    
	    int n2 = d2.yyyy * 365 + d2.dd; 
	    
	    for (int i = 0; i < d2.mm - 1; i++) { 
	        n2 += monthDays[i]; 
	    } 
	    n2 += countLeapYears(d2); 
	    
	    return (n2 - n1); 
	} 

}

public class minorProject2 {

	public static void main(String[] args) {
		
		Author a1 = new Author("Mark", "MarkMurdoch@gmail.com", 'm');
		Author a2 = new Author("Alan", "AlanWalker25@gmail.com", 'm');
		Author a3 = new Author("Erica", "EricaNoviv@gmail.com", 'f');
		Author a4 = new Author("Riva", "VisennaRiva@gmail.com", 'f');
		
		Book b1 = new Book("Worlds Apart", a1, 300, 50);
		Book b2 = new Book("Days Gone", a2, 350, 40);
		Book b3 = new Book("The Joy Formidable", a3, 550, 70);
		Book b4 = new Book("The Mockingjay", a4, 400, 100);
		Book b5 = new Book("Live Another Day", a4, 250, 60);
		Book b6 = new Book("Altered Reality", a2, 300, 80);
		
		Library l1 = new Library();
		l1.set(b1);
		l1.set(b2);
		l1.set(b3);
		l1.set(b4);
		l1.set(b5);
		l1.set(b6);
		
		Date d1 = new Date(12, 2, 2020);
		Date d2 = new Date(14, 4, 2020);
		Date d3 = new Date(14, 3, 2020);
		Date d4 = new Date(1, 3, 2020);
		
		Student s1 = new Student("Rahul", 19453, d1, d2, l1);
		s1.issueBook(b2, d1);
		s1.issueBook(b3, d1);
		s1.issueBook(b2, d1);
		s1.issueBook(b3, d1);
		s1.issueBook(b5, d1);
		s1.issueBook(b6, d1);
		s1.depositBook(b2, d2);
		s1.depositBook(b2, d3);
		s1.depositBook(b3, d4);
		s1.issueBook(b5, d1);
		s1.issueBook(b6, d1);
		
		Student s2 = new Student("Arun", 12353, d1, d3, l1);
		s2.issueBook(b6, d1);
		s2.issueBook(b5, d1);
		s2.issueBook(b4, d1);
		s2.issueBook(b4, d1);
		s2.issueBook(b1, d1);
		s2.depositBook(b2, d4);
		s2.depositBook(b3, d3);
		s2.issueBook(b5, d1);
		s2.issueBook(b6, d1);
		
	}

}