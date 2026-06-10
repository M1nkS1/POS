package config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    // This class creates the new database connection

//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(
//                Appproperties.DB_URL,
//                Appproperties.DB_USER,
//                Appproperties.DB_PASSWORD
//        );
//    }

    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(Appproperties.DB_URL);
        config.setUsername(Appproperties.DB_USER);
        config.setPassword(Appproperties.DB_PASSWORD);

        config.setMaximumPoolSize(Appproperties.DB_POOL_MAX_SIZE);
        config.setMinimumIdle(Appproperties.DB_POOL_MIN_IDLE);

        dataSource = new HikariDataSource(config);
        System.out.println("Hikari Pool created");
    }

    public static Connection getConnection() throws SQLException {
        System.out.println("Connection returned");
        return dataSource.getConnection();
    }

    public static void closePool(){
        dataSource.close();
    }

    public static void main(String[] args) throws SQLException {

        System.out.println(DatabaseConfig.getConnection());

    }

}
