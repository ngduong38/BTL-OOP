package ConnectDB;

import java.sql.Connection;
import java.sql.*;


public class DBConection {
    // Database Parameters
    private  static  final String URL = "jdbc:mysql://localhost:3306/";
    private  static  final String USER = "root";
    private  static  final String PASSWORD = "123456";
    private  static  final String DBNAME = "qltv";
    private  static  final String PARAMETERS = "?verifyServerCertificate=false&useSSL=true";

    // Connection
    public static Connection getCennection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL+DBNAME+PARAMETERS,USER,PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public  static  void disconnect (Connection conn){
        try {
            if (conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  static  void main(String[] args){
        Connection conn =getCennection();

        if(conn != null) {
            System.out.println("Connect!");
        }else {
            System.out.println("No Connect!");
        }
    }
}