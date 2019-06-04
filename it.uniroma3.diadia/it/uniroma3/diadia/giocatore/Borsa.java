package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerNome;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class Borsa {
	private final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	
	private int pesoMax;

	public Borsa() {
		this.attrezzi = new ArrayList<>();
		this.pesoMax = DEFAULT_PESO_MAX_BORSA;		//massimo 20 kg
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>();
	}
	//metodi
	public boolean addAttrezzo(Attrezzo attrezzo) {


		//non posso aggiungere più di 10 elementi nella borsa
		if((this.getPeso() + attrezzo.getPeso()) >this.getPesoMax() ) {
			return false;
		}
		else {
			attrezzi.add(attrezzo);
			return true;
		}

	}

	public Attrezzo removeAttrezzo(String nome) {

	for(Attrezzo a:this.attrezzi) {
		if(a.getNome().equals(nome)) {
			this.attrezzi.remove(a);
			return a;
		}
	}
	return null;
	}


	public boolean isEmpty() {
		return attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String a) {
		return this.getAttrezzo(a) != null;
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

	public int getNumeroAttrezziNellaBorsa(){
			int cont =0;
			for(Attrezzo a:this.attrezzi) 
				cont++;
			
			return cont;
	}





	public int getPesoMax() {
		return pesoMax;
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
	
	//comparatore interno
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> ordinatiPerPeso;
		ordinatiPerPeso = new ArrayList<Attrezzo>();
		ordinatiPerPeso = attrezzi;
		ordinatiPerPeso.sort(null);
		return ordinatiPerPeso;
	}
	
	//comparatore esterno
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		ComparatoreAttrezziPerNome cmp= new ComparatoreAttrezziPerNome();
		SortedSet<Attrezzo> ordinatiPerNome = new TreeSet<Attrezzo>(cmp);
		ordinatiPerNome.addAll(attrezzi);
		
		return ordinatiPerNome;
	}

	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		ComparatoreAttrezziPerPeso cmp= new ComparatoreAttrezziPerPeso();
		SortedSet<Attrezzo> ordinatiPerPeso = new TreeSet<Attrezzo>(cmp);
		ordinatiPerPeso.addAll(attrezzi);
		
		return ordinatiPerPeso;
	}

}
