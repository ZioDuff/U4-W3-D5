package jacopodemaio.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Utenti")
public class Utente {

    private String nome;

    private String cognome;

    private LocalDate compleanno;

    @Id
    @GeneratedValue
    @Column(name = "id_tessera")
    private UUID idTessera;

//    costruttore

    public Utente() {

    }

    public Utente(String nome, String cognome, LocalDate compleanno) {
        this.nome = nome;
        this.cognome = cognome;
        this.compleanno = compleanno;
    }

//    metodi


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getCompleanno() {
        return compleanno;
    }

    public void setCompleanno(LocalDate compleanno) {
        this.compleanno = compleanno;
    }

    public UUID getIdTessera() {
        return idTessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", compleanno=" + compleanno +
                ", idTessera=" + idTessera +
                '}';
    }
}
