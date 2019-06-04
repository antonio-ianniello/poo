package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {
	final static private int SOGLIA_MAGICA_DEFAULT=3;
	private int sogliaMagica;
	private int contatoreAttrezziPosati;
	
	
	public StanzaMagica(String nome) {
		super(nome);
		this.sogliaMagica = SOGLIA_MAGICA_DEFAULT;
		this.contatoreAttrezziPosati = 0;
	}
	
	
	
	
	public StanzaMagica(String nome,int sogliaMagica) {
		super(nome);
		this.sogliaMagica = sogliaMagica;
		this.contatoreAttrezziPosati = 0;
		
	}
	
	//inverte la lista di attrezzi e raddoppia il peso dell' attrezzo	
	public Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		
	StringBuilder stringBuilder = new StringBuilder(attrezzo.getNome());
	stringBuilder = stringBuilder.reverse();
	int nuovoPeso = attrezzo.getPeso()*2;
	return new Attrezzo(stringBuilder.toString(),nuovoPeso);
	}
	
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if(this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo = modificaAttrezzo(attrezzo);
		return super.addAttrezzo(attrezzo);
	}
	
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.getNome());
		risultato.append("\nUscite: ");
		for(String direzione:this.getDirezioni()) {
			if(direzione!=null)
				risultato.append(" "+ direzione);
		}
		risultato.append("\nAttrezzi nella stanza: ");
		for(Attrezzo attrezzo:this.getAttrezzi()) {
			if(attrezzo==null) break;
			risultato.append(attrezzo.toString());
		}
		return risultato.toString()+"\nAttenzione questa è una stanza Magica,attento"
				+ " a non posare troppi attrezzi.\n";
	}
	
	
	
}
