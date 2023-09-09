package vn.edu.iuh.fit.week1_demoservlet.models;
// account_id, role_id, is_grant, note
public class GrantAccess {

    private String account_id;
    private String role_id;
    private String is_grant;//  0-diasable, 1-enable
    private String note;

    @Override
    public String toString() {
        return "GrantAccess{" +
                "account_id='" + account_id + '\'' +
                ", role_id='" + role_id + '\'' +
                ", is_grant='" + is_grant + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getIs_grant() {
        return is_grant;
    }

    public void setIs_grant(String is_grant) {
        this.is_grant = is_grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public GrantAccess(String account_id, String role_id, String is_grant, String note) {
        this.account_id = account_id;
        this.role_id = role_id;
        this.is_grant = is_grant;
        this.note = note;
    }

    public GrantAccess() {
    }
}
