package nomina.database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NominaDBCRUD {
    Connector connector;
    String query;

    public NominaDBCRUD(){
        this.connector = new Connector();
    }

    public ResultSet consultTable(String tableName){
        ResultSet resultSet = null;
        try{
            connector = new Connector();
            connector.connect();
            Connection con = connector.getConnection();
            Statement stmt = con.createStatement();
            query =  "SELECT * FROM " + tableName;
            resultSet = stmt.executeQuery(query);
        } catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
        return resultSet;
    }
    
    //inserta en la tabla las columnas y sus valores
    public int insertOne(String tableName, String columns[], String values[]) {
        //"insert into student(Id,name,number) values(NULL,'rachel','45')");
        String queryString = "INSERT INTO " + tableName + "(";
        for (int i = 0; i < columns.length; i++) {
            queryString += columns[i];
            if (i != columns.length - 1) {
                queryString += ", ";
            } else {
                queryString += ") values(";
            }
        }
        for (int i = 0; i < values.length; i++) {
            queryString += values[i];
            if (i != values.length - 1) {
                queryString += ", ";
            } else {
                queryString += ");";
            }
        }
        System.out.println(queryString);
        int result = 0;
        connector.connect();
        try {
            Statement stmnt = connector.getConnection().createStatement();
            result = stmnt.executeUpdate(queryString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connector.close();
        return result;
    }

     //Elimina en la tabla tableName where the id is equal to the id
    public int deleteOne(String tableName, int id) {
        String queryString = "DELETE FROM " + tableName + " WHERE id=" + String.valueOf(id) + ";";
        //System.out.println(queryString);
        int result = 0;
        connector.connect();
        try {
            Statement stmnt = connector.getConnection().createStatement();
            result = stmnt.executeUpdate(queryString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connector.close();
        return result;
    }

    //Elimina en la tabla tableName where the id is equal to the id
    public int updateOne(String tableName, String columns[], String values[], int id) {
        //"insert into student(Id,name,number) values('1','rachel','45')");
        String queryString = "UPDATE " + tableName + " SET";
        //String sql = "update employee set name='Michael Sam' where emp_id=1";

        for (int i = 0; i < columns.length; i++) {
            queryString += " " + columns[i] + "=" + values[i];
            if (i != columns.length - 1) {
                queryString += ",";
            }
        }
        queryString += " WHERE id=" + String.valueOf(id) + ";";
        //System.out.println(queryString);
        /*
         */
        int result = 0;
        connector.connect();
        try {
            Statement stmnt = connector.getConnection().createStatement();
            result = stmnt.executeUpdate(queryString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connector.close();
        return result;
    }

}
