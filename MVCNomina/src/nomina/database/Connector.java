package nomina.database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Properties;
import java.sql.Statement;
import java.sql.ResultSet;

public class Connector {

    private Connection conn = null;
    private String stringURL;
    private Properties credentials = null;

    public Connector() {
        dbProperties misDbProps = new dbProperties();
        this.stringURL = misDbProps.getUrlString();
        this.credentials = misDbProps.getCredentials();
    }

    public void connect() {
        try {
            this.conn = DriverManager.getConnection(this.stringURL, this.credentials);
            System.out.println("Successful Connection\n");
        } catch (SQLException exception) {
            // handle errors
            System.out.println("SQLException: " + exception.getMessage());
            System.out.println("SQLState: " + exception.getSQLState());
            System.out.println("VendorError: " + exception.getErrorCode());
        }
    }

    public void close() {
        try {
            this.conn.close();
            System.out.println("Closed connection \n");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public static void main(String[] args) {
        Connector miConnector = new Connector();

        miConnector.connect();

//        try {
//            Statement stmnt = miConnector.getConnection().createStatement();
//            ResultSet rs = stmnt.executeQuery("SELECT * FROM jornalero;");
//            while (rs.next()) {
//                System.out.println(rs.getString(1));
//                System.out.println(rs.getString(2));
//                System.out.println(rs.getString(3));
//                System.out.println(rs.getString(4));
//                System.out.println("\n");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        try {
            Statement stmnt = miConnector.getConnection().createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM administradores;");
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                System.out.println(rs.getString(6));
                System.out.println("\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        miConnector.close();

    }

}