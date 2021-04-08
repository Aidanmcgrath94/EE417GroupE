package user;

public class User {
	 private int id;
	 private String username;
	 private String password;
	 private String fname;
	 private String lname;
	 private String email;
	 private String favourite;
	 private final boolean admin;
 
	public User(int id, String username, String password, String fname, String lname, String email, String favourite, boolean admin) {
		super();
		this.id = id;
		 this.username = username;
		 this.password = password;
		 this.fname = fname;
		 this.lname = lname;
		 this.email = email;
		 this.favourite=favourite;
		 this.admin = admin;
	 }

	 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	 public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFavourite() {
		return favourite;
	}

	public void setFavourite(String favourite) {
		this.favourite = favourite;
	}

	 public boolean isAdmin() {
		 return admin;
	 }
}
