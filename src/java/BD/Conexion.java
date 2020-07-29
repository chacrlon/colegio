
package BD;

import java.sql.*;

public class Conexion {
    public Conexion(){

    }
    
    public Connection Conexionn(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/colegio_online?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC","root","pass");            
        } catch (Exception e) {
          e.printStackTrace();
        }
        finally {
           return con;
        }
         
    }
}
