package it.uniroma3.diadia.giocatore;

import java.util.LinkedList;
import java.util.List;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	private final static int DEFAULT_PESO_MAX_BORSA = 20;
	private List<Attrezzo> attrezzi;
	@SuppressWarnings("unused")
	private int pesoMax;

	public Borsa() {
		this.attrezzi = new LinkedList<>();
		this.pesoMax = DEFAULT_PESO_MAX_BORSA;		//massimo 20 kg
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new LinkedList<>();
	}
	//metodi
	public boolean addAttrezzo(Attrezzo attrezzo) {


		//non posso aggiungere più di 10 elementi nella borsa
		if((this.getPeso() + attrezzo.getPeso()) >DEFAULT_PESO_MAX_BORSA ) {
			return false;
		}
		else {
			this.attrezzi.add(attrezzo);
			return true;
		}

	}

	public boolean removeAttrezzo(String nome) {

	for(Attrezzo a:this.attrezzi) {
		if(a.getNome().equals(nome)) {
			this.attrezzi.remove(a);
			return true;
		}
	}
	return false;
	}


	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String a) {
		boolean trovato = false;
		for(Attrezzo b:this.attrezzi) {
			if(b.getNome().equals(a)){
				trovato = true;
			}
		}

		return trovato;
	}

	public Attrezzo getAttrezzo(String nome) {
		Attrezzo bubu = null;
		for(Attrezzo a:this.attrezzi) {
			if(a.getNome().equals(nome)) {
				bubu = a;
			}
		}
		return bubu;
	}

	//sulla lista di attrezzi
	public int getPeso() {
		int peso=0;
		for(Attrezzo attrezzo:this.attrezzi) {
			peso+=attrezzo.getPeso();
		}

		return peso;
	}



	//getters and setters
	public List<Attrezzo> getAttrezzi() {
		return attrezzi;
	}

	public void setAttrezzi(List<Attrezzo> attrezzi) {
		this.attrezzi = attrezzi;
	}


	public int getPesoMax() {
		return pesoMax;
	}

	public void setPesoMax(int pesoMax) {
		this.pesoMax = pesoMax;
	}

	public String toSTring() {
		StringBuilder s = new StringBuilder();

		if(!this.isEmpty()) {
			s.append("Contenuto Borsa:  pesoAttuale "+this.getPeso()+("kg  pesoSupportato ")+this.getPesoMax()+"kg\n");

			for(Attrezzo a:this.attrezzi) {
				s.append("\n"+ a.toString() + "\n");
			}
		}
		else
			s.append("Borsa vuota");


		return s.toString();
	}




}
