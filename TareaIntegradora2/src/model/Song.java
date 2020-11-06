package model;

public class Song {
	private final MusicalGender[] genres =MusicalGender.values();
    private String title;
    private String nameArtist;
    private String date;
    private String durationSong;
	private String genre;

    public Song(String title, String nameArtist, String date, String durationSong,int genre){
    this.title= title;
    this.nameArtist= nameArtist;
    this.date= date;
    this.durationSong=durationSong;
	this.genre=genres[genre].name();
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title= title;
    }
    public String getNameArtist(){
        return nameArtist;
    }
    public void setNameArtist(String nameArtist){
        this.nameArtist= nameArtist;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date= date;
    }
    public String getDurationSong(){
        return durationSong;
    }
    public void setDurationSong(String durationSong){
        this.durationSong= durationSong;
    }
	public String getGenre(){
		return this.genre;
	}
	public void setGenre(int genre){
		this.genre=genres[genre].name();
	}
	public int toSeconds(){
		int seconds=0;
		String[] durationParts=this.durationSong.split(":");
		int min =Integer.parseInt(durationParts[0]);
		int sec =Integer.parseInt(durationParts[1]);
		seconds=(min*60)+sec;
		return seconds;
	}
	public String showContent(){
		String msg= "**************  Song **************"+"/n"+
				"**  Title: "+getTitle()+"/n"+
				"**  Artist: "+getNameArtist()+"/n"+
				"**  Duration: "+getDuationSong()+"/n"+
				"**  Genre: " getGenre()+"/n"+
				"***********************************"+"/n";
		return msg;
	}


}
