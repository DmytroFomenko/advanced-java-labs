package fdv.dbconnect;


import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {

    private static Connection con;

    public static Connection getConnection() {
        return con;
    }

    public static void DBConection() throws SQLException,
            ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {

        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

        String url = "jdbc:mysql://localhost";
        String databaseName = "fdv_smartphones";
        String options = "";
        String username = "root";
        String password = "root";
        String connectLink = url + "/" + databaseName + options;

        con = DriverManager.getConnection(connectLink, username, password);
        System.out.println("The database for work has been successfully connected!");
    }

    public static void DBClose() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}


