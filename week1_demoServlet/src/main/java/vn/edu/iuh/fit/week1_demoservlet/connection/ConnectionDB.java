package vn.edu.iuh.fit.week1_demoservlet.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    private static Connection connectionBD = null;

    public String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    public String URL = "jdbc:mariadb://localhost:3306/mydatabase?createDatabaseIfNotExist=true";
    public String USER = "root";
    public String PASS = "sapassword";

    public ConnectionDB() throws Exception {
        if (this.connectionBD == null) {
            Class.forName(JDBC_DRIVER);

            this.connectionBD = DriverManager.getConnection(URL, USER, PASS);
        }
    }

    public static final Connection getConnectionBD() {
        return connectionBD;
    }

}
