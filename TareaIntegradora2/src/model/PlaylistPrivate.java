package model;
public class PlaylistPrivate extends Playlist{
    private User uniqueUser;
	public PlaylistPrivate(String playlistName,String name, String password, int age){
        super(playlistName);
        this.uniqueUser =new User(name, password, age);
    }
	public User getUniqueUser(){
		return this.uniqueUser;
	}
    public void setUniqueUser(User uniqueUser){
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