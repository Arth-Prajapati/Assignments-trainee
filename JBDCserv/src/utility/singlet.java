package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class singlet {
    private static singlet singlet = new singlet();


    //constructor
    private singlet(){ }

    public static singlet getInstance(){
        return singlet;
    }

    public static Connection GetConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/adventureworks;","root","root");
        System.out.println("connection Successful");

        return con;

    }
}
