package Hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    Connection connection;
    Statement statement;

    public Connect() {
        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "hospital", "hospital");
            statement=connection.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
