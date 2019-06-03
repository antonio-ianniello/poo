import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanza {

	private Stanza Bubu;
	private Stanza Ciccio;
	private Stanza Bra;
	private Stanza Franco;
	private Attrezzo osso;
	private Attrezzo ascia;
	private Attrezzo lancia;
	@Before 

	public void Setup() {
		this.Bubu= new Stanza ("Bubu");
		this.Bra= new Stanza ("Bra");
		this.Ciccio= new Stanza ("Ciccio");
		this.Franco= new Stanza ("Franco");
		this.osso= new Attrezzo("osso", 5);
		this.ascia=new Attrezzo("ascia", 8);
		this.lancia = new Attrezzo("lancia", 3);


	}





	@Test
	public void TestgetStanzaAdiacente() {
		this.Bubu.impostaStanzaAdiacente("nord", Ciccio);
		this.Bra.impostaStanzaAdiacente("est",Bubu);
		assertEquals(Ciccio, this.Bubu.getStanzaAdiacente("nord"));
		assertEquals(Bubu, this.Bra.getStanzaAdiacente("est"));
		assertEquals(null,this.Bubu.getStanzaAdiacente("sud"));
	}

	@Test
	public void TestRemoveAttrezzo() {
		this.Bubu.addAttrezzo(osso);
		this.Bra.addAttrezzo(lancia);
		this.Franco.addAttrezzo(ascia);

		assertTrue(this.Bubu.removeAttrezzo(osso));
		assertEquals(true,this.Bra.removeAttrezzo(lancia));
		assertFalse(this.Franco.removeAttrezzo(osso));


	}

	@Test
	public void TestHasAttrezzo() {
		this.Bubu.addAttrezzo(ascia);
		this.Franco.addAttrezzo(osso);
		assertFalse(this.Bubu.hasAttrezzo("introvabile"));
		assertTrue(this.Bubu.hasAttrezzo("ascia"));
		assertFalse(this.Franco.hasAttrezzo("ascia"));
	}

	


}
