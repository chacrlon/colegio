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
public class CalificacionCRUD {
    Conexion con= new Conexion();       
     int r;

public List listar() {
        String sql="select * from calificacion";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Calificacion>lista=new ArrayList<>();
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Calificacion admin = new Calificacion();
                admin.setId_ca(rs.getInt(1));
                admin.setCalificacion(rs.getDouble(2));
                admin.setFecha_carga(rs.getString(3));
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

public Calificacion listarId(int id) {
        Calificacion admin = new Calificacion();
        String sql="select * from calificacion where id_calificacion="+id;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){                               
                admin.setId_ca(rs.getInt(1));
                admin.setCalificacion(rs.getDouble(2));
                admin.setFecha_carga(rs.getString(3));  
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


public int agregar(Calificacion admin) {
        String sql="insert into calificacion(calificacion, fecha_carga, id_plan, id_p_e)values(?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setDouble(1, admin.getCalificacion());
            ps.setString(2, admin.getFecha_carga());
            ps.setInt(3, admin.getId_plan());
            ps.setInt(4, admin.getId_p_e());
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

     public int actualizar(Calificacion admin) {
        String sql="update calificacion set calificacion=?, fecha_carga=?, id_plan=?, id_p_e=? where id_calificacion=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setDouble(1, admin.getCalificacion());
            ps.setString(2, admin.getFecha_carga());
            ps.setInt(3, admin.getId_plan());
            ps.setInt(4, admin.getId_p_e());
            ps.setInt(5, admin.getId_ca());
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
        String sql="delete from calificacion where id_calificacion="+id;       
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
