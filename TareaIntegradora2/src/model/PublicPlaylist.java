package model;

public class PublicPlaylist extends Playlist {
	private double rating;
	private double averageRating;
	private double contRatingUsers;
	/** 
	* Create a new public playlist<br>
	* <b> pre: The parameters have to be != null</b> 
	* <b> post: A new public playlist</b> 
	* @param namePlaylist type String
	*/	
	public PublicPlaylist(String namePlaylist) {
		super(namePlaylist);
		averageRating = 0.0;
		contRatingUsers = 0.0;
		rating = 0.0;
	}
	/** 
	* Obtain the average rating of the pplaylist<br>
	* <b> pre: The averageRating has to be != null</b> 
	* <b> post: Show the averageRating of the playlist</b> 
	*/	
	public double getAverageRating() {
		return averageRating;
	}
	/** 
	* Count the number of users that qualificate the playlist <br>
	* <b> pre: </b> 
	* <b> post: The contRatingUsers is increased by 1 unit</b> 
	*/	
	public void setContRatingUsers() {
		contRatingUsers++;
	}
	/** 
	*  Calculate the averageRating of the playlist and update it <br>
	* <b> pre: The qualification has to be != null</b> 
	* <b> post: Update the playlist's averageRating</b> 
	* @param qualification type int
	*/	
	public void setAverageRating(int qualification) {
		rating += qualification;
		averageRating = rating/contRatingUsers;
	}
	/** 
	* Obtain the count of users that already have qualificated the playlist<br>
	* <b> pre: The contRatingUsers has to be != null</b> 
	* <b> post: Show the contRatingUsers</b> 
	*/	
	public double getContRatingUsers() {
		return contRatingUsers;
	}
	/** 
	*  Obtain the total of the qualifications given by the users<br>
	* <b> pre: The Rating has to be != null</b> 
	* <b> post: Return the rating </b> 
	*/	
	public double getRating() {
		return rating;
	}
/** 
	*  Show the public playlist's information<br>
	* <b> pre: </b> 
	* <b> post: Show all the info of the playlist </b> 
	*/	
	@Override
	public String showContents() {
		String info = "**************  Playlist **************"+"\n";
		info += "**  Title: "+super.getNamePlaylist()+"\n";
		info += "**  Duration: "+super.getDurationPlaylist()+"\n";
		info += "**  Genre: "+super.showGenres()+"\n";
		info += "**  Average Rating: "+getAverageRating()+"\n";
		info += "***********************************"+"\n";
		return info;
	}
}