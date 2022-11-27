import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	public static Connection getConnection(){
        Connection con=null;
        try {
            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // "C:\mysql-connector-j-8.0.31.jar"

            // Creating a connection
            String url="jdbc:mysql://localhost:3306/manage";
            String username="root";
            String password="Brajesh@2002";
            con=DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
       return con;
    }
}
