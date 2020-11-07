package ui;
import model.*;
import java.util.Scanner;

public class Menu {
	private final static int ADD_USER = 1;
	private final static int SHOW_USERS = 2;
	private final static int ADD_SONG = 3;
	private final static int SHOW_SONGS_POOL = 4;
	private final static int ADD_PLAYLIST = 5;
	private final static int ADD_SONG_TO_PLAYLIST = 6;
	private final static int SHOW_PLAYLISTS = 7;
	private final static int RATING_PLAYLIST = 8;
	private final static int GIVE_ACCESS = 9;
	private final static int EXIT = 10;
	private static Scanner input = new Scanner(System.in);
	private MCS newMCS;
	
	/** 
	* Create the menu object<br>
	* <b> pre: The newMCS has to be already initializated </b> 
	* <b> pre: The MCS class has to be already created </b> 
	* <b> post: Declares the object newMCS </b> 
	*/	
	public Menu() {
		this.newMCS = new MCS();
	}
	/** 
	* Main menu of the application<br>
	* <b> pre: The user cant choose an option that's not on the menu</b> 
	* <b> post: The user choose an option</b> 
	*/	
	public void showMenu() {
		System.out.println("(1) Agregar un nuevo usuario");
		System.out.println("(2) Mostrar todos los usuarios del MCS");
		System.out.println("(3) Crear una nueva cancion y agregarla al pool de canciones");
		System.out.println("(4) Mostrar el pool de canciones compartidas");
		System.out.println("(5) Crear una Playlist");
		System.out.println("(6) Agregar una cancion a una Playlist");
		System.out.println("(7) Mostrar las Playlists del MCS");
		System.out.println("(8) Calificar una Playlist");
		System.out.println("(9) Otorgar acceso a un usuario sobre una playlist restringida");
		System.out.println("(10) Salir");
	}
	/** 
	*  Read and save an option that the user chose<br>
	* <b> pre: The option has to be representated by an integer</b> 
	* <b> post: Return the integer choice</b> 
	*/	
	public int readOption() {
		int choice = input.nextInt();
		input.nextLine();
		return choice;
	}
	/** 
	*  Create and register a new user in the application<br>
	* <b> pre: The username has to be a text string without spaces</b> 
	* <b> pre: The password has to be a text string</b> 
	* <b> pre: The age has to be an integer</b> 
	* <b> post: Create the new user and show a message </b> 
	*/	
	public String readUser() {
		System.out.println("Ingrese el nombre del usuario (caracteres sin espacio): ");
		String username = input.nextLine();
		System.out.println("Ingrese una contrasena: ");
		String password = input.nextLine();
		System.out.println("Digite la edad del usuario: ");
		int age = input.nextInt();
		input.nextLine();
		String msg = newMCS.addUser(username, password, age);
		return msg;
	}
	/** 
	* Create and save a new playlist <br>
	* <b> pre: The playlist name has to be a text string </b> 
	* <b> pre: The users that will be added for the private and restricted playlist have to be already created </b> 
	* <b> post: Create the new playlist and show a message</b> 
	*/	
	public String readPlaylist() {
		String msg = "";
		System.out.println("(1) Playlist Publica"+"\n"+"(2) Playlist Privada"+"\n"+"(3) Playlist Restringida"+"\n");
		int type = input.nextInt();
		input.nextLine();
		System.out.println("Ingrese el nombre de la Playlist: ");
		String namePlaylist = input.nextLine();
			switch(type) {
				case 1:
					msg = newMCS.addPlaylist(namePlaylist);
					break;
				case 2:
					System.out.println("Crear unico usuario con acceso a la Playlist "+(char)34+namePlaylist+(char)34);
					System.out.println("Ingrese el nombre del usuario: ");
					String nameUser = input.nextLine();
					System.out.println("Ingrese la contrasena del usuario: ");
					String passwordUser = input.nextLine();
					System.out.println("Ingrese la edad del usuario: ");
					int ageUser = input.nextInt();
					input.nextLine();
					msg = newMCS.addPlaylist(namePlaylist, nameUser, passwordUser, ageUser);
					break;
				case 3:
					System.out.println("Crear el primer usuario con acceso a la Playlist "+(char)34+namePlaylist+(char)34);
					System.out.println("Ingrese el nombre del usuario: ");
					String username = input.nextLine();
					System.out.println("Ingrese la contrasena del usuario: ");
					String password = input.nextLine();
					System.out.println("Ingrese la edad del usuario: ");
					int age = input.nextInt();
					input.nextLine();
					msg = newMCS.addPlaylist(username, password, age, namePlaylist);
					break;
				default:
			}
		return msg;
	}
	/** 
	*  Create and share a new song <br>
	* <b> pre: The user that will be used to create the song has to be already registered</b>
	* <b> pre: The genre has to be representated by an integer</b> 
	* <b> post: Create and share the new song and </b> 
	* <b> post: Update the number of shared songs of the user that created the song</b>   
	*/	
	public String readToAddSong() {
		String msg = "";
		System.out.println("Ingrese el username del usuario que creara la cancion: ");
		String username = input.nextLine();
		boolean checkUser = newMCS.findUser(username);
			if(checkUser) {
				System.out.println("Ingrese el nombre de la cancion: ");
				String title = input.nextLine();
				System.out.println("Ingrese el nombre del autor: ");
				String author = input.nextLine();
				System.out.println("Ingrese la fecha de lanzamiento (dd/mm/aaaa): ");
				String releaseDate = input.nextLine();
				System.out.println("Ingrese la duracion de la cancion (min:seg): ");
				String duration = input.nextLine();
				System.out.println("Genero de la cancion: ");
				System.out.println("(0) Desconocido");
				System.out.println("(1) Rock");
				System.out.println("(2) Hip hop");
				System.out.println("(3) Musica Clasica");
				System.out.println("(4) Reggae");
				System.out.println("(5) Salsa");
				System.out.println("(6) Metal");
				int indexGenre = input.nextInt();
				input.nextLine();
				msg += newMCS.addSong(title, author, releaseDate, duration, indexGenre)+"\n";
				msg += newMCS.updateUserCategory(username);
			}
			else {
				System.out.println("El usuario no esta registrado en la app");
			}
		return msg;
	}
	/** 
	* Save a new song in playlist on the application <br>
	* <b> pre: The playlist has to be already created</b> 
	* <b> pre: The song has to be already shared </b>
	* <b> post: Add the song to the playlist and show a message</b> 
	*/	
	public String readToAddSongPlaylist() {
		String msg = "";
		System.out.println("Ingrese el nombre de la Playlist: ");
		String namePlaylist = input.nextLine();
			if(newMCS.findPlaylist(namePlaylist) == true) {
				System.out.println("Ingrese el nombre de la cancion: ");
				String title = input.nextLine();
				System.out.println("Ingrese el autor de la cancion: ");
				String author = input.nextLine();
				Songs song = newMCS.findSong(title, author);
				msg = newMCS.addSongPlaylist(namePlaylist, song)+"\n";
				msg += newMCS.updatingPlaylistGenre(namePlaylist, song);
			}
			else {
				System.out.println("La playlist "+(char)34+namePlaylist+(char)34+" no se encuentra");
			}
		return msg;	
	}
	/** 
	*  Rate a public playlist <br>
	* <b> pre: The public playlist has to be already created </b> 
	* <b> pre: The qualification has to be an integer </b> 
	* <b> post: Save the qualification and show a message</b> 
	*/	
	public String readToRatingPlaylist() {
		String msg = "";
		System.out.println("Nombre de la Playlist que quieres calificar: ");
		String namePlaylist = input.nextLine();
		if(newMCS.findPlaylist(namePlaylist) == true) {
			System.out.println("Digite la calificacion (1-5): ");
			int qualification = input.nextInt();
			input.nextLine();
			msg = newMCS.ratingPlaylist(namePlaylist, qualification);
		}
		return msg;
	}
	/** 
	*  Give acces to restricted playlist for a new user <br>
	* <b> pre: The restricted playlist has to be already created</b> 
	* <b> pre: The number of users with acces has to be less than 5</b> 
	* <b> pre: The user that will have access has to be already registered</b> 
	* <b> post: Give access to the user and show a message</b> 
	*/	
	public String readToGiveAccess() {
		String msg = "";
		System.out.println("Ingrese el nombre de la Playlist a la que desea agregar el usuario de acceso: ");
		String namePlaylist = input.nextLine();
			if(newMCS.findPlaylist(namePlaylist) == true) {
				System.out.println("Ingrese el username del usuario al que quiere otorgar acceso: ");
				String username = input.nextLine();
				if(newMCS.findUser(username)) {
					System.out.println("Ingrese la contrasena del usuario");
					String password = input.nextLine();
					System.out.println("Digite la edad del usuario: ");
					int age = input.nextInt();
					msg = newMCS.giveAccessUser(username, password, age, namePlaylist);
				}
				else {
					msg = "El usuario indicado no esta registrado en el MCS";
				}
			}
		return msg;
	}
	/** 
	*  Call the method that run the option chose by the user<br>
	* <b> pre: The choice has to be an integer</b> 
	* <b> post: </b> 
	*/	
	public void doOperation(int choice) {
		switch(choice) {
			case ADD_USER:
				System.out.println(readUser());
				break;
			case SHOW_USERS:
				System.out.println(newMCS.showUsers());
				break;
			case ADD_SONG:
				System.out.println(readToAddSong());
				break;
			case SHOW_SONGS_POOL:
				System.out.println(newMCS.showSongsPool());
				break;
			case ADD_PLAYLIST:
				System.out.println(readPlaylist());
				break;
			case ADD_SONG_TO_PLAYLIST:
				System.out.println(readToAddSongPlaylist());
				break;
			case SHOW_PLAYLISTS:
				System.out.println(newMCS.showPlaylists());
				break;
			case RATING_PLAYLIST:
				System.out.println(readToRatingPlaylist());
				break;
			case GIVE_ACCESS:
				System.out.println(readToGiveAccess());
				break;
			case EXIT:
				break;
			default:
				System.out.println("Opcion invalida, repita nuevamente");
		}
	}
	/** 
	* Show the application's logo<br>
	* <b> pre: </b> 
	* <b> post: Print the logo of the application</b> 
	*/	
	public void showLogo() {
		System.out.println("(((((((((((((((((((((((((((((((((((((((((((((((((");
		System.out.println("((((((((((((((((/((((((((((((((((((((((((((((((((");
		System.out.println("(((/  .(((((((*  .((((((*        (((((/      /(((");
		System.out.println("(((/   .((((((.  .(((((   ,((((((((((*  .((((((((");
		System.out.println("(((/    /((((/   .((((/  ,(((((((((((.  /((((((((");
		System.out.println("(((/     ((((*   .((((*  ,(((((((((((/   ((((((((");
		System.out.println("(((/  * * (((*   *((((* ,((((((((((((,  .(((((((");
		System.out.println("(((/  /.  ((*     ((((*  *(((((((((((((,   ((((((");
		System.out.println("(((/  //  ,(  .   ((((*  *((((((((((((((/   /((((");
		System.out.println("(((/  (  ,  *(*   ((((*  *((((((((((((((((   /(((");
		System.out.println("(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   (((");
		System.out.println("(((/  .((    ((   /((((  .(((((((((((((((((.  /((");
		System.out.println("(((/  .((.  .((.  *((((,  *((((((((((((((((   /((");
		System.out.println("(((/  .((((((((.  *(((((   *((((/,/(((((((/   (((");
		System.out.println("(((/  .((((((((.  *((((((.        *((   .   .((((");
		System.out.println("(((((((((((((((/*/((((((((((///(((((((////(((((((");
		System.out.println("(((((((((((((((((((((((((((((((((((((((((((((((((");
		System.out.println("               ./(###((///((###(*");
		System.out.println("           *#(,                   *((,");
		System.out.println("        ,#/                           ((");
		System.out.println("      .#*          .**/////*,.          ((");
		System.out.println("     *(.      .//////////////////*       *#");
		System.out.println("    .#,     *///////////////////////,     /(");
		System.out.println("    /(    *///////////////////////////    .#.");
		System.out.println("  ,/////,*/////////////////////////////,*////*.");
		System.out.println("  /////////////////////////*,...,/////////////,");
		System.out.println("  //////*,,,*********,,.............,,,,,//////,");
		System.out.println("  //////.........//........//*.......,...//////,");
		System.out.println("  //////*.........,,.........,,.........,//////,");
		System.out.println("  //////*...............................,//////,");
		System.out.println("   *///*  ........,/.........**.......*  *.*///,");
		System.out.println("            .......,/.....,/.......");
		System.out.println("               ........,,,,.......");
		System.out.println("                    .........");
		System.out.println("");
		System.out.println("***************************************************");
	}
	/** 
	*  Run the whole application<br>
	* <b> pre: The option has to be an integer</b> 
	* <b> post: Run the program</b> 
	*/	
	public void startProgram() {
		System.out.println("¡Bienvenido a MCS!"+"\n");
		showLogo();
		int option;
		do {
			showMenu();
			option = readOption();
			doOperation(option);
		} while(option != EXIT);
	}
}