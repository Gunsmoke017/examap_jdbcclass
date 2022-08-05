package databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExamAppConnection {
    Connection connection;

    public boolean connectToDatabase(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/examapp", "root","");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;
    }

    public Connection getConnections() {
        return connection;
    }
}
