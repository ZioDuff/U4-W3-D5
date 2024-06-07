package jacopodemaio.dao;

import jacopodemaio.entities.Prestito;
import jacopodemaio.exceptions.NotFoundExceptions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PrestitoDAO {

    private EntityManager em;

//    costruttore

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

//    metodi

    public void save(Prestito prestito) {

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(prestito);

        transaction.commit();
        System.out.println("il prestito di " + prestito.getUtente() + " è stato correttamente salvato sul database");
    }

    public Prestito findById(UUID prestitoId) {
        Prestito prestito = em.find(Prestito.class, prestitoId);
        if (prestito == null) throw new NotFoundExceptions(prestitoId);
        return prestito;

    }

    public void foundByIdAndDelete(UUID prestitoId) {
        Prestito foundedPrestito = this.findById(prestitoId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(foundedPrestito);
        transaction.commit();
        System.out.println("il prestito di " + foundedPrestito.getUtente() + " è stato eliminato con successo dal database");

    }
}
