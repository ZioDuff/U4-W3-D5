package jacopodemaio;

import com.github.javafaker.Faker;
import jacopodemaio.dao.OggettoLibreriaDAO;
import jacopodemaio.dao.PrestitoDAO;
import jacopodemaio.dao.UtenteDAO;
import jacopodemaio.entities.OggettoLibreria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.UUID;

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

            System.out.println("------------ PRIMA RICHIESTA -----------------");

//          1 richiesta del compito salvataggio di libri e riviste
//            LIbro libro = new LIbro(faker.book().title(), 1970, 78, faker.book().author(), faker.book().genre());
//            ol.save(libro);
//
//            Rivista rivista = new Rivista(faker.book().title(), 45, 2011, Periodicità.SETTIMANALE);
//            ol.save(rivista);

            System.out.println("------------ SECONDA RICHIESTA -----------------");

//            2 richiesta del compito è quella di cercare un elemento nel catalogo tramite isbn

//            come prima cosa dobbiamo raggiunger quell'elemento con la persistenza

//            siccome nei metodi ho messo come parametro l' uuid invece di string devo convertire il parametro è un easy-fix ma voglio tenerlo cosi perchè è un metodo alternativo :)
            OggettoLibreria foundObj = ol.findById(UUID.fromString("bd1fa028-828d-4672-9f36-f7e0e1b490c4"));
            System.out.println(foundObj);

            System.out.println("------------ TERZA RICHIESTA -----------------");

            List<OggettoLibreria> foundObjByYear = ol.findByYear(30);
            System.out.println(foundObjByYear);


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
//            chiudiamo tutti gli Entity perche è buona prassi
            em.close();
            emf.close();
        }
    }
}
