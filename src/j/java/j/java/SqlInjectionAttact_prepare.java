package j.java;

import java.sql.*;

public class SqlInjectionAttact_prepare {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/jpa";
        String user="root";
        String pword="1234";

        try (Connection con= DriverManager.getConnection(url,user,pword);){
            String sql="select * from customer where phone_no=?";
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            preparedStatement.setLong(1,1020202021L);
            ResultSet r= preparedStatement.executeQuery();
            while (r.next()){
                Long phone=r.getLong(1);
                String name=r.getString(2);
                Integer age=r.getInt(3);
                String gender=r.getString(4);
                String address=r.getString(5);
                Integer plan=r.getInt(6);

                System.out.println(phone+","+name+","+age+","+gender+","+address+","+plan);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
