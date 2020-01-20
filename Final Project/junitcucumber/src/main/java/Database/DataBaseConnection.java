package Database;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
    public static void main(String[] args) throws ClassNotFoundException {
        getDataBaseValue("Column name");
    }

    public static String getDataBaseValue(String columnLabel) {
        String url = "jdbc:mysql://localhost:3306/user?useUnicode=false&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Qwertyu01!";
        String query = "SELECT * from UserData";
        String returnValue = "";
        Logger log = Logger.getLogger(DataBaseConnection.class.getName());
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            rs.next();
            returnValue = rs.getString(columnLabel);
            log.info("DB data executed successfully");

        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DB data is not executed");
        }
        return returnValue;
    }
}
