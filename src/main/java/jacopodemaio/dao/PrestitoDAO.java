package jacopodemaio.dao;

import jacopodemaio.entities.Prestito;
import jacopodemaio.exceptions.NotFoundExceptions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
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

    public List<Prestito> expiredLoan(LocalDate date) {
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzione < :date AND p.dataEffettivaDiRestituzione IS NULL", Prestito.class);
        query.setParameter("date", date);
        return query.getResultList();
    }


}
