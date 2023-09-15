package vn.edu.iuh.fit.week1_demoservlet.models;

import java.sql.Date;

//account đăng nhập, ngày giờ  đăng
//nhập, ngày giờ đăng xuất, ghi chú.
public class Log {
    private int id ;
    private String account_id;
    private Date ngayLogin;
    private Date ngayLogout;
    private String note;

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", account_id='" + account_id + '\'' +
                ", ngayLogin=" + ngayLogin +
                ", ngayLogout=" + ngayLogout +
                ", note='" + note + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public Date getNgayLogin() {
        return ngayLogin;
    }

    public void setNgayLogin(Date ngayLogin) {
        this.ngayLogin = ngayLogin;
    }

    public Date getNgayLogout() {
        return ngayLogout;
    }

    public void setNgayLogout(Date ngayLogout) {
        this.ngayLogout = ngayLogout;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Log(int id, String account_id, Date ngayLogin, Date ngayLogout, String note) {
        this.id = id;
        this.account_id = account_id;
        this.ngayLogin = ngayLogin;
        this.ngayLogout = ngayLogout;
        this.note = note;
    }

    public Log(int id) {
        this.id = id;
    }

    public Log() {
    }
}
