package it.uniroma3.diadia.ambienti;


//fatto
public class StanzaBloccata extends Stanza {

	private String DirezioneBloccata;
	private String AttrezzoDiApertura;
	
	
	//costruttore
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoDiApertura) {
		super(nome);
		DirezioneBloccata = direzioneBloccata;
		AttrezzoDiApertura = attrezzoDiApertura;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		//se ho la chiave la stanza si sblocca
		if(!(this.hasAttrezzo(this.AttrezzoDiApertura)) && direzione.equals(DirezioneBloccata)) {
			return super.getStanzaAdiacente(null);
		}
		else
			return super.getStanzaAdiacente(direzione);		//se ho la chiave e direzione sbloccata
	}
	
	@Override
	   public String getDescrizione() {
       if(this.sblocco()) return "La porta si è aperta!\n"+super.getDescrizione();
       else
    	   return "La porta "+ this.DirezioneBloccata + " è chiusa a chiave!\n"+super.getDescrizione();
    }
	
	public boolean sblocco() {
		if(super.hasAttrezzo(this.AttrezzoDiApertura)) return true;
		return false;
	}
	
	
	
}
