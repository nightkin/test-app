package lv.przendzinski.freelance.session;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */

public interface CurrentUser {
    String getLogin();
    Long getId();

    void setLogin(String login);
    void setId(Long id);
}
