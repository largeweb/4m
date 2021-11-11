package mmmm;

public class UserDetails {
	
	private String username;
	private String password;
	private String phoneNum;
	private String name;
	
	public UserDetails(String username, String password, String phoneNum, String name) {
		this.username = username;
		this.password = password;
		this.phoneNum = phoneNum;
		this.name = name;
	}
	public UserDetails() {
		this.username = null;
		this.password = null;
		this.phoneNum = null;
		this.name = null;		
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}	
	public void setPassword(String username) {
		this.password = password;
	}
	public String getPassword() {
		return this.password;
	}	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPhoneNum() {
		return phoneNum;
	}	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

}
