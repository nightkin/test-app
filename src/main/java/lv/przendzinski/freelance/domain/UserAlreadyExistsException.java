package lv.przendzinski.freelance.domain;

/**
 * Created by denissprzendzinskis on 05/11/14.
 */

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}