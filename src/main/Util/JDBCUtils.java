package Util;

import java.sql.*;

public class JDBCUtils {
    //链接数据库
    public  static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///myschool","root","root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    //关闭数据库(两个参数)
    public  static void close(PreparedStatement pstm, Connection con){
        try {
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //关闭数据库(三个参数)
    public static  void close(ResultSet rs, PreparedStatement pstm, Connection con){
        try {
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            pstm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
