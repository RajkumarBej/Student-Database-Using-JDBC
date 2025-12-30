import java.sql.*;

public class DB {
    static Connection con=null;

    public static Connection connect(){
        try{
            String url="jdbc:mysql://localhost:3306/surya";
            String user="root";
            String password="Surya@8260";

            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection(url, user, password);

        }catch(Exception e)
        {
            System.out.println(e);
        }
    return con;
    }
}
