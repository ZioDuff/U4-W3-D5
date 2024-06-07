package jacopodemaio.dao;

import jacopodemaio.entities.OggettoLibreria;
import jacopodemaio.exceptions.NotFoundExceptions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class OggettoLibreriaDAO {

    private EntityManager em;

//    costruttore

    public OggettoLibreriaDAO(EntityManager em) {
        this.em = em;
    }

//    metodi

    public void save(OggettoLibreria oggetto) {

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(oggetto);

        transaction.commit();
        System.out.println("l'oggetto " + oggetto.getTitolo() + " è stato correttamente salvato sul database");
    }

    public OggettoLibreria findById(UUID oggettoId) {
        OggettoLibreria oggetto = em.find(OggettoLibreria.class, oggettoId);
        if (oggetto == null) throw new NotFoundExceptions(oggettoId);
        return oggetto;

    }

    public void foundByIdAndDelete(UUID oggettoId) {
        OggettoLibreria foundedOggetto = this.findById(oggettoId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(foundedOggetto);
        transaction.commit();
        System.out.println("l'oggetto " + foundedOggetto.getTitolo() + " è stato eliminato con successo dal database");

    }


}

