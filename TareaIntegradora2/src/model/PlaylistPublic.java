package model;

public class PlaylistPublic extends Playlist{
	private double averageMark;
	public PlaylistPublic(String playlistName) {
        super(playlistName);
        this.averageMark = 0.0;
    }
	public double calculateAverage(int mark){
		
	}

	@Override
	public String showContent(){
		String msg=super.showContent()+"/n"+"Calificacion Promedio: "+averageMark+"/n"+"****************************************";
		return msg;
	}
}
