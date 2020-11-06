package model;

public class PlaylistPublic extends Playlist{
	private double averageMark;
	private int amountMark;
	private int totalMark
	public PlaylistPublic(String playlistName) {
        super(playlistName);
        this.averageMark = 0.0;
    }
	public void SetAverageMark(int mark){
		this.amountMark++;
		this.totalmark+=mark;
		this.averageMark=totalMark/amountMark;
	}
	public double getAverageMark(){
		return this.averageMark;
	}
	@Override
	public String showContent(){
		String msg="**************  Playlist **************"+"/n"+
					"**  Title: "+super.getName()+"/n"+
					"**  Duration: "+super.getDuration()+"/n"+
					"**  Genre: "+super.showGenre()+"/n"+
					"Calificacion Promedio: "+getAverageMark()+"/n"+
					"****************************************"+"/n";
		return msg;
	}   
}
