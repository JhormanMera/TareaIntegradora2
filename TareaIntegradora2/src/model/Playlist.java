package model;

public abstract class Playlist {
	private final static int NUM_GENRES = 7;
	private final static int MAX_SONGS = 30;
	private final MusicalGenre[] GENRES = MusicalGenre.values();
	private String namePlaylist;
	private String durationPlaylist;
	private int totalDurationPlaylist;
	private String[] musicalGenre;
	private Songs[] songs;
	/** 
	* Create a new playlist<br>
	* <b> pre: The parameters have to be != null</b> 
	* <b> post: A new playlist</b> 
	* @param namePlaylist type String
	*/	
	public Playlist(String namePlaylist) {
		this.namePlaylist = namePlaylist;
		durationPlaylist = "00:00";
		musicalGenre = new String[NUM_GENRES];
		songs = new Songs[MAX_SONGS];
	}
	/** 
	* Obtain the name of a playlist<br>
	* <b> pre: Name has to be != null</b> 
	* <b> post: Return the name</b>  
	*/	
	public String getNamePlaylist() {
		return namePlaylist;
	}
	/** 
	*  Modify the name of a playlist<br>
	* <b> pre: The new name has to be != null</b> 
	* <b> post: Change the name to the newone</b> 
	* @param name type String
	*/
	public void setNamePlaylist(String namePlaylist) {
		this.namePlaylist = namePlaylist;
	}
	/** 
	* Obtain the duration of a playlist<br>
	* <b> pre: Duration has to be != null</b> 
	* <b> post: Return the duration</b>  
	*/	
	public String getDurationPlaylist() {
		return durationPlaylist;
	}
	/** 
	* Obtain the array of songs of a playlist<br>
	* <b> pre: Array songs has to be != null</b> 
	* <b> post: Return the array songs</b>  
	*/	
	public Songs[] getSongs() {
		return songs;
	}
	/** 
	*  Look if the song is already in the array of songs of the playlist<br>
	* <b> pre: the array songs has to be != null</b> 
	* <b> pre: The title has to be != null</b> 
	* <b> pre: The author has to be != null</b> 
	* <b> post: Boolean found confirming that the song was found or not</b> 
	* @param title type String
	* @param author type String
	*/	
	public boolean findSong(String title, String author) {
		boolean found = false;
			for(int i=0; i<MAX_SONGS && !found; i++) {
				if(songs[i] != null && songs[i].getTitle().equalsIgnoreCase(title) && songs[i].getAuthor().equalsIgnoreCase(author)) {
					found = true;
				}
			}
		return found;
	}
	/** 
	*  Update the accumulator of the duration of the playlist in seconds<br>
	* <b> pre: the totalDurationPlaylist has to be already initialized</b> 
	* <b> post: Add the time of the new song to the current playlist duration </b> 
	* @param songDuration type int
	*/	
	public void updateDurationPlaylist(int songDuration) {  //Aqui entra por parametro lo que retorna el metodo durationToSeconds de la cancion agregada
		totalDurationPlaylist += songDuration;
	}
	/** 
	* Cast the duration of the playlist from seconds to hh:mm:ss <br>
	* <b> pre: The totalDurationPlaylist has to be != null</b> 
	* <b> post: The durationPlaylist in hh:mm:ss format</b> 
	*/	
	public void setDurationPlaylist() {
		int hour = (int)totalDurationPlaylist/3600;
		int minute = (int)(totalDurationPlaylist-(3600*hour))/60;
		int seconds = (int)totalDurationPlaylist-((hour*3600)+(minute*60));
		durationPlaylist = "0"+hour+":"+minute+":"+seconds;
	}
	/** 
	* Obtain the array of genres of a playlist<br>
	* <b> pre: Array genres has to be != null</b> 
	* <b> post: Return the array genres</b>  
	*/	
	public String[] getMusicalGenre() {
		return musicalGenre;
	}
	/** 
	*  Show the playlist's genres<br>
	* <b> pre: musicalGenre has to be != null</b> 
	* <b> post: Show all the genres of the playlist </b> 
	*/	
	public String showGenres() {
		String genres = "";
		for(int i=0; i<NUM_GENRES; i++) {
			if(musicalGenre[i] != null) {
				genres += musicalGenre[i]+", ";
			}
		}
		return genres;
	}
	/** 
	*  Update the array genre of the playlist<br>
	* <b> pre: The song and the playlist have to be already created</b> 
	* <b> post: Add the genre to the playlist and show a message</b> 
	* @param song type Songs
	*/	
	public String updatePlaylistGenre(Songs song) {
		String updated = "El genero de la Playlist no ha sido actualizado - ";
		boolean found = false;
			for(int i=0; i<NUM_GENRES && !found; i++) {
				if(musicalGenre[i] != null && musicalGenre[i].equalsIgnoreCase(song.getGenre())) {
					found = true;
					updated = "El genero de la Playlist ha sido actualizado (ya existe en la playlist)";
				}
				else if(found == false) {
					for(int k=0; k<NUM_GENRES && !found; k++) {
						if(musicalGenre[k] == null) {
							musicalGenre[k] = song.getGenre();
							found = true;
							updated = "El genero de la Playlist ha sido actualizado";
						}
					}
				}
			}
		return updated;
	}
	public abstract String showContents();
}