package jacopodemaio;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo-libreria");


    public static void main(String[] args) {
        
    }
}
