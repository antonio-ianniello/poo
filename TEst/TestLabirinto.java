import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class TestLabirinto {
	
	private Labirinto labirinto;
	private Stanza a;
	private Stanza b;
	
	
	
	@Before
	public void SetUp() {
		this.labirinto = new Labirinto();
		this.a= new Stanza("a");
		this.b= new Stanza("b");
		labirinto.setStanzaCorrente(a);
		labirinto.setStanzaVincente(b);
	}

	@Test
	public void TestSTanzaCorrente() {
		assertEquals(a,this.labirinto.getStanzaCorrente());
	}
	
	
	@Test
	public void TestSTanzaVincente() {
		assertEquals(b,this.labirinto.getStanzaVincente());
	}

}
