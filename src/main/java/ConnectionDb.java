import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionDb {
    private static Connection connection;
    public static void connect (){
        try {
            if(connection == null) {
                String url = "jdbc:postgresql://localhost:5432/rocket_db";
                Properties props = new Properties();
                props.setProperty("user", "postgres");
                props.setProperty("password", "postgres");
                connection = DriverManager.getConnection(url, props);

                System.out.println("You're connected.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
