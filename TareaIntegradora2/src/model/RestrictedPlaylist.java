package model;

public class RestrictedPlaylist extends Playlist {
	private final static int MAX_ACCESS_USERS = 5;
	private User[] accessUsers;
	/** 
	* Create a new restricted playlist<br>
	* <b> pre: The parameters have to be != null</b> 
	* <b> post: A new restricted playlist</b> 
	* @param username type String
	* @param password type String
	* @param age type int
	* @param namePlaylist type String
	*/	
	public RestrictedPlaylist(String username, String password, int age, String namePlaylist) {
		super(namePlaylist);
		accessUsers = new User[MAX_ACCESS_USERS];
		accessUsers[0] = new User(username, password ,age);
	}
	/** 
	*  Add a user to the playlist and give him access <br>
	* <b> pre: The user have to be already registered</b> 
	* <b> post: Add the user to the playlist and show a message </b> 
	* @param username type String
	* @param password type String
	* @param age type int
	*/	
	public String addAccessUser(String username, String password, int age) {
		String msg = "No se le pudo conceder el acceso al usuario - ";
		User newAccessUser = new User(username, password ,age);
		boolean added = false;
			for(int i=0; i<MAX_ACCESS_USERS && !added; i++) {
				if(accessUsers[i] == null) {
					accessUsers[i] = newAccessUser;
					added = true;
					msg = "Se agrego un nuevo usuario con acceso";
				}
			}
		if(added == false) {
			msg += "Se ha llegado al limite de usuarios con acceso";
		}
		return msg;
	}
	/** 
	*  Show the restricted playlist's users with access<br>
	* <b> pre: The acces has to be != null</b> 
	* <b> post: Show all the users with access to the playlist </b> 
	*/	
	public String showAccessUsers() {
		String users = "";
		for(int i=0; i<MAX_ACCESS_USERS; i++) {
			if(accessUsers[i] != null) {
				users += accessUsers[i].getUsername()+", ";
			}
		}
		return users;
	}
	/** 
	*  Show the restricted playlist's information<br>
	* <b> pre: </b> 
	* <b> post: Show all the info of the playlist </b> 
	*/	
	@Override
	public String showContents() {
		String info = "**************  Playlist **************"+"\n";
		info += "**  Title: "+super.getNamePlaylist()+"\n";
		info += "**  Duration: "+super.getDurationPlaylist()+"\n";
		info += "**  Genre: "+super.showGenres()+"\n";
		info += "**  Users with access: "+showAccessUsers()+"\n";
		info += "***********************************"+"\n";
		return info;
	}
}