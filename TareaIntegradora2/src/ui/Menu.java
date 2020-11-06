package ui;
import model.*;
import java.util.Scanner;

public class Menu {
	private final static int ADD_USER = 1;
	private MSC msc; 
	private static Scanner sc = new Scanner (System.in);

public Menu(){
    this.msc= new MSC();
}

public void showMenu(){
System.out.println("*****************MENU*****************");
System.out.println("Seleccione (1) Ingresar un nuevo usuario");
System.out.println("Seleccione (2) ");
System.out.println("Seleccione (3) ");
System.out.println("Seleccione (4) ");
}

	public int readOption(){
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	}
	public String readUser(){
		System.out.println("*****************USUARIO*****************");
		System.out.println("Nombre de Usuario");
		String name=sc.nextLine();
		System.out.println("Contraseña");
		String password=sc.nextLine();
		System.out.println("Ingrese la edad del usuario "+name);
		int age=sc.nextInt();
		sc.nextLine();
		String user=this.msc.addUser(name, password, age);
		return user;
	}
	public
	public void readPlaylist(){
		System.out.println("*****************PLAYLIST*****************");
		System.out.println("Ingrese el tipo de Playlist que desea crear");
		System.out.println("1 (PUBLICA) 2 (RESTRINGIDA) 3 (PRIVADA)");
		int playlistType=sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el nombre de la Playlist");
		String playlistName=sc.nextLine();
			switch(playlistType){
				case 1:
				
				break;
				case 2:

				break;
				case 3:

				break;
			}
	}		
	public void doOperation(int choice){
		switch(choice){
			case ADD_USER:
			readUser();
			break;
			case :
			
			break;
			case :
				
			break;
			case :
			
			break;
			case EXIT:
			break;
			default:
			System.out.println("Digite una opcion valida");
		}
	}
	public void startProgram(){
		int option;
		do {
			showMenu();
			option=readOption();
			doOperation(option);
		} while (option !=EXIT);
	}
}
