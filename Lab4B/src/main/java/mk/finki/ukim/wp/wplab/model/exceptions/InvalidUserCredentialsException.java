package mk.finki.ukim.wp.wplab.model.exceptions;

public class InvalidUserCredentialsException extends Throwable {
    public InvalidUserCredentialsException() {
        super("Invalid user credentials");
    }
}
