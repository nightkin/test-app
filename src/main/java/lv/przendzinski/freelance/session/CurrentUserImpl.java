package lv.przendzinski.freelance.session;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:kirill.afanasjev@odnoklassniki.ru">Kirill Afanasjev</a>
 */
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
@Component
public class CurrentUserImpl implements CurrentUser {
    private String login;

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }
}
