package jacopodemaio.exceptions;

import java.util.UUID;

public class NotFoundExceptions extends RuntimeException {
    public NotFoundExceptions(UUID id) {
        super("L'oggetto con id " + id + " non è stato trovato");
    }
}
