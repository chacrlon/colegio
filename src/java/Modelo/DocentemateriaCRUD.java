
package Modelo;

import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DocentemateriaCRUD {
    
    Conexion con= new Conexion();       
     int r;
    
    public int asignarmateria(Docentemateria doc) {
        String sql="insert into docente_materia(id_p_d, id_periodo, id_anio, id_seccion, id_asignatura)values(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, doc.getDocente());
            ps.setInt(2, doc.getPeriodo());
            ps.setInt(3, doc.getAnio());
            ps.setInt(4, doc.getSeccion());
            ps.setInt(5, doc.getMateria());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        finally {
            try {
                if(ps != null)
                    ps.close();
                if(rs != null)
                    rs.close();
                if(conn != null)
                    conn.close();    
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }       
        return r;
    }
}
