package mydemosof203.tiennh21.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
    private static Connection conn;
    
    public static Connection getConnection ()
    {
        if (JdbcUtil.conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String dbUrl = "jdbc:mysql://localhost:3306/sof203_demo";
                String dbUser = "root";
                String dbPass = "Aa@123456";
                JdbcUtil.conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return JdbcUtil.conn;
    }
}
