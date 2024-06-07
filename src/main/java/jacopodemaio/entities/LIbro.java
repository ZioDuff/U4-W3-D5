package jacopodemaio.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Libro")
public class LIbro extends OggettoLibreria {
    protected String autore;

    protected String genere;

//    costruttore

    public LIbro() {

    }


    public LIbro(String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

//    metodi

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    // qui ho cambiato il metodo classico del toString perche non mi piaceva come usciva stampato
    @Override
    public String toString() {
        return "LIbro{" +
                super.toString() +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                "} ";
    }
}
