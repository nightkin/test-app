package lv.przendzinski.freelance.session;

/**
 * @author <a href="mailto:kirill.afanasjev@odnoklassniki.ru">Kirill Afanasjev</a>
 */
public interface CurrentUser {
    String getLogin();

    void setLogin(String login);
}
