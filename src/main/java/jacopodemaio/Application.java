package jacopodemaio;

import com.github.javafaker.Faker;
import jacopodemaio.dao.OggettoLibreriaDAO;
import jacopodemaio.dao.PrestitoDAO;
import jacopodemaio.dao.UtenteDAO;
import jacopodemaio.entities.LIbro;
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
//            LIbro libro = new LIbro(faker.book().title(), 1986, 400, faker.book().author(), faker.book().genre());
//            ol.save(libro);
//
//            Rivista rivista = new Rivista(faker.book().title(), 2024, 76, Periodicità.SETTIMANALE);
//            ol.save(rivista);

//            Utente utente = new Utente(faker.funnyName().name(), faker.pokemon().name(), LocalDate.of(2000, 4, 30));
//            ud.save(utente);

//            Utente utenteDalDb = ud.findById(UUID.fromString("9ce3a2c1-bb3b-4dba-b726-aaf0aeb741d9"));
//            OggettoLibreria oggettoDalDb = ol.findById(UUID.fromString("e936d36a-8859-4755-a4c7-f78c227b7312"));
//            Prestito prestito = new Prestito(utenteDalDb, oggettoDalDb, LocalDate.now(), LocalDate.now().plusDays(30), null);
//            pd.save(prestito);

            System.out.println("------------ SECONDA RICHIESTA -----------------");

//            qua ho eliminato 4 oggetti, ho approfittato della richiesta del compito perche avevo invertito le pagine con l'anno di pubblicazione :/

//            ol.foundByIdAndDelete(UUID.fromString("bd1fa028-828d-4672-9f36-f7e0e1b490c4"));
//            ol.foundByIdAndDelete(UUID.fromString("c54a5730-02c4-40a2-bf13-bfa8ebfaaab4"));
//            ol.foundByIdAndDelete(UUID.fromString("6cfa3aad-2996-42ee-9b4b-2dbb8e874d92"));
//            ol.foundByIdAndDelete(UUID.fromString("3b0e770e-5d35-40cd-907e-9948c36b1c4e"));


            System.out.println("------------ TERZA RICHIESTA -----------------");

//            2 richiesta del compito è quella di cercare un elemento nel catalogo tramite isbn

//            come prima cosa dobbiamo raggiunger quell'elemento con la persistenza

//            siccome nei metodi ho messo come parametro l' uuid invece di string devo convertire il parametro è un easy-fix ma voglio tenerlo cosi perchè è un metodo alternativo :)
            OggettoLibreria foundObj = ol.findById(UUID.fromString("37a3a6e3-188d-4a7e-bfad-ba49f77f0564"));
            System.out.println(foundObj);

            System.out.println("------------ QUARTA RICHIESTA -----------------");

//            qui andiamo a richiamare il metodo per trova i libri o riviste in quel dato anno
//            faccio ritornare una lista perchè potrebbero esserci piu elementi in quell'anno

            List<OggettoLibreria> foundObjByYear = ol.findByYear(1986);
            System.out.println(foundObjByYear);

            System.out.println("---------------- QUINTA RICHIESTA -------------------");

            List<LIbro> foundByAuthor = ol.findByAuthor("Blair Reichel");
            foundByAuthor.forEach(System.out::println);

            System.out.println("--------------- SESTA RICHIESTA -------------------------");

            List<OggettoLibreria> foundbyPartialTitle = ol.findByPartialTitle("th");
            foundbyPartialTitle.forEach(System.out::println);

            System.out.println("--------------- SETTIMA RICHEISTA-----------------------");


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
//            chiudiamo tutti gli Entity perche è buona prassi
            em.close();
            emf.close();
        }
    }
}
