package it.uniroma3.diadia.io;

import java.util.Scanner;

public class InterfacciaUtenteCOnsole implements InterfacciaUtente {
private static InterfacciaUtente instance=null;

public InterfacciaUtenteCOnsole() {
	
}

public static InterfacciaUtente getInstance() {
	if(instance == null) instance = new InterfacciaUtenteCOnsole();
	return instance;
}

@Override
public void mostraMessaggio(String messaggio) {
	System.out.println(messaggio);
}

@Override
public String prendiIstruzione() {
	Scanner scanner = new Scanner(System.in);		//poi dovro' chiudere questo scanner
	return scanner.nextLine();
}
}
