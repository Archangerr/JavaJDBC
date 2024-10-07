

import java.sql.*;

public class DBConn {
    public static final String DB_URL="jdbc:mysql://localhost/university";
    public static final String DB_USER="root";
    public static final String DB_PASSWORD="mysql";

    public static void main(String[] args) {
        Connection connect =null;


        try {
            connect = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            connect.setAutoCommit(false);
            PreparedStatement pr = connect.prepareStatement("INSERT INTO student (studentName,studentClass) VALUES (?,?)");
            pr.setString(1,"John");
            pr.setInt(2,2);
            pr.executeUpdate();

            if(true){
                throw new SQLException();
            }

            pr.setString(1,"Mami");
            pr.setInt(2,4);
            pr.executeUpdate();

            connect.commit();
            pr.close();
            connect.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
