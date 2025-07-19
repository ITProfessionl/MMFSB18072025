package library_management_system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class Library {
	static Logger log = Logger.getLogger(Library.class);
	long user_mobile_number_starting;
	int user_id_starting;

	public static void main(String[] args) {
		Scanner scannerObject1 = new Scanner(System.in);
		System.out.println();
		System.out.println(" **********************  Welcome to Public Library ****************** ");
		System.out.println();
		log.info("Hello!!!");
		System.out.println();
		log.info("Hope you are fine");
		System.out.println();
		System.out.println("Are you User or Staff[User/Staff]?");
		String authentication = scannerObject1.next();

		Library libraryObject1 = new Library();
		libraryObject1.authentication(authentication);
		scannerObject1.close();
	}

	/*
	 * authentication():Purpose of this method is Data Security.
	 */

	void authentication(String authentication) {
		Scanner scannerObject2 = new Scanner(System.in);
		Library libraryObject2 = new Library();
		try {
			if (authentication.equalsIgnoreCase("Staff")) {
				libraryObject2.catalogStaff();
			} else if (authentication.equalsIgnoreCase("User")) {
				System.out.print("Please enter your Mobile number:");
				user_mobile_number_starting = scannerObject2.nextLong();
				System.out.println();
				System.out.print("Please enter your User ID:");
				user_id_starting = scannerObject2.nextInt();
				libraryObject2.catalogUser();
			} else {
				System.out.println("Please enter valid input.");
				String authentication2 = scannerObject2.next();
				libraryObject2.authentication(authentication2);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		scannerObject2.close();
	}

	/*
	 * catalogStaff() method is used for to show staff how many funtionalities will
	 * done by this project.
	 */

	void catalogStaff() {
		Scanner object_scanner = new Scanner(System.in);
		Library object_library = new Library();

		System.out.println();

		System.out.println("Press 1 to show all books and its details.");
		System.out.println("Press 2 for search particular Book details from Book Table.");
		System.out.println("Press 3 for Add book in database.");
		System.out.println("Press 4 for Delete book from database.");
		System.out.println("Press 5 for Update book detail for particular ISBN number.");
		System.out.println("Press 6 to show all users and it details.");
		System.out.println("Press 7 for search particular user details from User Table.");
		System.out.println("Press 8 for Add users in database.");
		System.out.println("Press 9 for Delete User from database.");
		System.out.println("Press 10 for Update user detail for particular user.");
		System.out.println("Press 11 to show all Issued books.");
		System.out.println("Press 12 for search  Issue Book details of particular user.");
		System.out.println("Press 13 to Issue a paricular book.");
		System.out.println("Press 14 to delete particular entry of Issue Table.");
		System.out.println("Press 15 to show all Returned books.");
		System.out.println("Press 16 to search Returned Book detail of particular user.");
		System.out.println("Press 17 to return a particular book.");
		System.out.println("Press 18 to delete particular entry of Return Table.");
		System.out.println("Press 19 to check out which users are to pay fine.");

		System.out.println("Press 00 for exit");
		try {
			int option = object_scanner.nextInt();
			object_library.optionStaff(option);
		} catch (Exception e) {
			log.error("Please enter valid input.");
			object_library.catalogStaff();
		}
		object_scanner.close();

	}

	/*
	 * catalogUser() method is used for to show user how many functionalities will
	 * done by this project.
	 */

	void catalogUser() {
		Scanner scanner_object = new Scanner(System.in);
		Library library_object = new Library();

		System.out.println();

		System.out.println("Press 1 to show all books and its details.");
		System.out.println("Press 2 for search particular Book details from Book Table.");
		System.out.println("Press 3 to see your personal detail.");
		System.out.println("Press 4 for search  Issue Book details of particular user.");
		System.out.println("Press 5 to search Returned Book detail of particular user.");
		System.out.println("Press 6 to check out which users are to pay fine.");

		System.out.println("Press 00 for exit");
		try {
			int option = scanner_object.nextInt();
			library_object.optionUser(option);
		} catch (Exception e) {
			log.error("Please enter valid input.");
			library_object.catalogUser();
		}
		scanner_object.close();

	}

	/*
	 * optionStaff()- when Staff enter option which are preset in catalogStaff()
	 * then according to Staff's input option case are run,so this method for that
	 * used.
	 */

	void optionStaff(int option) {
		Scanner scannerObject3 = new Scanner(System.in);
		Library object_library = new Library();

		switch (option) {
		case 1:
			try {

				object_library.getAllBooks();
				object_library.catalogStaff();

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 2:
			System.out.print("Please enter Book Name: ");

			String book_name = scannerObject3.nextLine();

			try {
				Book book = object_library.getParticularBook(book_name);
				System.out.println(book);

			} catch (Exception e) {
				e.printStackTrace();
			}
			object_library.catalogStaff();
			break;

		case 3:
			System.out.println("Please enter ISBN number");
			int ISBN_number_I = scannerObject3.nextInt();
			System.out.println("Please enter book name");
			scannerObject3.nextLine();
			String book_name_I = scannerObject3.nextLine();
			System.out.println("Please enter book author");
			String book_author = scannerObject3.nextLine();
			System.out.println("Please enter book genre");
			String book_genre = scannerObject3.nextLine();
			int number_of_copies = 1;

			try {
				Book book = object_library.addBook(ISBN_number_I, book_name_I, book_author, book_genre,
						number_of_copies);
				System.out.println(book);
				object_library.catalogStaff();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 4:
			System.out.println("Please enter ISBN number");
			int ISBN_number_D = scannerObject3.nextInt();
			try {
				Book book = object_library.deleteBook(ISBN_number_D);
				System.out.println(book);
				object_library.catalogStaff();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 5:
			System.out.println("Please enter ISBN number");
			int ISBN_number_U = scannerObject3.nextInt();
			scannerObject3.nextLine();
			System.out.println("Please enter book name");
			String book_name_U = scannerObject3.nextLine();
			System.out.println("Please enter book author");
			String book_author_U = scannerObject3.nextLine();
			System.out.println("Please enter book genre");
			String book_genre_U = scannerObject3.nextLine();
			System.out.println("Please enter number of copies");
			int updated_number_of_copies = scannerObject3.nextInt();
			try {
				Book book = object_library.updateBook(ISBN_number_U, book_name_U, book_author_U, book_genre_U,
						updated_number_of_copies);
				System.out.println(book);
				object_library.catalogStaff();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 6:
			try {
				object_library.getAllUser();
				object_library.catalogStaff();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 7:
			System.out.print("Please enter user mobile number:");

			long user_mobile_number = scannerObject3.nextLong();

			try {
				User user = object_library.getParticularUser(user_mobile_number);
				System.out.println(user);
				object_library.catalogStaff();

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 8:
			System.out.println("Please enter User name");
			String user_name = scannerObject3.nextLine();
			System.out.println("Please enter User mobile number");
			long user_mobile_number_I = scannerObject3.nextLong();
			scannerObject3.nextLine();
			System.out.println("Please enter User email");
			String user_email = scannerObject3.nextLine();
			System.out.println("Please enter User Id");
			int user_id = scannerObject3.nextInt();
			try {
				User user = object_library.addUser(user_id, user_name, user_mobile_number_I, user_email);
				System.out.println(user);
				object_library.catalogStaff();

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 9:
			System.out.println("Please enter user mobile number");
			long user_mobile_number_D = scannerObject3.nextLong();
			try {
				User user = object_library.deleteUser(user_mobile_number_D);
				System.out.println(user);
				object_library.catalogStaff();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 10:
			System.out.println("Please enter mobile number number");
			long mobile_number_U = scannerObject3.nextLong();
			System.out.println("Please enter user name");
			scannerObject3.nextLine();
			String user_name_U = scannerObject3.nextLine();
			System.out.println("Please enter user  email");
			String user_email_U = scannerObject3.nextLine();
			System.out.println("Please enter user id");
			int user_id_U = scannerObject3.nextInt();
			try {
				User user = object_library.updateUser(mobile_number_U, user_name_U, user_id_U, user_email_U);
				System.out.println(user);
				object_library.catalogStaff();

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 11:

			try {
				object_library.getAllIssueBooks();
				object_library.catalogStaff();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 12:
			System.out.print("Please enter user id:");

			int user_id_IssueBook = scannerObject3.nextInt();

			try {

				Issue issue = object_library.getIssueBook(user_id_IssueBook);
				System.out.println(issue);
				object_library.catalogStaff();

			}

			catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 13:
			System.out.println("Please enter user id");
			int user_id_I = scannerObject3.nextInt();
			System.out.println("Please enter ISBN number");
			int isbn_number_I = scannerObject3.nextInt();
			System.out.println("Please enter issue Date");
			String issue_date = scannerObject3.next();
			System.out.println("Please enter expected return date");
			String expected_return_date = scannerObject3.next();
			try {
				Issue issue = object_library.IssueBook(user_id_I, isbn_number_I, issue_date, expected_return_date);
				System.out.println(issue);
				object_library.catalogStaff();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 14:
			System.out.println("Please enter user id");
			int user_id_delete_issue = scannerObject3.nextInt();
			try {
				Issue issue = object_library.deleteIssue(user_id_delete_issue);
				System.out.println(issue);
				object_library.catalogStaff();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 15:
			try {
				object_library.getAllReturnBooks();
				object_library.catalogStaff();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 16:
			System.out.print("Please enter user id:");

			int user_id_ReturnBook = scannerObject3.nextInt();

			try {
				Return reurn = object_library.getReturnBook(user_id_ReturnBook);
				System.out.println(reurn);
				object_library.catalogStaff();

			}

			catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 17:
			System.out.println("Please enter user id");
			int user_id_R = scannerObject3.nextInt();
			System.out.println("Please enter ISBN number");
			int isbn_number_R = scannerObject3.nextInt();
			System.out.println("Please enter return date");
			String return_date = scannerObject3.next();
			System.out.println("Please enter actual return date");
			String actual_return_date = scannerObject3.next();
			try {
				Return retrn = object_library.returnBook(user_id_R, isbn_number_R, return_date, actual_return_date);
				System.out.println(retrn);
				object_library.catalogStaff();

			} catch (Exception e)

			{
				e.printStackTrace();
			}
			break;

		case 18:
			System.out.println("Please enter user id");
			int user_id_delete_return = scannerObject3.nextInt();
			try {
				Return retrn = object_library.deleteReturn(user_id_delete_return);
				System.out.println(retrn);
				object_library.catalogStaff();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 19:

			try {
				object_library.fineCheck();
				System.out.println("Above users are subject to fine.");
				object_library.catalogStaff();

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 00:
			System.out.println("Thanks for visit.");
			break;

		default:
			log.error("Wrong Option!!!!!");
			// System.out.println("Wrong Option!!!!!");
			System.out.println();
			System.out.println("Please enter valid option.");

			object_library.catalogStaff();
			scannerObject3.close();
		}
	}

	/*
	 * optionUser()- when user enter option which are preset in catalogUser() then
	 * according to User's input option case are run,so this method for that used.
	 */

	void optionUser(int option) {
		Scanner scannerObject = new Scanner(System.in);
		Library libraryObject = new Library();

		switch (option) {
		case 1:
			try {

				libraryObject.getAllBooks();
				libraryObject.catalogUser();

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 2:
			System.out.print("Please enter Book Name: ");

			String book_name = scannerObject.nextLine();

			try {
				Book book = libraryObject.getParticularBook(book_name);
				System.out.println(book);

			} catch (Exception e) {
				e.printStackTrace();
			}
			libraryObject.catalogUser();
			break;

		case 3:
			// System.out.print("Please enter user mobile number:");

			// long user_mobile_number = scannerObject.nextLong();

			try {
				libraryObject.get_own_detail_by_user();
				// User user = libraryObject.get_own_detail_by_user();
				// System.out.println(user);
				libraryObject.catalogUser();

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 4:
			System.out.print("Please enter user id:");
			int user_id_IssueBook = scannerObject.nextInt();

			try {

				Issue issue = libraryObject.getIssueBook(user_id_IssueBook);
				System.out.println(issue);
				libraryObject.catalogUser();

			}

			catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 5:
			System.out.print("Please enter user id:");

			int user_id_ReturnBook = scannerObject.nextInt();

			try {
				Return reurn = libraryObject.getReturnBook(user_id_ReturnBook);
				System.out.println(reurn);
				libraryObject.catalogUser();

			}

			catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 6:

			try {
				libraryObject.fineCheck();
				System.out.println("Above users are subject to fine.");
				libraryObject.catalogUser();

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 00:
			System.out.println("Thanks for visit.");
			break;

		default:
			log.error("Wrong Option!!!!!");
			// System.out.println("Wrong Option!!!!!");
			System.out.println();
			System.out.println("Please enter valid option.");

			libraryObject.catalogUser();
			scannerObject.close();
		}
	}

	/*
	 * getParticularBook()-when end user wants details of particular book then this
	 * method take ISBN number of particular book then according to that ISBN number
	 * gives detail to the user.
	 */

	public Book getParticularBook(String book_name) {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;

		Book book = null;
		book_name = "\'" + book_name + "\'";

		String query = "SELECT * FROM book_table WHERE book_name=" + book_name;
		try {
			connection = Connectionn.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				book = new Book();
				book.setISBN_number(rs.getInt("ISBN_number"));
				book.setBook_name(rs.getString("book_name"));
				book.setBook_author(rs.getString("book_author"));
				book.setBook_genre(rs.getString("book_genre"));
				book.setnumberOfCopies(rs.getInt("number_of_copies"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return book;
	}

	/*
	 * getParticularUser():when end user wants details of particular user then this
	 * method take mobile number of particular user from the end user, then
	 * according to that mobile number gives detail to the user.
	 */

	public void get_own_detail_by_user() {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;

		// User user = null;

		String query = "SELECT * FROM user_table WHERE user_mobileNo=" + user_mobile_number_starting;
		try {
			connection = Connectionn.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			System.out.println(".");
			if (rs.next()) {
				// user = new User();
				System.out.println(rs.getInt("user_id"));
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getLong("user_mobileNo"));
				System.out.println(rs.getString("user_email"));
				// rs.getLong("user_mobileNo");
				// rs.getString("user_email");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// return user;
	}

	public User getParticularUser(long user_mobile_number) {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;

		User user = null;

		String query = "SELECT * FROM user_table WHERE user_mobileNo=" + user_mobile_number;
		try {
			connection = Connectionn.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setUserMobileNo(rs.getLong("user_mobileNo"));
				user.setUserEmail((rs.getString("user_email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	/*
	 * addBook()- this method is used for add book from the database and if same
	 * book name and same author name are already present in the database then this
	 * method increase number of copies of particular book.
	 */

	public Book addBook(int ISBN_number, String book_name, String book_author, String book_genre,
			int number_of_copies) {
		int count = 0;
		Connection connection = null;
		Statement statement = null;

		ResultSet bookDetail = null;

		Book book = null;
		connection = Connectionn.getConnection();
		try {

			book = new Book();
			book.setISBN_number(ISBN_number);
			book.setBook_name(book_name);
			book.setBook_author(book_author);
			book.setBook_genre(book_genre);
			book.setnumberOfCopies(number_of_copies);

			book_name = "\'" + book_name + "\'";
			book_author = "\'" + book_author + "\'";
			book_genre = "\'" + book_genre + "\'";

			String query1 = "SELECT * FROM book_table where book_name=" + book_name + "and book_author=" + book_author;

			if (connection != null)
				statement = connection.createStatement();
			bookDetail = statement.executeQuery(query1);

			if (bookDetail.next()) {
				ISBN_number = bookDetail.getInt("ISBN_number");
				book_name = bookDetail.getString("book_name");
				book_genre = bookDetail.getString("book_genre");

				number_of_copies = bookDetail.getInt("number_of_copies") + 1;

				book_name = "\'" + book_name + "\'";

				book_genre = "\'" + book_genre + "\'";
				String query = "UPDATE  library_management_system.book_table SET number_of_copies=" + number_of_copies
						+ " where ISBN_number=" + ISBN_number + ";";
				statement.executeUpdate(query);
			} else {

				String query = "INSERT INTO book_table VALUES(" + ISBN_number + "," + book_name + "," + book_author
						+ "," + book_genre + "," + number_of_copies + ")";

				if (statement != null)
					count = statement.executeUpdate(query);

				if (count == 0)
					System.out.println("Record not inserted");
				else
					System.out.println("Record  inserted");
			}

		} catch (SQLException e) {
			if (e.getErrorCode() == 1)
				System.out.println("Duplicates can not to pk column");
			if (e.getErrorCode() == 12899)
				System.out.println("invalid column name or sql keywords");
			else if (e.getErrorCode() == 12899)
				System.out.println("Do not insert more than size");

			e.printStackTrace();
		}

		return book;
	}

	/*
	 * deleteBook()-When end user wants to delete particular book then this method
	 * take ISBN number from the end user delete particular book from the database.
	 */

	public Book deleteBook(int ISBN_number) {
		int count = 0;
		Connection connection = null;
		Statement statement = null;

		Book book = null;
		connection = Connectionn.getConnection();
		try {

			book = new Book();
			book.setISBN_number(ISBN_number);

			if (connection != null)
				statement = connection.createStatement();
			String query = "DELETE FROM book_table WHERE ISBN_NUMBER=" + ISBN_number;

			if (statement != null)
				count = statement.executeUpdate(query);

			if (count == 0)
				System.out.println("Record not deleted");
			else
				System.out.println("Record  deleted");

		} catch (SQLException e) {
			if (e.getErrorCode() == 1)
				System.out.println("Duplicates can not to pk column");
			if (e.getErrorCode() == 12899)
				System.out.println("invalid column name or sql keywords");
			else if (e.getErrorCode() == 12899)
				System.out.println("Do not insert more than size");

			e.printStackTrace();
		}

		return book;
	}

	/*
	 * updateBook():When user wants to update book details of particular book then
	 * this method is used for that task.
	 */
	public Book updateBook(int ISBN_number, String book_name, String book_author, String book_genre,
			int number_of_copies) {
		int count = 0;
		Connection connection = null;
		Statement statement = null;

		Book book = null;
		connection = Connectionn.getConnection();
		try {

			book = new Book();
			book.setISBN_number(ISBN_number);
			book.setBook_name(book_name);
			book.setBook_author(book_author);
			book.setBook_genre(book_genre);
			book.setnumberOfCopies(number_of_copies);

			book_name = "'" + book_name + "'";
			book_author = "'" + book_author + "'";
			book_genre = "'" + book_genre + "'";

			if (connection != null)
				statement = connection.createStatement();
			String query = "UPDATE book_table SET book_name=" + book_name + ",book_author=" + book_author
					+ ",book_genre=" + book_genre + ",number_of_copies=" + number_of_copies + " WHERE ISBN_number="
					+ ISBN_number;

			if (statement != null)
				count = statement.executeUpdate(query);

			if (count == 0)
				System.out.println("Record not updated");
			else
				System.out.println("Record  updated");

		} catch (SQLException e) {
			if (e.getErrorCode() == 1)
				System.out.println("Duplicates can not to pk column");
			if (e.getErrorCode() == 12899)
				System.out.println("invalid column name or sql keywords");
			else if (e.getErrorCode() == 12899)
				System.out.println("Do not insert more than size");

			e.printStackTrace();
		}

		return book;
	}

	/*
	 * addUser()-when end user wants add user in database then this method is used
	 * for that task.
	 */

	public User addUser(int user_id, String user_name, long user_mobile_number, String user_email) {
		int count = 0;
		Connection connection = null;
		Statement statement = null;

		User user = null;
		connection = Connectionn.getConnection();
		try {

			user = new User();
			user.setUserId(user_id);
			user.setUserName(user_name);
			user.setUserMobileNo(user_mobile_number);
			user.setUserEmail(user_email);

			user_name = "'" + user_name + "'";
			user_email = "'" + user_email + "'";

			if (connection != null)
				statement = connection.createStatement();
			String query = "INSERT INTO user_table VALUES(" + user_name + "," + user_mobile_number + "," + user_email
					+ "," + user_id + ")";

			if (statement != null)
				count = statement.executeUpdate(query);

			if (count == 0)
				System.out.println("Record not inserted");
			else
				System.out.println("Record  inserted");

		} catch (SQLException e) {
			if (e.getErrorCode() == 1)
				log.error("Duplicates can not to pk column");
			// System.out.println("Duplicates can not to pk column");
			if (e.getErrorCode() == 12899)
				log.error("invalid column name or sql keywords");
			// System.out.println("invalid column name or sql keywords");
			else if (e.getErrorCode() == 12899)
				log.error("Do not insert more than size");
			// System.out.println("Do not insert more than size");

			e.printStackTrace();
		}

		return user;
	}

	/*
	 * deleteUser()- When user wants to delete particular user details from the
	 * database the this method take mobile number from the end user and delete its
	 * detail from database.
	 */

	public User deleteUser(long user_mobile_number) {
		int count = 0;
		Connection connection = null;
		Statement statement = null;

		User user = null;
		connection = Connectionn.getConnection();
		try {

			user = new User();
			user.setUserMobileNo(user_mobile_number);

			if (connection != null)
				statement = connection.createStatement();
			String query = "DELETE FROM user_table WHERE user_mobileNo=" + user_mobile_number;

			if (statement != null)
				count = statement.executeUpdate(query);

			if (count == 0)
				System.out.println("Record not deleted");
			else
				System.out.println("Record  deleted");

		} catch (SQLException e) {
			if (e.getErrorCode() == 1)
				System.out.println("Duplicates can not to pk column");
			if (e.getErrorCode() == 12899)
				System.out.println("invalid column name or sql keywords");
			else if (e.getErrorCode() == 12899)
				System.out.println("Do not insert more than size");

			e.printStackTrace();
		}

		return user;
	}

	/*
	 * updateUser()= when end user wants to update details of the particular user
	 * then this method take user mobile number of particular user updated username,
	 * updated user email,update user id.
	 */

	public User updateUser(long user_mobile_number, String user_name, int user_id, String user_email) {
		int count = 0;
		Connection connection = null;
		Statement statement = null;

		User user = null;
		connection = Connectionn.getConnection();
		try {

			user = new User();
			user.setUserId(user_id);
			user.setUserName(user_name);
			user.setUserMobileNo(user_mobile_number);
			user.setUserEmail(user_email);

			user_name = "'" + user_name + "'";
			user_email = "'" + user_email + "'";

			if (connection != null)
				statement = connection.createStatement();
			String query = "UPDATE user_table SET user_name=" + user_name + ",user_id=" + user_id + ",user_email="
					+ user_email + " WHERE user_mobileNo=" + user_mobile_number;

			if (statement != null)
				count = statement.executeUpdate(query);

			if (count == 0)
				System.out.println("Record not updated");
			else
				System.out.println("Record  updated");

		} catch (SQLException e) {
			if (e.getErrorCode() == 1)
				System.out.println("Duplicates can not to pk column");
			if (e.getErrorCode() == 12899)
				System.out.println("invalid column name or sql keywords");
			else if (e.getErrorCode() == 12899)
				System.out.println("Do not insert more than size");

			e.printStackTrace();
		}

		return user;
	}

	/*
	 * getIssueBook(): when end user wants to issue a particular book then this
	 * method is used for that task.
	 */

	public Issue getIssueBook(int user_id) {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;

		Issue issue = null;

		String query = "SELECT * FROM issue_table WHERE user_id=" + user_id;
		try {
			connection = Connectionn.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				issue = new Issue();
				issue.setISBN_number(rs.getInt("ISBN_number"));
				issue.setUser_id(rs.getInt("user_id"));
				issue.setIssue_date(rs.getString("issue_date"));
				issue.setExpected_return_date(rs.getString("expected_return_date"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return issue;
	}

	/*
	 * getReturnBook()-When end user wants to get details of particular user then
	 * end user take user id of particular user and give details of particular user.
	 */

	public Return getReturnBook(int user_id) {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;

		Return reurn = null;

		String query = "SELECT * FROM return_table WHERE user_id=" + user_id;
		try {
			connection = Connectionn.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				reurn = new Return();
				reurn.setISBN_number(rs.getInt("ISBN_number"));
				reurn.setUser_id(rs.getInt("user_id"));
				reurn.setReturn_date(rs.getString("return_date"));
				reurn.setActual_return_date(rs.getString("actual_return_date"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return reurn;
	}

	/*
	 * getAllBooks()- When end user wants to see all books which are present in the
	 * database then this method is used for that task
	 */

	public void getAllBooks() {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;

		String query = "SELECT * FROM book_table";
		try {
			connection = Connectionn.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);

			if (rs != null) {
				while (rs.next()) {

					System.out.println("ISBN_number:" + rs.getInt(1) + "   " + "Book Name:" + rs.getString(2) + "   "
							+ "Book Author:" + rs.getString(3) + "   " + "Book Genre:" + rs.getString(4) + "   "
							+ "Number of Copies:" + rs.getInt(5));
					System.out.println();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/*
	 * getAllUser(): when end user wants to see all users which are present in
	 * database then this method is used for that task.
	 */

	public void getAllUser() {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;

		String query = "SELECT * FROM user_table";
		try {
			connection = Connectionn.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs != null) {
				while (rs.next())

					System.out.println("User name:" + rs.getString(1) + "   " + "User mobile number:" + rs.getLong(2)
							+ "   " + "User email:" + rs.getString(3) + "   " + "User Id:" + rs.getInt(4));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/*
	 * getAllIssueBooks()- when end user wants to see all issued books which are
	 * present in database then this method is used for that task.
	 */

	public void getAllIssueBooks() {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;

		String query = "SELECT * FROM issue_table";
		try {
			connection = Connectionn.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs != null) {
				while (rs.next())

					System.out.println("User Id:" + rs.getInt(1) + "   " + "ISBN number:" + rs.getInt(2) + "   "
							+ "Issue Date:" + rs.getString(3) + "   " + "Expected Return Date:" + rs.getString(4));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/*
	 * getAllReturnBooks()-When end user wants to see all returned book then this
	 * method is used for that task.
	 */

	public void getAllReturnBooks() {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;

		String query = "SELECT * FROM return_table";
		try {
			connection = Connectionn.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs != null) {
				while (rs.next())
					System.out.println("User Id:" + rs.getInt(1) + "   " + "ISBN number:" + rs.getInt(2) + "   "
							+ "Return Date:" + rs.getString(3) + "   " + "Actual Return Date:" + rs.getString(4));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/*
	 * IssueBook()-This method is used for issue a particular book so take user
	 * id,ISBN number issue date, expected return date from the end user and insert
	 * that details in to a database.
	 */

	public Issue IssueBook(int user_id, int ISBN_number, String issue_date, String expected_return_date) {
		int count = 0;
		Connection connection = null;
		Statement statement = null;

		Issue issue = null;
		connection = Connectionn.getConnection();
		try {

			issue = new Issue();
			issue.setISBN_number(ISBN_number);
			issue.setUser_id(user_id);
			issue.setIssue_date(issue_date);
			issue.setExpected_return_date(expected_return_date);

			issue_date = "'" + issue_date + "'";
			expected_return_date = "'" + expected_return_date + "'";

			if (connection != null)
				statement = connection.createStatement();
			String query = "INSERT INTO issue_table VALUES(" + user_id + "," + ISBN_number + "," + issue_date + ","
					+ expected_return_date + ")";

			if (statement != null)
				count = statement.executeUpdate(query);

			if (count == 0)
				System.out.println("Record not inserted");
			else
				System.out.println("Record  inserted");

		} catch (SQLException e) {
			if (e.getErrorCode() == 1)
				System.out.println("Duplicates can not to pk column");
			if (e.getErrorCode() == 12899)
				System.out.println("invalid column name or sql keywords");
			else if (e.getErrorCode() == 12899)
				System.out.println("Do not insert more than size");

			e.printStackTrace();
		}

		return issue;

	}

	/*
	 * returnBook(): This method is used for insert details of particular returned
	 * book.
	 */

	public Return returnBook(int user_id, int ISBN_number, String return_date, String actual_return_date) {
		int count = 0;
		Connection connection = null;
		Statement statement = null;

		Return retrn = null;
		connection = Connectionn.getConnection();
		try {

			retrn = new Return();
			retrn.setISBN_number(ISBN_number);
			retrn.setUser_id(user_id);
			retrn.setReturn_date(return_date);
			retrn.setActual_return_date(actual_return_date);

			return_date = "'" + return_date + "'";
			actual_return_date = "'" + actual_return_date + "'";

			if (connection != null)
				statement = connection.createStatement();
			String query = "INSERT INTO return_table VALUES(" + user_id + "," + ISBN_number + "," + return_date + ","
					+ actual_return_date + ")";

			if (statement != null)
				count = statement.executeUpdate(query);

			if (count == 0)
				System.out.println("Record not inserted");
			else
				System.out.println("Record  inserted");

		} catch (SQLException e) {
			if (e.getErrorCode() == 1)
				System.out.println("Duplicates can not to pk column");
			if (e.getErrorCode() == 12899)
				System.out.println("invalid column name or sql keywords");
			else if (e.getErrorCode() == 12899)
				System.out.println("Do not insert more than size");

			e.printStackTrace();
		}

		return retrn;
	}

	/*
	 * deleteIssue(): This method is used for to delete issuing book details of
	 * particular user.
	 */

	public Issue deleteIssue(int user_id) {
		int count = 0;
		Connection connection = null;
		Statement statement = null;

		Issue issue = null;
		connection = Connectionn.getConnection();
		try {

			issue = new Issue();
			issue.setUser_id(user_id); // 9456783456

			if (connection != null)
				statement = connection.createStatement();
			String query = "DELETE FROM issue_table WHERE user_id=" + user_id;

			if (statement != null)
				count = statement.executeUpdate(query);

			if (count == 0)
				System.out.println("Record not deleted");
			else
				System.out.println("Record  deleted");

		} catch (SQLException e) {
			if (e.getErrorCode() == 1)
				System.out.println("Duplicates can not to pk column");
			if (e.getErrorCode() == 12899)
				System.out.println("invalid column name or sql keywords");
			else if (e.getErrorCode() == 12899)
				System.out.println("Do not insert more than size");

			e.printStackTrace();
		}

		return issue;
	}

	/*
	 * deleteReturn():This method is used for to delete returning book details of
	 * particular user.
	 */

	public Return deleteReturn(int user_id) {
		int count = 0;
		Connection connection = null;
		Statement statement = null;

		Return retrn = null;
		connection = Connectionn.getConnection();
		try {

			retrn = new Return();
			retrn.setUser_id(user_id); // 9456783456

			if (connection != null)
				statement = connection.createStatement();
			String query = "DELETE FROM return_table WHERE user_id=" + user_id;

			if (statement != null)
				count = statement.executeUpdate(query);

			if (count == 0)
				System.out.println("Record not deleted");
			else
				System.out.println("Record  deleted");

		} catch (SQLException e) {
			if (e.getErrorCode() == 1)
				System.out.println("Duplicates can not to pk column");
			if (e.getErrorCode() == 12899)
				System.out.println("invalid column name or sql keywords");
			else if (e.getErrorCode() == 12899)
				System.out.println("Do not insert more than size");

			e.printStackTrace();
		}

		return retrn;
	}

	/*
	 * fineCheck(): when end user wants to see those users whose are subject to fine
	 * then this method is used for that ask.
	 */

	public void fineCheck() {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;

		String query = "SELECT * FROM return_table where return_date!=actual_return_date";
		try {
			connection = Connectionn.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs != null) {
				while (rs.next())
					System.out.println("User Id:" + rs.getInt(1) + "   " + "ISBN number:" + rs.getInt(2) + "   "
							+ "Return Date:" + rs.getString(3) + "   " + "Actual Return Date:" + rs.getString(4));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
