package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;


//fatto
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
		Attrezzo pane = new Attrezzo("pane",5);
		Attrezzo scudo = new Attrezzo("scudo",10);
		Attrezzo chiave = new Attrezzo ("chiave",1);
		Attrezzo carta = new Attrezzo ("carta", 2);
		Attrezzo computer = new Attrezzo ("computer", 14);
		Attrezzo libro1 = new Attrezzo("libro1",2);
		Attrezzo libro2 = new Attrezzo("libro2",1);
		
	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		StanzaBuia bagno = new StanzaBuia("Bagno", "lanterna");
		StanzaMagica adisu = new StanzaMagica("Adisu", 2);
		StanzaBloccata rettorato = new StanzaBloccata("Rettorato","nord","chiave");
		

		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN11.impostaStanzaAdiacente("sud", adisu);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN10.impostaStanzaAdiacente("sud", bagno);
		bagno.impostaStanzaAdiacente("nord", aulaN10);
		bagno.impostaStanzaAdiacente("est", adisu);
		adisu.impostaStanzaAdiacente("ovest", bagno);
		adisu.impostaStanzaAdiacente("est", rettorato);

		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		rettorato.impostaStanzaAdiacente("nord", biblioteca);
		rettorato.impostaStanzaAdiacente("ovest", bagno);
		
	
        /* pone gli attrezzi nelle stanze */
		laboratorio.addAttrezzo(lanterna);
		aulaN10.addAttrezzo(pane);
		aulaN11.addAttrezzo(scudo);
		bagno.addAttrezzo(carta);
		aulaN11.addAttrezzo(chiave);
		aulaN11.addAttrezzo(computer);
		adisu.addAttrezzo(libro1);
		adisu.addAttrezzo(libro2);
		rettorato.addAttrezzo(libro1);
		rettorato.addAttrezzo(libro2);
		rettorato.addAttrezzo(computer);
		rettorato.addAttrezzo(osso);
		
		
	
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
