import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class TEstBorsa {
	
	private Borsa borsa;
	private Attrezzo a1;
	private Attrezzo a2;
	private Attrezzo a3;
	
	private List<Attrezzo> attrezzi;
	
	
	@Before
	public void SetUp() {
		this.borsa= new Borsa();
		this.a1= new Attrezzo("a1",1);
		this.a2= new Attrezzo("a2",2);
		this.a3= new Attrezzo("a3",3);
		
		this.attrezzi = new LinkedList<>();
		this.attrezzi.add(a1);
		this.attrezzi.add(a2);
		this.attrezzi.add(a3);
	}
	
	
	
	@Test
	public void testAddAttrezzo() {
		this.borsa.setAttrezzi(attrezzi);
		assertEquals(this.attrezzi,this.borsa.getAttrezzi());
		
		
		assertTrue(this.borsa.addAttrezzo(a3));
		assertTrue(this.borsa.addAttrezzo(a3));
		assertTrue(this.borsa.addAttrezzo(a3));
		assertTrue(this.borsa.addAttrezzo(a3));
		assertFalse(this.borsa.addAttrezzo(a3));		//troppo peso 21 kg,il peso default è 20
		
		
	}

}
