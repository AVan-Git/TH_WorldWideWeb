package vn.edu.iuh.fit.week1_demoservlet.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    private static Connection connectionBD = null;

    public static String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    public static String URL = "jdbc:mariadb://localhost:3307/mydatabase?createDatabaseIfNotExist=true";
    public static String USER = "root";
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

    public void setConnectionBD(Connection connectionBD) {
        this.connectionBD = connectionBD;
    }
}
