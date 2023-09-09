package vn.edu.iuh.fit.week1_demoservlet.repositories;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week1_demoservlet.connection.ConnectionDB;
import vn.edu.iuh.fit.week1_demoservlet.models.Account;

public class AccountRepositories {
    @Inject
    private ConnectionDB connectionDB;

    public void insert(Account account) throws Exception{

    }


}
