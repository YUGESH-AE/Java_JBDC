package j.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareStatementInsert {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jpa";
        String user = "root";
        String pword = "1234";

        try (Connection con = DriverManager.getConnection(url, user, pword);) {

            PreparedStatement preparedStatement= con.prepareStatement("INSERT INTO CUSTOMER(phone_no,name,age,gender,address,plan_id)value(?,?,?,?,?,?)");
            preparedStatement.setLong(1,90000000L);
            preparedStatement.setString(2,"Yugesh");
            preparedStatement.setInt(3,21);
            preparedStatement.setString(4,"M");
            preparedStatement.setString(5,"banglore");
            preparedStatement.setInt(6,8);
            int resulty=preparedStatement.executeUpdate();
            if(resulty>0){
                System.out.println("Records inserted successfully");
            }
            else {
                System.out.println("no Records inserted");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
