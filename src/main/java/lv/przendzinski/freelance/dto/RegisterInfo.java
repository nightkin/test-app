package lv.przendzinski.freelance.dto;

/**
 * Created by denissprzendzinskis on 14/10/14.
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
