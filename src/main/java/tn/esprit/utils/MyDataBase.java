package tn.esprit.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyDataBase {
    public String url = "jdbc:mysql://localhost:3306/workshop3a22";
    public String login = "root";
    public String pwd = "";
    Connection cnx;
    public static MyDataBase instance;
    private MyDataBase() {
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("connected .... !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("ERROR  .... !");

        }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static MyDataBase getInstance() {
        if (instance == null) {
            instance = new MyDataBase();

        }
        return instance;

    }



}
