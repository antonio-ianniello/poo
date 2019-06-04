package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatoreAttrezziPerPeso implements Comparator<Attrezzo>{
	public int compare(Attrezzo a1,Attrezzo a2) {
		Integer pesoA1 = a1.getPeso();
		Integer pesoA2 = a2.getPeso();
		
		if(pesoA1!=pesoA2) return pesoA1.compareTo(pesoA2);		//falso
		else return a1.getNome().compareTo(a2.getNome());
	}
}
