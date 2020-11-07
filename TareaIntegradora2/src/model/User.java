package model;

public class User {
	private final Category[] CATEGORIES = Category.values();
	private String username;
	private String password;
	private int age;
	private int sharedSongs;
	private String category;
	/** 
	* Create a new User>
	* <b> pre: The parameters have to be != null</b> 
	* <b> post: A new restricted playlist</b> 
	* @param username type String
	* @param password type String
	* @param age type int
	*/	
	public User(String username, String password, int age) {
		this.username = username;
		this.password = password;
		this.age = age;
		sharedSongs = 0;
		category = CATEGORIES[0].name();
	}
	/** 
	* Obtain the name of the user<br>
	* <b> pre: Username has to be != null</b> 
	* <b> post: Return the username</b>  
	*/	
	public String getUsername() {
		return username;
	}
	/** 
	*  Modify the username of a user<br>
	* <b> pre: The username has to be a text string without spaces</b> 
	* <b> post: Changes the username to the newone</b> 
	*/	
	public void setUsername(String username) {
		this.username = username;
	}
	/** 
	* Obtain the password of the user<br>
	* <b> pre: Password has to be != null</b> 
	* <b> post: Return the password</b>  
	*/	
	public String getPassword() {
		return password;
	}
	/** 
	*  Modify the password of a user<br>
	* <b> pre: The password has to be a text string/b> 
	* <b> post: Changes the password to the newone</b> 
	*/	
	public void setPassword(String password) {
		this.password = password;
	}
	/** 
	* Obtain the age of the user<br>
	* <b> pre: Age has to be != null</b> 
	* <b> post: Return the age</b>  
	*/	
	public int getAge() {
		return age;
	}
	/** 
	* Obtain the number of shared by the user<br>
	* <b> pre: Sharedsongs has to be != null</b> 
	* <b> post: Return the sharedSongs</b>  
	*/		
	public int getSharedSongs() {
		return sharedSongs;
	}
	/** 
	*  Count the amount of songs that the user has shared<br>
	* <b> pre: Sharedsongs has to be already initialized</b> 
	* <b> post: The sharedSongs will increase by 1 unit</b> 
	*/	
	public int addSharedSong() {
		sharedSongs++;
		return sharedSongs;
	}
	/** 
	* Obtain the category the user<br>
	* <b> pre: Category has to be != null</b> 
	* <b> post: Return the category</b>  
	*/	
	public String getCategory() {
		return category;
	}
	/** 
	*  Modify the category of a user<br>
	* <b> pre: The sharedSongs has to be != null</b> 
	* <b> post: Change the category to another one</b> 
	*/	
	public String setCategory() {
		if(sharedSongs < 3) {
			category = CATEGORIES[0].name();
		}
		else if(sharedSongs < 10) {
			category = CATEGORIES[1].name();
		}
		else if(sharedSongs < 30) {
			category = CATEGORIES[2].name();
		}
		else {
			category = CATEGORIES[3].name();
		}
		String updated = "La categoria del usuario "+getUsername()+" ha sido actualizada"+"\n";
		return updated;
	}
	/** 
	*  Show the user's information<br>
	* <b> pre: </b> 
	* <b> post: Show all the info of the user </b> 
	*/	
	public String showContents() {
		String info = "*************  User **************"+"\n";
		info += "**  UserName: "+getUsername()+"\n";
		info += "**  Age: "+getAge()+"\n";
		info += "**  Category: "+getCategory()+"\n";
		info += "***********************************"+"\n";
		return info;
	}
}