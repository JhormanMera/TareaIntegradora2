package model;
public class User{
	private String name;
	private String password;
	private int age;
	private UserCategory category;
	public User (String name, String password, int age){
		this.name= name;
		this.password= password;
		this.age= age;
		this.category=UserCategory.NEWBIE;
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
	public String showContent(){
		String msg=" ************* USER **************"+"/n"+
				"**  UserName: "+name+"/n"+
				"**  Age: "+age+"/n"+
				"**  Category: "+category+"/n"+
				"*********************************";
		return msg;
	}
}