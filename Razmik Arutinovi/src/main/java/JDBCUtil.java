import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class JDBCUtil {

    private static final String DB_URL = "jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6584496";
    private static final String DB_USER = "sql6584496";
    private static final String DB_PASSWORD = "VcXiawABSw";
    private static Statement statement;
    private static Connection connection;

    private JDBCUtil() {

    }

    static {

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Statement getStatement() {
        if (statement == null) {
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return statement;
    }

}
