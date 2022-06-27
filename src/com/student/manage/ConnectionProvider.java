package com.student.manage;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionProvider {
    static Connection connection=null;
    public static Connection createConnection()
    {
        try {

            Class.forName("com.mysql.jdbc.Driver"); // load the driver by providing driver class name
            String user="root";
            String password="xyz";
            String url="jdbc:mysql://localhost:3306/student_manage"; // jdbc:mysql://localhost:3306/ -> same for everyone

            // create connection
            connection= DriverManager.getConnection(url,user,password);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        return connection;
    }
}
