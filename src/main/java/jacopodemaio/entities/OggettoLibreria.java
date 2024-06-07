package jacopodemaio.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Libreria")
public abstract class OggettoLibreria {
    @Id
    @GeneratedValue
    private UUID isbn;

    private String titolo;
    @Column(name = "anno_di_pubblicazione")
    private int annoPubblicazione;
    @Column(name = "numero_pagine")
    private int numeroPagine;


    //    costruttore
    public OggettoLibreria() {

    }

    public OggettoLibreria(String titolo, int annoPubblicazione, int numeroPagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

//    metodi


    public UUID getIsbn() {
        return isbn;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    // qui ho cambiato il metodo classico del toString perche non mi piaceva come usciva stampato
    @Override
    public String toString() {
        return
                "isbn=" + isbn +
                        ", titolo='" + titolo + '\'' +
                        ", annoPubblicazione=" + annoPubblicazione +
                        ", numeroPagine=" + numeroPagine
                ;
    }
}
