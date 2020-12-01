package connection;

import java.sql.*;

public class MSSQLConnection {
    public static Connection getConnection(){
        Connection con=null;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
}

