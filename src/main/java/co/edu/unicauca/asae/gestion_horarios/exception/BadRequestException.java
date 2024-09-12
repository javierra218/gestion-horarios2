package co.edu.unicauca.asae.gestion_horarios.exception;


public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
