package jacopodemaio.dao;

import jacopodemaio.entities.OggettoLibreria;
import jacopodemaio.exceptions.NotFoundExceptions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;
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

    public List<OggettoLibreria> findByYear(int year) {
//        ogni transizione deve essere instanziata e poi iniziata
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
// qui anidamo a creare la nostra query per poter trovare l'anno
        Query queryByYear = em.createQuery("SELECT o FROM OggettoLibreria o WHERE o.annoPubblicazione = :year");
// settiamo il nostro parametro
        queryByYear.setParameter("year", year);
// qui facciamo il commit della nostra transizione
        transaction.commit();

        return queryByYear.getResultList();

    }


}

