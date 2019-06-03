import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class TestGiocatore {

	private Giocatore giocatore;
	private Borsa  borsa;
	
	private Attrezzo a1;
	private Attrezzo a2;
	private Attrezzo a3;
	
	
	@Before
	public void SetUp() {
		this.a1= new Attrezzo("a1",1);
		this.a2= new Attrezzo("a2",2);
		this.a3= new Attrezzo("a3",3);
		
		this.giocatore = new Giocatore();
		
		this.borsa = new Borsa();
		
		
		this.giocatore.setBorsa(borsa);
	}
	
	
	
	@Test
	public void TEstdiminuiscicfu() {
		this.giocatore.setCfu(10);
		
		assertEquals(10,this.giocatore.getCfu());
		assertFalse(this.giocatore.getCfu()==15);
		
		this.giocatore.diminuisciCfu();
		assertEquals(9,this.giocatore.getCfu());
		
	}

	
	@Test
	public void TestAggiungiInBorsa() {
		this.borsa.addAttrezzo(a1);
		this.borsa.addAttrezzo(a2);
		this.borsa.addAttrezzo(a3);
		
		assertEquals(a1,this.borsa.getAttrezzi().get(0));
		assertEquals(a2,this.borsa.getAttrezzi().get(1));
		assertEquals(a3,this.borsa.getAttrezzi().get(2));
	}
}
