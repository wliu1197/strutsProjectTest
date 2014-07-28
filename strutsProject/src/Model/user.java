package Model;

public class user {
	private String userName;
	private String passWord;
	private String role;
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public String getUserName(){
		return this.userName;
	}

	public void setPassWord(String passWord){
		this.passWord = passWord;
	}
	
	public String getPassWord(){
		return this.passWord;
	}

	public void setRole(String role){
		this.role = role;
	}
	
	public String getRole(){
		return this.role;
	}


}
