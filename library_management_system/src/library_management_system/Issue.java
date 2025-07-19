package library_management_system;

public class Issue
{
	private int ISBN_number;
	private int user_id;
	private String issue_date;
	private String expected_return_date;
	
	public String getExpected_return_date()
	{
		return expected_return_date;
	}
	public void setExpected_return_date(String expected_return_date)
	{
		this.expected_return_date=expected_return_date;
	}
	
	public int getISBN_number() {
		return ISBN_number;
	}
	public void setISBN_number(int ISBN_number) {
		this.ISBN_number = ISBN_number;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}
	
	@Override
	public String toString() {
		return "ISBN_number = " + ISBN_number + "\nuser_id = " + user_id + "\nissue_date = " + issue_date+"\nexpected_return_date = "+expected_return_date;
	}
	
	
	
	
	

	

}
