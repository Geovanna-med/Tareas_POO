/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmosbotconnection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author user
 */
public class dbproperties {
    private Properties dbinfo = new Properties();
    private Properties credentials = new Properties();
    
    public dbproperties(){
        try{
        dbinfo.load(new FileInputStream("dbinfo.properties"));
        credentials.load(new FileInputStream("credentials.properties"));
        }catch(FileNotFoundException exception){ //exception es el nombre que yo le pongo a la exception
            exception.printStackTrace(System.out);
        }catch(IOException exception){
            exception.printStackTrace(System.out);
        }
    }
    
    public String getUrlString(){
        String driverManager = dbinfo.getProperty("dm");//driver manager
        String driver = dbinfo.getProperty("driver");
        String host = dbinfo.getProperty("host");
        String puerto = dbinfo.getProperty("puerto");
        String db = dbinfo.getProperty("db");
        
        //jdbc:mariadb://localhost:3306/database
        String url = driverManager + ":" + driver + "://"+ host + ":" + puerto + "/" + db;
        
        return url;
    }
    
    public Properties getCredentials(){
        return credentials;
    }
    
    public static void main(String[] args){
        dbproperties misDBProperties = new dbproperties();
        System.out.println(misDBProperties.getUrlString());
    }
    
}
