package jacopodemaio.dao;

import jacopodemaio.entities.Utente;
import jacopodemaio.exceptions.NotFoundExceptions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UtenteDAO {

    private EntityManager em;

//    costruttore

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

//    metodi

    public void save(Utente utente) {

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(utente);

        transaction.commit();
        System.out.println("l'utente " + utente.getNome() + " è stato correttamente salvato sul database");
    }

    public Utente findById(UUID utenteId) {
        Utente utente = em.find(Utente.class, utenteId);
        if (utente == null) throw new NotFoundExceptions(utenteId);
        return utente;

    }

    public void foundByIdAndDelete(UUID utenteId) {
        Utente foundedUtente = this.findById(utenteId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(foundedUtente);
        transaction.commit();
        System.out.println("l'utente " + foundedUtente.getNome() + " è stato eliminato con successo dal database");

    }
}
