package model;

public class Songs {
	private final MusicalGenre[] GENRES = MusicalGenre.values();
	private String title;
	private String author;
	private String releaseDate;
	private String duration;
	private String genre;
	/** 
	*  Create a new song<br>
	* <b> pre: The parameters have to be != null</b> 
	* <b> post: Create a new song in the application</b> 
	* @param title type String 
	* @param author type String
	* @param releaseDate type String
	* @param duration type String
	* @param indexGenre type int
	*/	
	public Songs(String title, String author, String releaseDate, String duration, int indexGenre) {
		this.title = title;
		this.author = author;
		this.releaseDate = releaseDate;
		this.duration = duration;
		genre = GENRES[indexGenre].name();
	}
	/** 
	* Obtain the title of a song<br>
	* <b> pre: title has to be != null</b> 
	* <b> post: Return the title</b>  
	*/	
	public String getTitle() {
		return title;
	}
	/** 
	*  Modify the title of a song<br>
	* <b> pre: The new Title has to be != null</b> 
	* <b> post: Change the title to the newone</b> 
	* @param title type String
	*/
	public void setTitle(String title) {
		this.title = title;
	}
	/** 
	* Obtain the author of a song<br>
	* <b> pre: Author has to be != null</b> 
	* <b> post: Return the author</b>  
	*/		
	public String getAuthor() {
		return author;
	}
	/** 
	*  Modify the author of a song<br>
	* <b> pre: The new author has to be != null</b> 
	* <b> post: Change the author to the newone</b> 
	* @param author type String
	*/
	public void setAuthor(String author) {
		this.author = author;
	}
	/** 
	* Obtain the releaseDate of a song<br>
	* <b> pre: ReleaseDate has to be != null</b> 
	* <b> post: Return the releaseDate</b>  
	*/		
	public String getReleaseDate() {
		return releaseDate;
	}
	/** 
	*  Modify the releaseDate of a song<br>
	* <b> pre: The new releaseDate has to be != null</b> 
	* <b> post: Change the releaseDate to the newone</b> 
	* @param releaseDate type String
	*/
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	/** 
	* Obtain the duration of a song<br>
	* <b> pre: Duration has to be != null</b> 
	* <b> post: Return the duration</b>  
	*/		
	public String getDuration() {
		return duration;
	}
	/** 
	*  Modify the duration of a song<br>
	* <b> pre: The new duration has to be != null</b> 
	* <b> post: Change the duration to the newone</b> 
	* @param duration type String
	*/
	public void setDuration(String duration) {
		this.duration = duration;
	}
	/** 
	* Calculate and convert the durations of the song to seconds <br>
	* <b> pre: The duration has to be != null</b> 
	* <b> post: Save the song's duration in seconds</b> 
	*/	
	public int durationToSeconds() {
		int secondsDuration = 0;
		String[] durationParts = duration.split(":"); 
		int min = Integer.parseInt(durationParts[0]);
		int seg = Integer.parseInt(durationParts[1]);
		secondsDuration = (min*60)+seg;
		return secondsDuration; 
	}
	/** 
	* Obtain the genre of a song<br>
	* <b> pre: Genre has to be != null</b> 
	* <b> post: Return the genre</b>  
	*/		
	public String getGenre() {
		return genre;
	}
	/** 
	*  Modify the genre of a song<br>
	* <b> pre: The new genre has to be != null</b> 
	* <b> post: Change the genre to the newone</b> 
	* @param genre type String
	*/
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/** 
	*  Show the song's information<br>
	* <b> pre: </b> 
	* <b> post: Show all the info of the song </b> 
	*/	
	public String showContents() {
		String info = "**************  Song **************"+"\n";
		info += "**  Title: "+getTitle()+"\n";
		info += "**  Artist: "+getAuthor()+"\n";
		info += "**  Duration: "+getDuration()+"\n";
		info += "**  Genre: "+getGenre()+"\n";
		info += "***********************************"+"\n";
		return info;
	}
}