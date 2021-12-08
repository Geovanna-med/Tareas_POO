package nomina.database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import nomina.database.Connector;

public class NominaDBCRUD {
    Connector db;
    String query;

    public NominaDBCRUD(){
    }

    public ResultSet consultTable(String tableName){
        ResultSet resultSet = null;
        try{
            db = new Connector("jdbc:mariadb://localhost:3306/DB?user=geovanna&password=Amarillo100802");
            db.connect();
            Connection con = db.getConnection();
            Statement stmt = con.createStatement();
            query =  "SELECT * FROM " + tableName;
            resultSet = stmt.executeQuery(query);
        } catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
        return resultSet;
    }

}
