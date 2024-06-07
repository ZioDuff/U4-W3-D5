package jacopodemaio.dao;

import jacopodemaio.entities.LIbro;
import jacopodemaio.entities.OggettoLibreria;
import jacopodemaio.exceptions.NotFoundExceptions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

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
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<OggettoLibreria> queryByYear = em.createQuery("SELECT o FROM OggettoLibreria o WHERE o.annoPubblicazione = :year", OggettoLibreria.class);
        return queryByYear.getResultList();
    }

    public List<LIbro> findByAuthor(String author) {

        TypedQuery<LIbro> queryByAuthor = em.createQuery("SELECt o FROM LIbro o WHERE o.autore = :author", LIbro.class);

        queryByAuthor.setParameter("author", author);


        return queryByAuthor.getResultList();
    }

    public List<OggettoLibreria> findByPartialTitle(String titolo) {

        TypedQuery<OggettoLibreria> queryByTitle = em.createNamedQuery("findByPartialTitle", OggettoLibreria.class);

        queryByTitle.setParameter("titolo", titolo + "%");

        return queryByTitle.getResultList();


    }

}

