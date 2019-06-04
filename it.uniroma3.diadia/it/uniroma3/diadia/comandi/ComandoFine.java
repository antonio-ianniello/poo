package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;


//estensione di abstract comando
public class ComandoFine extends AbstractComando{
	
	@Override
	public String esegui(Partita partita) {
		partita.setFinita();
		return "Game over!\nGrazie di aver giocato";
	}
}
