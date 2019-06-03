package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	public Labirinto() {
		this.creaLabirinto();
	}

	/**
     * Crea tutte le stanze e le porte di collegamento
     */
    private void creaLabirinto() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		
		//aggiunti
		Attrezzo tazzina = new Attrezzo("tazzina",1);
		Attrezzo piatto = new Attrezzo("piatto",1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		//aggiunti
		Stanza mensa = new Stanza("Mensa");
		Stanza bar = new Stanza("Bar");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		
		//aggiunti
		bar.impostaStanzaAdiacente("nord", mensa);
		mensa.impostaStanzaAdiacente("sud", bar);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		
		//aggiunti
		bar.addAttrezzo(tazzina);
		mensa.addAttrezzo(piatto);
	
		// il gioco comincia nell'atrio
        stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
    }
    
    
    
//getters && setters
 	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public Stanza getStanzaVincente() {
 		return stanzaVincente;
 	}

 	public void setStanzaCorrente(Stanza stanzaCorrente) {
 		this.stanzaCorrente = stanzaCorrente;
 	}

 	public Stanza getStanzaCorrente() {
 		return this.stanzaCorrente;
 	}
 	
}
