package j.java;

import java.sql.*;

public class CallableStarement {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/jpa";
        String user="root";
        String pword="1234";

        try (Connection con= DriverManager.getConnection(url,user,pword);){

            CallableStatement callStmt = con.prepareCall("{ call INSERTDATA(?,?,?,?,?,?,?)}");
            callStmt.setLong(1,1000290306L);
            callStmt.setString(2,"Sugesh");
            callStmt.setInt(3,21);
            callStmt.setString(4,"M");
            callStmt.setString(5,"Chennai");
            callStmt.setInt(6,3);
            callStmt.registerOutParameter(7, Types.INTEGER);
            callStmt.execute();
            String s=callStmt.getString(7);
            System.out.println(s);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
