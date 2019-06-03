import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.*;

public class TestPartita {
	
	


	private Partita partita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private Stanza a;
	private Stanza b;
	
	@Before
	public void Setup() {
		this.partita = new Partita();	
		
		this.a= new Stanza("a");
		this.b= new Stanza("b");
		
		this.labirinto = new Labirinto();
		this.labirinto.setStanzaCorrente(a);
		this.labirinto.setStanzaVincente(b);
		
		this.giocatore = new Giocatore();
		this.giocatore.setCfu(20);
		
		this.partita.setLabirinto(labirinto);
		this.partita.setGiocatore(giocatore);
		
		
		
		
	}
	
	
	@Test
	public void TestVinta() {
		assertFalse(this.partita.vinta());
		this.partita.getLabirinto().setStanzaCorrente(b);		//mi sposto nella stanza vincente
		assertTrue(this.partita.vinta());
	}
	
	@Test
	public void TestIsFinita() {
		
		assertFalse(this.partita.isFinita());
		
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	
	
	}
}
