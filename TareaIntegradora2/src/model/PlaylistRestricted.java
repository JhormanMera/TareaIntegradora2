package model;

public class PlaylistRestricted extends Playlist{
	private final static int USERS_ALLOWED = 5;
	private User[] usersAllowed;
	public PlaylistRestricted(String name, String password, int age, String playlistName) {
        super(playlistName);
        this.usersAllowed = new User [USERS_ALLOWED];
		this.usersAllowed[0]=new User(name, password, age);
    }
	public String showUsers(){
		String msg="Usuarios Permitidos:"+"/n";
		for(int i=0;i<USERS_ALLOWED;i++){
			if(usersAllowed[i] != null){
				msg +=" "+usersAllowed[i]+"/n";
			}
		}
		return msg;
	}
	@Override
	public String showContent(){
		String msg="**************  Playlist **************"+"/n"+
					"**  Title: "+super.getName()+"/n"+
					"**  Duration: "+super.getDuration()+"/n"+
					"**  Genre: "+super.showGenre()+"/n"+
					"Propietario: "+showUsers()+"/n"+
					"****************************************"+"/n";
		return msg;
	}  
}
