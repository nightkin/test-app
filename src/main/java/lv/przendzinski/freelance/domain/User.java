package lv.przendzinski.freelance.domain;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */
public class User {
    private Long id;
    private String name;
    private String password;
    private Integer role;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRole(Integer role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Long id, String name, String pass, Integer role) {
        this.setId(id);
        this.setName(name);
        this.setPassword(pass);
        this.setRole(role);
    }

}
