package vn.edu.iuh.fit.week1_demoservlet.sevice.impl;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week1_demoservlet.models.Account;
import vn.edu.iuh.fit.week1_demoservlet.repositories.AccountRepositories;
import vn.edu.iuh.fit.week1_demoservlet.sevice.AccountSevice;

import java.util.List;
import java.util.Optional;

public class AccountSeviceImpl implements AccountSevice {


    private AccountRepositories repositories = new AccountRepositories();

    @Override
    public Optional<Account> getByID(String id) throws Exception {
        return repositories.getById(id);
    }

    @Override
    public List<Account> getAll() throws Exception {
        return repositories.getALL();
    }

    @Override
    public void insert(Account account) throws Exception {
        repositories.insert(account);
    }

    @Override
    public void update(Account account) throws Exception {
        repositories.update(account);
    }

    @Override
    public void delete(String id) throws Exception {
        repositories.delete(id);
    }
}
