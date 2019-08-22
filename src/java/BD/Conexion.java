
package BD;

import java.sql.*;

public class Conexion {
    public Conexion(){

    }
    
    public Connection Conexionn(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio","root","");            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        finally {
           return con;
        }
         
    }
}
