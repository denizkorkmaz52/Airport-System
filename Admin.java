
public class Admin {
	private String username;
	private String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean checkAdmin(String username, char[] password) {
		
		String strPassword = "";
		for (int i = 0; i < password.length; i++) {
			strPassword = strPassword + password[i];
		}
		if(username.contentEquals("admin")&& strPassword.contentEquals("123"))
			return true;
		
		return false;
	}

	
}
