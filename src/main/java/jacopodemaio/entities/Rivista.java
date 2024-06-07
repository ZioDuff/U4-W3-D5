package jacopodemaio.entities;

import jacopodemaio.enums.Periodicità;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("Rivista")
public class Rivista extends OggettoLibreria {
    @Enumerated(EnumType.STRING)
    protected Periodicità periodicità;

//    costruttore

    public Rivista() {

    }

    public Rivista(String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

//    metodi


    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    // qui ho cambiato il metodo classico del toString perche non mi piaceva come usciva stampato
    @Override
    public String toString() {
        return "Rivista{" +
                super.toString() +
                ", periodicità=" + periodicità +
                "} ";
    }
}
