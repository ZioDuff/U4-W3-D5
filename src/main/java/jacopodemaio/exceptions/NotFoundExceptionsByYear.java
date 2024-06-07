package jacopodemaio.exceptions;

public class NotFoundExceptionsByYear extends RuntimeException {
    public NotFoundExceptionsByYear(int year) {
        super("L'oggetto con anno " + year + " non è stato trovato");
    }
}
