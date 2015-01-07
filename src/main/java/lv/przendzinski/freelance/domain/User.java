package lv.przendzinski.freelance.domain;

import java.io.Serializable;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */

public class User implements Serializable {
    private long id;
    private String name;
    private String password;
    private int role;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRole(int role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(long id, String name, String pass, int role) {
        this.setId(id);
        this.setName(name);
        this.setPassword(pass);
        this.setRole(role);
    }

}
