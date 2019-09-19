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
public class PublicacionCRUD {
    Conexion con= new Conexion();       
     int r;

public List listar() {
        String sql="select * from publicaciones";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Publicacion>lista=new ArrayList<>();
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Publicacion admin= new Publicacion();
                admin.setId_pu(rs.getInt(1));
                admin.setTitulo(rs.getString(2));
                admin.setMensaje(rs.getString(3));
                admin.setFecha(rs.getString(4));               
                admin.setHora(rs.getString(5));
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

public Publicacion listarId(int id) {
        Publicacion admin= new Publicacion();
        String sql="select * from publicaciones where id_publicacion="+id;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){                               
                admin.setId_pu(rs.getInt(1));
                admin.setTitulo(rs.getString(2));
                admin.setMensaje(rs.getString(3));
                admin.setFecha(rs.getString(4));               
                admin.setHora(rs.getString(5));   
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


public int agregar(Publicacion admin) {
        String sql="insert into publicaciones(titulo, mensaje, fecha, hora)values(?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, admin.getTitulo());
            ps.setString(2, admin.getMensaje());
            ps.setString(3, admin.getFecha());
            ps.setString(4, admin.getHora());
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

     public int actualizar(Publicacion admin) {
        String sql="update publicaciones set titulo=?, mensaje=?, fecha=?, hora=? where id_publicacion=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, admin.getTitulo());
            ps.setString(2, admin.getMensaje());
            ps.setString(3, admin.getFecha());
            ps.setString(4, admin.getHora());
            ps.setInt(5, admin.getId_pu());
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
        String sql="delete from publicaciones where id_publicacion="+id;       
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
