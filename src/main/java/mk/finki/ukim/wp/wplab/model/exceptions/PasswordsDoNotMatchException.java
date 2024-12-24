package mk.finki.ukim.wp.wplab.model.exceptions;

public class PasswordsDoNotMatchException extends Throwable {
    public PasswordsDoNotMatchException() {
        super("Passwords do not match");
    }
}
