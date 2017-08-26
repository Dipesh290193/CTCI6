package ch7_ObjectOrientedDesign;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OnlineBookReader {

}

abstract class UserDetails
{
	private long id;
	private String username;
	private String password;
	private String name;
	protected UserType userType;
	
}

class Author extends UserDetails{
	public Author()
	{
		this.userType = userType.Author;
	}
}

class Reader extends UserDetails{
	
	List<Book> savedBooks;
	
	public Reader()
	{
		this.userType= userType.Reader;
		this.savedBooks = new ArrayList<Book>();
	}
}

class Book{
	
	private long id;
	private Author author;
	private String description;
	private Date published;
	private Language[] languages;
	private int pages;
	
}

enum Language{
	English,
	Hindi
}

enum BookType{
	Romance,
	Thriller,
	Fiction
}
enum UserType{
	Author,
	Admin,
	Reader
}


