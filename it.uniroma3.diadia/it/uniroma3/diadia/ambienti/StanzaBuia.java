package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	private String attrezzoLuminoso;

	public StanzaBuia(String nome, String attrezzoLuminoso) {
		super(nome);
		this.attrezzoLuminoso = attrezzoLuminoso;
	}
	
	
	@Override
	public String getDescrizione() {
		if(this.luce()) return super.getDescrizione();
		else
			return "qui c' è un buio pesto!!!";
	}
	
	public boolean luce() {
		if(this.hasAttrezzo(this.attrezzoLuminoso)) return true;
		else return false;
	}
}
