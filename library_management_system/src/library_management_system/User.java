package library_management_system;

public class User 
{
	private int userId;
	private String userName;
	private long userMobileNo;
	private String userEmail;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getUserMobileNo() {
		return userMobileNo;
	}
	public void setUserMobileNo(long userMobileNo) {
		this.userMobileNo = userMobileNo;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "userId = " + userId + "\nuserName = " + userName + "\nuserMobileNo = " + userMobileNo + "\nuserEmail = "
				+ userEmail;
	}
	
	

}
