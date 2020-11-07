package model;

public class MCS {
	private final static int MAX_USERS = 10;
	private final static int MAX_PLAYLISTS = 20;
	private final static int MAX_SONGSPOOL = 30;
	private User[] users;
	private Playlist[] playlists;
	private Songs[] pool;
	/** 
	* Create a new MCS<br>
	* <b> pre: Users has to be already initialized</b> 
	* <b> pre: Playlists has to be already initialized</b> 
	* <b> pre: Pool has to be already initialized</b> 
	* <b> post: A new MCS and declare the arrays users, playlists and pool</b> 
	*/		
	public MCS() {
		users = new User[MAX_USERS];
		playlists = new Playlist[MAX_PLAYLISTS];
		pool = new Songs[MAX_SONGSPOOL];
	}
	/** 
	* Obtain the array of users of the MCS<br>
	* <b> pre: Array of users has to be != null</b> 
	* <b> post: Return the array of users</b>  
	*/	
	public User[] getUsers() {
		return users;
	}
	/** 
	* Obtain the array of playlists of the MCS<br>
	* <b> pre: Array of playlists has to be != null</b> 
	* <b> post: Return the array of playlists</b>  
	*/		
	public Playlist[] getPlaylists() {
		return playlists;
	}
	/** 
	* Obtain the array of songs of the MCS<br>
	* <b> pre: Array of songs has to be != null</b> 
	* <b> post: Return the array of songs</b>  
	*/	
	public Songs[] getSongsPool() {
		return pool;
	}
	/** 
	*  Add a new song to the Songs pool <br>
	* <b> pre: The array pool have to be already initialized</b> 
	* <b> pre: The parameters have to be != null</b> 
	* <b> post: Add the new song and show a message</b> 
	* @param title type String
	* @param author type String
	* @param releaseDate type String
	* @param duration type String
	* @param indexGenre type int
	*/	
	public String addSong(String title, String author, String releaseDate, String duration, int indexGenre) {
		String msg = "La cancion no pudo ser agregada";
		boolean added = false;
		Songs newSong = new Songs(title, author, releaseDate, duration, indexGenre);
		for(int i=0; i<MAX_SONGSPOOL && !added; i++) {
			if(pool[i] == null) {
				pool[i] = newSong;
				added = true;
				msg = "La cancion se agrego exitosamente";
			}
		}
		return msg;
	}
	/** 
	*  Save a new user in the application <br>
	* <b> pre: The array users have to be already initialized</b> 
	* <b> pre: The parameters have to be != null</b> 
	* <b> post: Add the new user and show a message</b> 
	* @param username type String
	* @param password type String
	* @param indexGenre type int
	*/		
	public String addUser(String username, String password, int age) {
		String msg = "No se pudo agregar el usuario";
		boolean added = false;
		User newUser = new User(username, password ,age);
		for(int i=0; i<MAX_USERS && !added; i++) {
			if(users[i] == null) {
				users[i] = newUser;
				added = true;
				msg = "El usuario se agrego exitosamente";
			}
		}
		return msg;
	}
	/** 
	*  Look if the user is already in the array of users of the MCS<br>
	* <b> pre: the array users has to be != null</b> 
	* <b> pre: The username has to be != null</b> 
	* <b> post: Boolean found confirming that the user was found or not</b> 
	* @param username type String
	*/	
	public boolean findUser(String username) {
		boolean found = false;
		for(int i=0; i<MAX_USERS && !found; i++) {
			if(users[i] != null && users[i].getUsername().equalsIgnoreCase(username)) {
				found = true;
			}
		}
		return found;
	}
	/** 
	*  Look if the song is already in the array of songs of the MCS<br>
	* <b> pre: the array songs has to be != null</b> 
	* <b> pre: The title and the author has to be != null</b> 
	* <b> post: Boolean found confirming that the song was found or not</b> 
	* @param title type String
	* @param author type String
	*/	
	public Songs findSong(String title, String author) {
		int indexSong = 0;
		boolean found = false;
		for(int i=0; i<MAX_SONGSPOOL && !found; i++) {
			if(pool[i] != null && pool[i].getTitle().equalsIgnoreCase(title) && pool[i].getAuthor().equalsIgnoreCase(author)) {
				found = true;
				indexSong = i;
			}
		}
		return pool[indexSong];
	}
	/** 
	*  Change the category of a user<br>
	* <b> pre: The username has to be != null</b>
	* <b> pre: The user has to be already created</b>
	* <b> post: Change the category of the selected user</b> 
	* @param username type String
	*/	
	public String updateUserCategory(String username) {
		String updated = "";
		boolean found = false;
		for(int i=0; i<MAX_USERS && !found; i++) {
			if(users[i] != null && users[i].getUsername().equalsIgnoreCase(username)) {
				found = true;
				users[i].addSharedSong();
				updated = users[i].setCategory();
			}
		}
		return updated;
	}
	/** 
	*  Show the MCS's Users<br>
	* <b> pre: Array users has to be != null</b> 
	* <b> post: Show all the users of the MCS </b> 
	*/	
	public String showUsers() {
		String msg = "Usuarios del MCS"+"\n"+"\n";
		for(int i=0; i<MAX_USERS; i++) {
			if(users[i] != null) {
				msg += users[i].showContents();
			}
		}
		return msg;
	}
	/** 
	*  Show the MCS's songs<br>
	* <b> pre: Array songs has to be != null</b> 
	* <b> post: Show all the songs of the MCS </b> 
	*/	
	public String showSongsPool() {
		String songsPool = "POOL DE CANCIONES"+"\n"+"\n";
		for(int i=0; i<MAX_SONGSPOOL; i++) {
			if(pool[i] != null) {
				songsPool += pool[i].showContents();
			}
		}
		return songsPool;
	}
	/** 
	*  Save a new PublicPlaylist in the application <br>
	* <b> pre: The array playlists have to be already initialized</b> 
	* <b> pre: The parameters have to be != null</b> 
	* <b> post: Add the new PublicPlaylist and show a message</b> 
	* @param namePlaylist type String
	*/		
	public String addPlaylist(String namePlaylist) {
		String msg = "No se pudo agregar la nueva Playlist - ";
		boolean added = false;
		PublicPlaylist newPublicPlaylist = new PublicPlaylist(namePlaylist);
		for(int i=0; i<MAX_PLAYLISTS && !added; i++) {
			if(playlists[i] == null) {
				playlists[i] = newPublicPlaylist;
				added = true;
				msg = "Se creo la nueva playlist: "+playlists[i].getNamePlaylist();
			}
		}
		if(added == false) {
			msg += "Limite maximo de playlists completo";
		}
		return msg;
	}
	/** 
	*  Save a new PrivatePlaylist in the application <br>
	* <b> pre: The array playlists have to be already initialized</b> 
	* <b> pre: The parameters have to be != null</b> 
	* <b> post: Add the new PrivatePlaylist and show a message</b> 
	* @param namePlaylist type String
	* @param username type String
	* @param password type String
	* @param age type int
	*/	
	public String addPlaylist(String namePlaylist, String username, String password, int age) {
		String msg = "No se pudo agregar la nueva Playlist - ";
		boolean added = false;
		PrivatePlaylist newPrivatePlaylist = new PrivatePlaylist(namePlaylist, username, password, age);
		for(int i=0; i<MAX_PLAYLISTS && !added; i++) {
			if(playlists[i] == null) {
				playlists[i] = newPrivatePlaylist;
				added = true;
				msg = "Se creo la nueva playlist: "+(char)34+playlists[i].getNamePlaylist()+(char)34;
			}
		}
		if(added == false) {
			msg += "Limite maximo de playlists completo";
		}
		return msg;
	}
	/** 
	*  Save a new RestrictedPlaylist in the application <br>
	* <b> pre: The array playlists have to be already initialized</b> 
	* <b> pre: The parameters have to be != null</b> 
	* <b> post: Add the new RestrictedPlaylist and show a message</b> 
	* @param username type String
	* @param password type String
	* @param age type int
	* @param namePlaylist type String
	*/	
	public String addPlaylist(String username, String password, int age, String namePlaylist) {
		String msg = "No se pudo agregar la nueva Playlist - ";
		boolean added = false;
		RestrictedPlaylist newRestrictedPlaylist = new RestrictedPlaylist(username, password, age, namePlaylist);
		for(int i=0; i<MAX_PLAYLISTS && !added; i++) {
			if(playlists[i] == null) {
				playlists[i] = newRestrictedPlaylist;
				added = true;
				msg = "Se creo la nueva playlist: "+playlists[i].getNamePlaylist();
			}
		}
		if(added == false) {
			msg += "Limite maximo de playlists completo";
		}
		return msg;
	}
	/** 
	*  Obtain the type of a playlist<br>
	* <b> pre: The playlist has to be already created</b> 
	* <b> post: Save the type of the playlist</b> 
	* @param namePlaylist type String
	*/	
	public int getTypePlaylist(String namePlaylist) {
		int typeOfPlaylist = 0;
		boolean found = false;
			for(int i=0; i<MAX_PLAYLISTS && !found; i++) {
				if(playlists[i] != null && playlists[i].getNamePlaylist().equalsIgnoreCase(namePlaylist)) {
					if(playlists[i] instanceof PrivatePlaylist) {
						typeOfPlaylist = 1;
					}
					else if(playlists[i] instanceof RestrictedPlaylist) {
						typeOfPlaylist = 2;
					}
					else if(playlists[i] instanceof PublicPlaylist) {
						typeOfPlaylist = 3;
					}
				}
			}
		return typeOfPlaylist;
	}
	/** 
	*  Look if the playlist is already in the array of playlists of the MCS<br>
	* <b> pre: the array playlists has to be != null</b> 
	* <b> pre: The namePlaylist and the author has to be != null</b> 
	* <b> post: Boolean found confirming that the playlist was found or not</b> 
	* @param namePlaylist type String
	*/	
	public boolean findPlaylist(String namePlaylist) {
		boolean found = false;
			for(int i=0; i<MAX_PLAYLISTS && !found; i++) {
				if(playlists[i] != null && playlists[i].getNamePlaylist().equalsIgnoreCase(namePlaylist)) {
					found = true;
				}
			}
		return found;
	}
	/** 
	*  Save a new song in the playlist <br>
	* <b> pre: The playlist has to be already created</b> 
	* <b> pre: The song has to be already shared in the pool</b> 
	* <b> post: Add the new song and show a message</b> 
	* @param namePlaylist type String
	* @param song type Song
	*/	
	public String addSongPlaylist(String namePlaylist, Songs song) {
		PublicPlaylist newPublicPlaylist;
		PrivatePlaylist newPrivatePlaylist;
		RestrictedPlaylist newRestrictedPlaylist;
		
		String songAdded = "La cancion no se pudo agregar - ";
		boolean found = false;
		boolean added = false;
			for(int j=0; j<MAX_PLAYLISTS && !found; j++) {
				if(playlists[j] != null && playlists[j].getNamePlaylist().equalsIgnoreCase(namePlaylist)) {	
					if(playlists[j] instanceof PublicPlaylist) {
						newPublicPlaylist = (PublicPlaylist)playlists[j];
						int durationSongs = song.durationToSeconds();
						newPublicPlaylist.updateDurationPlaylist(durationSongs);
						newPublicPlaylist.setDurationPlaylist();
					}
					else if(playlists[j] instanceof PrivatePlaylist) {
						newPrivatePlaylist = (PrivatePlaylist)playlists[j];
						int durationSongs = song.durationToSeconds();
						newPrivatePlaylist.updateDurationPlaylist(durationSongs);
						newPrivatePlaylist.setDurationPlaylist();
					}
					else if(playlists[j] instanceof RestrictedPlaylist) {
						newRestrictedPlaylist = (RestrictedPlaylist)playlists[j];
						int durationSongs = song.durationToSeconds();
						newRestrictedPlaylist.updateDurationPlaylist(durationSongs);
						newRestrictedPlaylist.setDurationPlaylist();
					}
					added = true;
					songAdded = "La cancion se agrego a la Playlist";
				}
			}
		if(added == false) {
			songAdded += "No se encontro en el pool de canciones";
		}
		return songAdded;
	}
	/** 
	* Add a new genre to the playlist<br>
	* <b> pre: The song and the playlist have to be already created</b> 
	* <b> post: Add the genre to the playlist and show a message</b> 
	* @param namePlaylist type String
	* @param song type Songs
	*/	
	public String updatingPlaylistGenre(String namePlaylist, Songs song) {
		String updated = "";
		boolean playlistFound = false;
			for(int i=0; i<MAX_PLAYLISTS && !playlistFound; i++) {
				if(playlists[i] != null && playlists[i].getNamePlaylist().equalsIgnoreCase(namePlaylist)) {
					updated = playlists[i].updatePlaylistGenre(song)+"\n";
					playlistFound = true;
				}
			}
		return updated;
	}
	/** 
	*  Show the MCS's playlists<br>
	* <b> pre: Array playlists has to be != null</b> 
	* <b> post: Show all the playlists of the MCS </b> 
	*/	
	public String showPlaylists() {
		String playlistsInfo = "PLAYLISTS DEL MCS"+"\n";
		for(int i=0; i<MAX_PLAYLISTS; i++) {
			if(playlists[i] != null) {
				playlistsInfo += playlists[i].showContents();
			}
		}
		return playlistsInfo;
	}
	/** 
	*  Qualificate a public playlist<br>
	* <b> pre: The playlist has to be already created</b> 
	* <b> post: The playlist'qualification updated and a message</b> 
	* @param namePlaylist type String
	* @param qualification type int
	*/	
	public String ratingPlaylist(String namePlaylist, int qualification) {
		String msg = "La calificacion de la Playlist no pudo actualizarse - ";
		boolean found = false;
		PublicPlaylist newPublicPlaylist;
			for(int i=0; i<MAX_PLAYLISTS && !found; i++) {
				if(playlists[i] != null && playlists[i].getNamePlaylist().equalsIgnoreCase(namePlaylist) && playlists[i] instanceof PublicPlaylist) {
					found = true;
					newPublicPlaylist = (PublicPlaylist)playlists[i];
					newPublicPlaylist.setContRatingUsers();
					newPublicPlaylist.setAverageRating(qualification);
					msg = "La calificacion de la Playlist fue actualizada"+"\n";
					msg += "La calificacion promedio actual de la Playlist es: "+newPublicPlaylist.getAverageRating();
				}
			}
		if(found == false) {
			msg += "Playlist no encontrada";
		}
		return msg;
	}
	/** 
	*  Add a user to the playlist and give him access <br>
	* <b> pre: The user have to be already registered</b> 
	* <b> pre: The playlist have to be already created</b> 
	* <b> post: Add the user to the playlist and show a message </b> 
	* @param username type String
	* @param password type String
	* @param age type int
	* @param namePlaylist type String
	*/	
	public String giveAccessUser(String username, String password, int age, String namePlaylist) {
		String msg = "";
		boolean found = false;
		RestrictedPlaylist newRestrictedPlaylist;
			for(int i=0; i<MAX_PLAYLISTS && !found; i++) {
				if(playlists[i].getNamePlaylist().equalsIgnoreCase(namePlaylist)) {
					newRestrictedPlaylist = (RestrictedPlaylist)playlists[i];
					msg = newRestrictedPlaylist.addAccessUser(username, password, age)+"\n";
					found = true;
					if(msg.equalsIgnoreCase("Se agrego un nuevo usuario con acceso")) {
						msg += "Se le ha otorgado acceso a la Playlist "+(char)34+newRestrictedPlaylist.getNamePlaylist()+(char)34+" al usuario "+username;
					}
				}
			}
		return msg;
	}
}