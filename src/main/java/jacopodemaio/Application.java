package jacopodemaio;

import com.github.javafaker.Faker;
import jacopodemaio.dao.OggettoLibreriaDAO;
import jacopodemaio.dao.PrestitoDAO;
import jacopodemaio.dao.UtenteDAO;
import jacopodemaio.entities.LIbro;
import jacopodemaio.entities.Rivista;
import jacopodemaio.enums.Periodicità;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo-libreria");


    public static void main(String[] args) {

// creiamo qualche libro e rivista utilizzando un pochino di faker ma prima instanziamo l'entity manager
        Faker faker = new Faker();
        EntityManager em = emf.createEntityManager();

        try {
//            instaziamo i dao
            OggettoLibreriaDAO ol = new OggettoLibreriaDAO(em);
            PrestitoDAO pd = new PrestitoDAO(em);
            UtenteDAO ud = new UtenteDAO(em);

//          1 richiesta del compito salvataggio di libri e riviste
            LIbro libro = new LIbro(faker.book().title(), 1970, 78, faker.book().author(), faker.book().genre());
            ol.save(libro);

            Rivista rivista = new Rivista(faker.book().title(), 45, 2011, Periodicità.SETTIMANALE);
            ol.save(rivista);


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
//            chiudiamo tutti gli Entity perche è buona prassi
            em.close();
            emf.close();
        }
    }
}
