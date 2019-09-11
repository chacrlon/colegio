/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AARON ROMAN
 */
public class AsignaturaCRUD {
    Conexion con= new Conexion();       
     int r;

public List listar() {
        String sql="select * from asignaturas";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Asignatura>lista=new ArrayList<>();
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Asignatura admin = new Asignatura();
                admin.setId_a(rs.getInt(1));
                admin.setCodigo(rs.getString(2));
                admin.setNombre(rs.getString(3));
                admin.setMinimo(rs.getDouble(4));
                admin.setMaximo(rs.getDouble(5));               
                admin.setEstatus(rs.getString(6));
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

public Asignatura listarId(int id) {
        Asignatura admin= new Asignatura();
        String sql="select * from asignaturas where id_asignatura="+id;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){                               
            admin.setId_a(rs.getInt(1));
            admin.setCodigo(rs.getString(2));
            admin.setNombre(rs.getString(3));
            admin.setMinimo(rs.getDouble(4));
            admin.setMaximo(rs.getDouble(5));               
            admin.setEstatus(rs.getString(6));   
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
        return admin;
    }


public int agregar(Asignatura admin) {
        String sql="insert into asignaturas(codigo, nombre, minimo, maximo, estatus)values(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, admin.getCodigo());
            ps.setString(2, admin.getNombre());
            ps.setDouble(3, admin.getMinimo());
            ps.setDouble(4, admin.getMaximo());
            ps.setString(5, admin.getEstatus());
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

     public int actualizar(Asignatura admin) {
        String sql="update asignaturas set codigo=?, nombre=?, minimo=?, maximo=?, estatus=? where id_asignatura=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, admin.getCodigo());
            ps.setString(2, admin.getNombre());
            ps.setDouble(3, admin.getMinimo());
            ps.setDouble(4, admin.getMaximo());
            ps.setString(5, admin.getEstatus());
            ps.setInt(14, admin.getId_a());
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
        String sql="delete from asignaturas where id_asignatura="+id;       
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
