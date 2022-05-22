package j.java;



import java.sql.*;

public class StatementDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/jpa";
        String user="root";
        String pword="1234";

        try (Connection con= DriverManager.getConnection(url,user,pword);){
            Statement s= con.createStatement();
            ResultSet r=s.executeQuery("Select * from customer");
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