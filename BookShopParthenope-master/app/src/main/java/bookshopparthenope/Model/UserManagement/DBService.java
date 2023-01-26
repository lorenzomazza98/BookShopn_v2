package bookshopparthenope.Model.UserManagement;

import java.sql.*;
import java.util.Random;

/**
 * classe di utility per implementare l'interazione con il database
 */


public class DBService {

    public static ResultSet logInAdmin(String username, String password) throws ClassNotFoundException, SQLException {
        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/book_shop";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "");
        String query = "SELECT * FROM admin where username='" + username + "'and password ='" + password + "'";

        Statement st = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            return rs;
        } else return null;
    }

    public static ResultSet logInCustomer(String username, String password) throws ClassNotFoundException, SQLException {

        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/book_shop";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "");
        String query = "SELECT * FROM customer where username='" + username + "'and password ='" + password + "'";

        Statement st = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            return rs;
        } else return null;
    }

    public static void insertNewCustomer(Customer cliente) throws ClassNotFoundException, SQLException {
        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/book_shop";
        String apice = "'";
        String virgola = ",";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "");
        String query = "INSERT INTO customer(username,name,surname,email,password) values ( '" +
                cliente.getUsername() + apice + virgola + apice + cliente.getName() + apice + virgola + apice + cliente.getSurname() + apice + virgola + apice + cliente.getEmail() + apice + virgola +
                apice + cliente.getPassword() + apice + ")";
        conn.prepareStatement(query).execute();

    }
}
