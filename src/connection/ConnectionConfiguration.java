package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created with IntelliJ IDEA.
 * User: Branislav
 * Date: 5/19/13
 * Time: 2:07 PM
 */
public class ConnectionConfiguration {

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "be", "be");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}