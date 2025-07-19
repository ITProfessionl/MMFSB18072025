package library_management_system;

public class Book
{
	private int ISBN_number;
	private String Book_name;
	private String Book_author;
	private String Book_genre;
	private int number_of_copies;
	
	public int getnumberOfCopies() 
	{
		return number_of_copies;
	}
	
	public void setnumberOfCopies(int number_of_copies) 
	{
		this.number_of_copies = number_of_copies;
	}
	
	public int getISBN_number() 
	{
		return ISBN_number;
	}
	
	public void setISBN_number(int iSBN_number) 
	{
		ISBN_number = iSBN_number;
	}
	
	public String getBook_name()
	{
		return Book_name;
	}
	
	public void setBook_name(String book_name)
	{
		Book_name = book_name;
	}
	
	public String getBook_author()
	{
		return Book_author;
	}
	
	public void setBook_author(String book_author)
	{
		Book_author = book_author;
	}
	
	public String getBook_genre() 
	{
		return Book_genre;
	}
	
	public void setBook_genre(String book_genre)
	{
		Book_genre = book_genre;
	}
	
	@Override
	public String toString()
	{
		return "ISBN_number = " + ISBN_number + "\nBook_name = " + Book_name + "\nBook_author = " + Book_author
				+ "\nBook_genre = " + Book_genre+"\nNumber of Copies = "+ number_of_copies;
	}
	
	
	

}
