package vn.edu.iuh.fit.week1_demoservlet.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    public Connection connection = null;

    public static String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    public static String URL = "jdbc:mariadb://localhost:3306/mydatabase?createDatabaseIfNotExist=true";
    public static String USER = "root";
    public String PASS = "sapassword";

    public ConnectionDB() throws Exception {
        if (this.connection == null) {
            Class.forName(JDBC_DRIVER);

            this.connection = DriverManager.getConnection(URL, USER, PASS);
        }
    }
}
