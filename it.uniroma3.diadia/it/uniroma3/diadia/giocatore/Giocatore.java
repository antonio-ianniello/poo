package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

//giocatore gestisce i cfu e memorizza gli attrezzi nella borsa
public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	
	private Borsa borsa;
	private int cfu;
	
	
	public Giocatore() {
		
		this.borsa = new Borsa();		//borsa default 20 kg
		
		this.cfu = CFU_INIZIALI;
	}



	
	
	//getters && setters
	public Borsa getBorsa() {
		return borsa;
	}


	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}


	public int getCfu() {
		return cfu;
	}


	public void setCfu(int cfu) {
		this.cfu = cfu;
	}


	
	

}
