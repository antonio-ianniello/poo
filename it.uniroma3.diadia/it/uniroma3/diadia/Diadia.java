package it.uniroma3.diadia;
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class Diadia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	

	
	
	private Partita partita;
    private InterfacciaUtente interfacciaUtente = new InterfacciaUtenteConsole();

	public Diadia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		interfacciaUtente.mostraMessaggio(MESSAGGIO_BENVENUTO);
        do
            istruzione = interfacciaUtente.prendiIstruzione();
        while (processaIstruzione(istruzione));
    }

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		//Comando comandoDaEseguire = new Comando(istruzione);

		Comando comandoDaEseguire;


		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva();

		comandoDaEseguire = factory.costruisciComando(istruzione);

		String messaggio = comandoDaEseguire.esegui(this.partita);
		interfacciaUtente.mostraMessaggio(messaggio);
		if (this.partita.getGiocatore().getCfu()==0) {
			interfacciaUtente.mostraMessaggio("La partita è finita ! Hai perso tutti i CFU :(");
			return false;
		}

		if (this.partita.vinta()) {
			interfacciaUtente.mostraMessaggio("Hai vinto!");
			return false;

		}
		else
			return true;
	}   
	
	public static void main(String[] argc) {
		Diadia gioco = new Diadia();
		gioco.gioca();
	}
}

