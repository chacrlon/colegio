
package Modelo;

import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuariosCRUD {
    Conexion con= new Conexion();       
     int r;
     
     public Usuarios validar(String nick, String pass) {
        Usuarios em = new Usuarios();
        String sql = "select * from usuarios where nick=? and password=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, nick);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId_u(rs.getInt(1));
                em.setNick(rs.getString(2));
                em.setPass(rs.getString(3));
                em.setTipo_u(rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return em;
    }

public List listar() {
        String sql="select * from usuarios";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Usuarios>lista=new ArrayList<>();
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Usuarios periodo = new Usuarios();
                periodo.setId_u(rs.getInt(1));
                periodo.setNick(rs.getString(2));
                periodo.setPass(rs.getString(3));
                periodo.setTipo_u(rs.getInt(4));               
                lista.add(periodo);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return lista;
    }

public Usuarios listarId(int id) {
        Usuarios periodo= new Usuarios();
        String sql="select * from usuarios where id_usuario="+id;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){                               
                periodo.setId_u(rs.getInt(1));
                periodo.setNick(rs.getString(2));
                periodo.setPass(rs.getString(3));
                periodo.setTipo_u(rs.getInt(4));                 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(pst != null)
                    pst.close();
                if(rs != null)
                    rs.close();
                if(conn != null)
                    conn.close();    
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return periodo;
    }


public int agregar(Usuarios admin) {
        String sql="insert into usuarios(nick, password, tipo_usuario)values(?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, admin.getNick());
            ps.setString(2, admin.getPass());
            ps.setInt(3, admin.getTipo_u());
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

     public int actualizar(Usuarios admin) {
        String sql="update usuarios set nick=?, password=?, tipo_usuario=? where id_usuario=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, admin.getNick());
            ps.setString(2, admin.getPass());
            ps.setInt(3, admin.getTipo_u());
            ps.setInt(4, admin.getId_u());
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
     
     
     public void delete(int id) {
        String sql="delete from usuarios where id_usuario="+id;       
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.executeUpdate();           
        } catch (Exception e) {
            e.printStackTrace();
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
    }
}
