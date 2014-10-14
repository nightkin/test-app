package lv.przendzinski.freelance.domain;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */
public class User {
    private Long id;
    private String name;
    private String role;
    private String password;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String pass, String role) {
        this.setName(name);
        this.setPassword(pass);
        this.setRole(role);
    }

}
