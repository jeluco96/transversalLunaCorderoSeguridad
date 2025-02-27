package exceptions;


public class BandaNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 4L;

    public BandaNotFoundException() {
        super("Banda no encontrada.");
    }

    public BandaNotFoundException(String message) {
        super(message);
    }

    public BandaNotFoundException(long id) {
        super("Banda no encontrada con ID: " + id);
    }
}
