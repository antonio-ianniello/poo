package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public interface Comando {

	String esegui(Partita partita);
	void setParametro(String parametro);
}
