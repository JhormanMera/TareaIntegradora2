package model;
public class PlaylistPrivate extends Playlist{
    private String uniqueUser;
	public PlaylistPrivate(String playlistName, String uniqueUser){
        super(playlistName);
        this.uniqueUser =uniqueUser;
    }
	public String getUniqueUser(){
		return this.uniqueUser;
	}
    public void setUniqueUser(String uniqueUser){
		this.uniqueUser= uniqueUser;
	}
	@Override
	public String showContent(){
		String msg="**************  Playlist **************"+"/n"+
					"**  Title: "+super.getName()+"/n"+
					"**  Duration: "+super.getDuration()+"/n"+
					"**  Genre: "+super.showGenre()+"/n"+
					"Propietario: "+getUniqueUser()+"/n"+
					"****************************************"+"/n";
		return msg;
	}    
}