package nomina.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class dbProperties {
    private Properties dbinfo = new Properties();
    private Properties credentials = new Properties();

    public dbProperties() {
        try {
            dbinfo.load(new FileInputStream("dbinfo.properties"));
            credentials.load(new FileInputStream("credentials.properties"));
        } catch (FileNotFoundException exception) { // exception es el nombre que yo le pongo a la exception
            exception.printStackTrace(System.out);
        } catch (IOException exception) {
            exception.printStackTrace(System.out);
        }
    }
    
     public void loadDbInfo() {
        try {
            dbinfo.load(new FileInputStream("dbinfo.properties"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
     
     public void loadCredentials() {
        try {
            credentials.load(new FileInputStream("credentials.properties"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public String getUrlString() {
        String driverManager = dbinfo.getProperty("dm");// driver manager
        String driver = dbinfo.getProperty("driver");
        String host = dbinfo.getProperty("host");
        String puerto = dbinfo.getProperty("puerto");
        String db = dbinfo.getProperty("db");

        // jdbc:mariadb://localhost:3306/database
        String url = driverManager + ":" + driver + "://" + host + ":" + puerto + "/" + db;

        return url;
    }

    public Properties getCredentials() {
        return credentials;
    }

    public static void main(String[] args) {
        dbProperties misDBProperties = new dbProperties();
        System.out.println(misDBProperties.getUrlString());
    }

}
