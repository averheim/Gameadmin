package se.nackademin.custom_exceptions;

/**
 * @author Christopher Olsson on 2017-04-19.
 */
public class SessionUnavailableException extends Exception {
    public SessionUnavailableException(String message) {
        super(message);
    }
}
