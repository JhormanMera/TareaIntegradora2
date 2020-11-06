package model;

public class PlaylistRestricted extends Playlist{
	private final static int USERS_ALLOWED = 5;
	private String[] usersAllowed;
	public PlaylistRestricted(String playlistName,String usersAllowed) {
        super(playlistName);
        this.usersAllowed = new String [USERS_ALLOWED];
		this.usersAllowed[0]=usersAllowed
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
