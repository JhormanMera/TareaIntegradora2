package model;
public class User{
	private final UserCategory[] Category = UserCategory.values();
	private String name;
	private String password;
	private int age;
	private String category;
	private int sharedSongs;
	public User (String name, String password, int age){
		this.name= name;
		this.password= password;
		this.age= age;
		this.category=Category[0].name();
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name= name;
	}
	public String getPassword(){
		return password;
	}
	public void setPasword(String password){
		this.password= password;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age= age;
	}
	public void setCategory(){
		this.sharedSongs++;
		if(this.sharedSongs<3){
			this.category=Category[0].name();
		}
		else if(sharedSongs<10){
			this.category=Category[1].name();
		}
		else if(sharedSongs<30){
			this.category=Category[2].name();
		}
		else {
			this.category=Category[3].name();
		}
	}
	public String getCategory(){
		return this.category;
	}
	public String showContent(){
		String msg=" ************* USER **************"+"/n"+
				"**  UserName: "+getName()+"/n"+
				"**  Age: "+getAge()+"/n"+
				"**  Category: "+getCategory()+"/n"+
				"*********************************"+"/n";
		return msg;
	}
}