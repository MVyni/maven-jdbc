import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class JDBCPostgresql {
    public static void main(String[] args) {
        try {
        String url = "jdbc:postgresql://localhost:5432/rocket_db";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
        //props.setProperty("ssl", "true");
        Connection conn = DriverManager.getConnection(url, props);

        System.out.println("You're connected.");

        String name = "Carol";
        Integer age = 24;
        String sql = "INSERT INTO public.tab_register (name, age) VALUES(?, ?); ";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, age);
            pst.execute();

            System.out.println("Register inserted successfully");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
