package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;


//implements Comando ?? non penso proprio
public class ComandoBorsa implements Comando {
	
	@Override
	public String esegui(Partita partita) {
		return partita.getGiocatore().getBorsa().toString();
	}


	public void setParametro(String parametro) {
	}

}