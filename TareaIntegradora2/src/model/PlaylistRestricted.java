package model;

public class PlaylistRestricted extends Playlist{
	private final static int USERS_ALLOWED = 1;
	private String[] usersAllowed;
	public PlaylistRestricted(String playlistName, String[] usersAllowed) {
        super(playlistName);
        this.usersAllowed = usersAllowed;
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
		String msg=super.showContent()+"/n"+showUsers()+"****************************************";
		return msg;
	}    
}
