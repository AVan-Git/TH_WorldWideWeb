package vn.edu.iuh.fit.week1_demoservlet;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week1_demoservlet.connection.ConnectionDB;
import vn.edu.iuh.fit.week1_demoservlet.models.Account;
import vn.edu.iuh.fit.week1_demoservlet.repositories.AccountRepositories;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

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
           Account acc1 = new Account("02","A van 2","123456"
                   ,"A@gmail.com"
                   ,"0123456789",1);
//            repositories.insert(acc1);
//           System.out.println("ok1");

           Optional<Account> op1 = repositories.getById("02");
           if (op1.isPresent()){
               System.out.println(op1.toString());
           }
           else {
               System.err.println("ok2");
           }

           System.out.println("ok2");

           List<Account> lst =  repositories.getALL();
           for (Account item :
                   lst) {
               System.out.println(item.toString());
           }
           System.out.println("ok3");

           repositories.delete("01");
           System.out.println("ok4");

       }catch (Exception e)
       {
           System.err.println("err");
           System.out.println(e);
       }
        System.out.println("end");
    }
}
