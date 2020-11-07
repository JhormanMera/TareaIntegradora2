package model;

public class PrivatePlaylist extends Playlist {
	private User accessUser;
	/** 
	* Create a new private playlist<br>
	* <b> pre: The parameters have to be != null</b> 
	* <b> post: A new Private playlist</b> 
	* @param namePlaylist type String
	* @param username type String
	* @param password type String
	* @param age type int
	*/	
	public PrivatePlaylist(String namePlaylist, String username, String password, int age) {
		super(namePlaylist);
		accessUser = new User(username, password ,age);
	}
	/** 
	*  Obtain the user with acces to the playlist<br>
	* <b> pre: The accessUser has to be != null</b> 
	* <b> post: Return the user with access</b> 
	*/	
	public User getAccessUser() {
		return accessUser;
	}
	/** 
	*  Modify the user with access<br>
	* <b> pre: The accessUser has to be !=null</b> 
	* <b> post: Change the user to a new one</b> 
	* @param accessUser type User
	*/	
	public void setAccessUser(User accessUser) {
		this.accessUser = accessUser;
	}
	/** 
	*  Show the private playlist's information<br>
	* <b> pre: </b> 
	* <b> post: Show all the info of the playlist </b> 
	*/	
	@Override
	public String showContents() {
		String info = "**************  Playlist **************"+"\n";
		info += "**  Title: "+super.getNamePlaylist()+"\n";
		info += "**  Duration: "+super.getDurationPlaylist()+"\n";
		info += "**  Genre: "+super.showGenres()+"\n";
		info += "**  Users with access: "+accessUser.getUsername()+"\n";
		info += "***********************************"+"\n";
		return info;
	}
}