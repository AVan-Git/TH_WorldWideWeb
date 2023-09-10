package vn.edu.iuh.fit.week1_demoservlet;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week1_demoservlet.models.Account;
import vn.edu.iuh.fit.week1_demoservlet.sevice.impl.AccountSeviceImpl;

import java.util.List;

public class Week1_main {

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


        AccountSeviceImpl sevice = new AccountSeviceImpl();
        try {
            List<Account> lst =  sevice.getAll();
            for (Account item :
                    lst) {
                System.out.println(item.toString());
            }
            System.out.println("ok3");
        }catch (Exception e)
        {
            System.out.println(e);
        }


    }




}
