import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnector{
    // this is to establish the connection
    private static final String URL = "jdbc:mysql://localhost:3306/contact_directory";
    private static final String USER = "tmunyai";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // make that coonection open
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            throw new SQLException("the driver is not found");

        }
    }
}