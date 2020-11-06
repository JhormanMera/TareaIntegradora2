package ui;
import model.*;
public class Main {
	/*
	javac -cp src src/ui/Main.java -d bin
	java -cp bin ui.Main
	*/
	public static void main (String[] args){
		Menu m;
		m=new Menu();
		m.startProgram();
	}
}