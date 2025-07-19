package library_management_system;

public class Return 
{
	private int ISBN_number;
	private int user_id;
	private String return_date;
	private String actual_return_date;
	
	public String getActual_return_date()
	{
		return actual_return_date;
	}
	
	public void setActual_return_date(String actual_return_date)
	{
		this.actual_return_date=actual_return_date;
	}
	
	public int getISBN_number() {
		return ISBN_number;
	}
	public void setISBN_number(int iSBN_number) {
		ISBN_number = iSBN_number;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	
	@Override
	public String toString() {
		return "ISBN_number = " + ISBN_number + "\nuser_id=" + user_id + "\nreturn_date=" + return_date+"\nactual_return_date="+actual_return_date;
	}
	
	
	
	

}
