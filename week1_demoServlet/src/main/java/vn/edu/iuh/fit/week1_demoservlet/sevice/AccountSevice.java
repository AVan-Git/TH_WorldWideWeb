package vn.edu.iuh.fit.week1_demoservlet.sevice;

import vn.edu.iuh.fit.week1_demoservlet.models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountSevice {

    Optional<Account> getByID(String id) throws Exception;
    List<Account> getAll() throws  Exception;
    void insert (Account account)throws Exception;
    void update(Account account)throws Exception;
    void delete(String id)throws Exception;


}
