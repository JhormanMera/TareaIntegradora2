package model;

public class PlaylistPrivate extends Playlist{
    private String uniqueUser;
	public PlaylistPrivate(String playlistName, String uniqueUser) {
        super(playlistName);
        this.uniqueUser = uniqueUser;
    }
	@Override
	public String showContent(){
		String msg=super.showContent()+"/n"+"Propietario: "+uniqueUser+"/n"+"****************************************";
		return msg;
	}
    
}