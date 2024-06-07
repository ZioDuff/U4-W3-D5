package jacopodemaio.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Prestiti")
public class Prestito {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_tessera_utente")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "id_oggetto_in_prestito")
    private OggettoLibreria catalogo;

    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;

    @Column(name = "data_restituzione")
    private LocalDate dataRestituzione;

    @Column(name = "data_effettiva_restituzione", nullable = false)
    private LocalDate dataEffettivaDiRestituzione;

//    costruttore

    public Prestito() {

    }

    public Prestito(Utente utente, OggettoLibreria catalogo, LocalDate dataInizioPrestito, LocalDate dataRestituzione, LocalDate dataEffettivaDiRestituzione) {
        this.utente = utente;
        this.catalogo = catalogo;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzione = dataRestituzione;
        this.dataEffettivaDiRestituzione = dataEffettivaDiRestituzione;
    }

//    metodi


    public UUID getId() {
        return id;
    }


    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public OggettoLibreria getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(OggettoLibreria catalogo) {
        this.catalogo = catalogo;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }

    public void setDataRestituzione(LocalDate dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }

    public LocalDate getDataEffettivaDiRestituzione() {
        return dataEffettivaDiRestituzione;
    }

    public void setDataEffettivaDiRestituzione(LocalDate dataEffettivaDiRestituzione) {
        this.dataEffettivaDiRestituzione = dataEffettivaDiRestituzione;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", catalogo=" + catalogo +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzione=" + dataRestituzione +
                ", dataEffettivaDiRestituzione=" + dataEffettivaDiRestituzione +
                '}';
    }
}
