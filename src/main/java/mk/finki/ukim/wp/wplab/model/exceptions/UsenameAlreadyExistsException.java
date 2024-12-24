package mk.finki.ukim.wp.wplab.model.exceptions;

public class UsenameAlreadyExistsException extends Throwable {
    public UsenameAlreadyExistsException(String username) {
        super("Usename " + username + " already exists");
    }
}
