package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa extends AbstractComando {


	@Override
    public String esegui(Partita partita) {
        String s;
        Borsa borsa = partita.getGiocatore().getBorsa();
        Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
        if (borsa.hasAttrezzo(getParametro())) {
            Attrezzo attrezzo = borsa.getAttrezzo(getParametro());
            if (stanzaCorrente.addAttrezzo(attrezzo)) {
                borsa.removeAttrezzo(getParametro());
                s = "Hai posato " + attrezzo.toString();
            } else {
                s = "Ci sono troppi oggetti nella stanza!";
            }
        } else {
            s = "Attrezzo non presente nella borsa";
        }
        return s;
    }
}