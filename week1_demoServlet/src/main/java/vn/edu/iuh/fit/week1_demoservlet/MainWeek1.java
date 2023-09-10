package vn.edu.iuh.fit.week1_demoservlet;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week1_demoservlet.connection.ConnectionDB;
import vn.edu.iuh.fit.week1_demoservlet.models.Account;
import vn.edu.iuh.fit.week1_demoservlet.repositories.AccountRepositories;

import java.sql.Connection;

public class MainWeek1 {
    public static void main(String[] args) {
        System.out.println("Start");
//public Account(String account_id, String full_name, String password, String email, String phone, int status) {
//            this.account_id = account_id;
//            this.full_name = full_name;
//            this.password = password;
//            this.email = email;
//            this.phone = phone;
//            this.status = status;
//        }
       try {
//            Connection z = new ConnectionDB().getConnectionBD();
           AccountRepositories repositories = new AccountRepositories();
           Account acc1 = new Account("01","A van","123456","A@gmail.com"
                   ,"0123456789",0);
           repositories.insert(acc1);

           System.out.println("ok");

       }catch (Exception e)
       {
           System.err.println("err");
           System.out.println(e);
       }
        System.out.println("end");
    }
}
