package co.edu.unicauca.asae.gestion_horarios;


public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
