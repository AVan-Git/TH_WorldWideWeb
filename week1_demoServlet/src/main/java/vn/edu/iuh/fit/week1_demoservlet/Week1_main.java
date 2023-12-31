package vn.edu.iuh.fit.week1_demoservlet;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week1_demoservlet.models.Account;
import vn.edu.iuh.fit.week1_demoservlet.models.Log;
import vn.edu.iuh.fit.week1_demoservlet.models.Role;
import vn.edu.iuh.fit.week1_demoservlet.repositories.LogRepositories;
import vn.edu.iuh.fit.week1_demoservlet.repositories.RoleRepositories;
import vn.edu.iuh.fit.week1_demoservlet.sevice.impl.AccountSeviceImpl;

import java.sql.Date;
import java.util.List;

public class Week1_main {

    public static void main(String[] args) {
        System.out.println("Start");

        LogRepositories repositories = new LogRepositories();
        Date day = new Date(2023-1900,9,12);
//        System.out.println(day);

        Log log1 = new Log(1,"02",day,day,"Note 1" );
        Log log2 = new Log(2,"02",day,day,"" );
        Log log3 = new Log(3,"02",day,day,"" );

        try {
//            repositories.insert(log1);
//            repositories.update(log1);
//            repositories.delete(1);
            System.out.println(repositories.getById(2));


            for (Log item :
                    repositories.getAll()) {
                System.out.println("item: " + item);
            }

        }catch (Exception e){
            System.err.println(e);
            System.err.println("Main");
        }


        //Role
//        RoleRepositories repositories = new RoleRepositories();
//
//        Role role1 = new Role("01", "Role 1", "description 1", 0);
//        Role role2 = new Role("04", "Role 2", "description 2", -1);
//        Role role3 = new Role("03", "Role 3", "description 3", 1);
//
//        try {
////            repositories.delete("02");
//            repositories.insert(role2);
//
//            List<Role> lst = repositories.getAll();
//
//            for (Role item :
//                    lst) {
//                System.out.println(item);
//
//            }
////            System.out.println(repositories.getById("03"));
//
//        }
//        catch (Exception e)
//        {
//            System.err.println(e);
//            System.err.println("Main");
//        }


// Account
//public Account(String account_id, String full_name, String password, String email, String phone, int status) {
//            this.account_id = account_id;
//            this.full_name = full_name;
//            this.password = password;
//            this.email = email;
//            this.phone = phone;
//            this.status = status;
//        }


//        AccountSeviceImpl sevice = new AccountSeviceImpl();
//        try {
//            List<Account> lst =  sevice.getAll();
//            for (Account item :
//                    lst) {
//                System.out.println(item.toString());
//            }
//            System.out.println("ok3");
//        }catch (Exception e)
//        {
//            System.out.println(e);
//        }

        System.out.println("END");

    }




}
