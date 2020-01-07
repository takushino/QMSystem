package models;

public class User {
	private int user_id;
	private String username;
	private String password;
	private int user_role;
	
	public User() {
		super();
	}

	public User(int user_id, String user_name, int user_role) {
		super();
		this.user_id = user_id;
		this.username = user_name;
		this.user_role = user_role;
	}

	public int getUser_id() {
		return user_id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getUser_role() {
		return user_role;
	}

}
