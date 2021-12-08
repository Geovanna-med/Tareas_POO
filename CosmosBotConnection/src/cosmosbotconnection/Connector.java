/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmosbotconnection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author user
 */
public class Connector {
    
    public static void main(String[] args){
        dbproperties misDBProperties = new dbproperties();
        System.out.println("Connection Succesfully");
        try{
            Connection miConexion = DriverManager.getConnection(misDBProperties.getUrlString(), misDBProperties.getCredentials());
        } catch(SQLException exception){ //exception es el nombre que yo le pongo a la exception
            exception.printStackTrace(System.out);
            
        }    
      
    }
    
    private Connection conn = null;
    String urlString;

    public Connector(String urlString) {
        this.urlString = urlString;
    }

    public void connect() {
        try {
            this.conn = DriverManager.getConnection(this.urlString);
            System.out.println("Success Connection \n");
        } catch (SQLException exception) {
            // handle errors
            System.out.println("SQLException: " + exception.getMessage());
            System.out.println("SQLState: " + exception.getSQLState());
            System.out.println("VendorError: " + exception.getErrorCode());
        }
    }

    public void close(){
        try {
            this.conn.close();
            System.out.println("Closed connection \n");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public Connection getConn() {
        return this.conn;
    }

    public Connection getConnection(){
        return this.conn;
    }


}
