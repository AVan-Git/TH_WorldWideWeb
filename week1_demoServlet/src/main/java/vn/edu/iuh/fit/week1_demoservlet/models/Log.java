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
}
