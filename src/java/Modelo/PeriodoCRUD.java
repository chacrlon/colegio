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
public class PeriodoCRUD {
    Conexion con= new Conexion();       
     int r;

public List listar() {
        String sql="select * from periodo";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Periodo>lista=new ArrayList<>();
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Periodo periodo = new Periodo();
                periodo.setId_p(rs.getInt(1));
                periodo.setNombre(rs.getString(2));
                periodo.setFecha_i(rs.getString(3));
                periodo.setFecha_f(rs.getString(4));               
                periodo.setEstatus(rs.getString(5));
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

public Periodo listarId(int id) {
        Periodo periodo= new Periodo();
        String sql="select * from periodo where id_periodo="+id;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){                               
                periodo.setId_p(rs.getInt(1));
                periodo.setNombre(rs.getString(2));
                periodo.setFecha_i(rs.getString(3));
                periodo.setFecha_f(rs.getString(4));               
                periodo.setEstatus(rs.getString(5));   
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


public int agregar(Periodo admin) {
        String sql="insert into periodo(nombre, fecha_inicio, fecha_fin, estatus)values(?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, admin.getNombre());
            ps.setString(2, admin.getFecha_i());
            ps.setString(3, admin.getFecha_f());
            ps.setString(4, admin.getEstatus());
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

     public int actualizar(Periodo admin) {
        String sql="update periodo set nombre=?, fecha_inicio=?, fecha_fin=?, estatus=? where id_periodo=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, admin.getNombre());
            ps.setString(2, admin.getFecha_i());
            ps.setString(3, admin.getFecha_f());
            ps.setString(4, admin.getEstatus());
            ps.setInt(5, admin.getId_p());
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
        String sql="delete from periodo where id_periodo="+id;       
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
