package lv.przendzinski.freelance.dto;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */

public class RegisterInfo extends LoginInfo {
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
