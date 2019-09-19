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
public class Plan_evaluacionCRUD {
    Conexion con= new Conexion();       
     int r;
       

public List listar() {
        String sql="select * from plan_evaluacion";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Plan_evaluacion>lista=new ArrayList<>();
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){     
            Plan_evaluacion doc= new Plan_evaluacion();
            doc.setId_p_d(rs.getInt(1));
            doc.setNumero(rs.getInt(2));
            doc.setTitulo(rs.getString(3));     
            doc.setEscala(rs.getInt(4));
            doc.setPeso(rs.getInt(5));
            doc.setId_periodo(rs.getInt(6));
            doc.setId_anio(rs.getInt(7));     
            doc.setId_seccion(rs.getInt(8));
            doc.setId_asignatura(rs.getInt(9));
            doc.setId_lapso(rs.getInt(10));
            doc.setId_p_d(rs.getInt(11));     
                lista.add(doc);
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

public Plan_evaluacion listarId(int id) {
        Plan_evaluacion doc= new Plan_evaluacion();
        String sql="select * from plan_evaluacion where id_plan="+id;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){                               
            doc.setId_p_d(rs.getInt(1));
            doc.setNumero(rs.getInt(2));
            doc.setTitulo(rs.getString(3));     
            doc.setEscala(rs.getInt(4));
            doc.setPeso(rs.getInt(5));
            doc.setId_periodo(rs.getInt(6));
            doc.setId_anio(rs.getInt(7));     
            doc.setId_seccion(rs.getInt(8));
            doc.setId_asignatura(rs.getInt(9));
            doc.setId_lapso(rs.getInt(10));
            doc.setId_p_d(rs.getInt(11));  
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
        return doc;
    }


public int agregar(Plan_evaluacion doc) {
        String sql="insert into plan_evaluacion(numero, titulo, escala, peso, id_periodo, id_anio, id_seccion, id_asignatura, id_lapso, id_p_d)values(?,?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, doc.getNumero());
            ps.setString(2, doc.getTitulo());
            ps.setInt(3, doc.getEscala());
            ps.setInt(4, doc.getPeso());
            ps.setInt(5, doc.getId_periodo());
            ps.setInt(6, doc.getId_anio());
            ps.setInt(7, doc.getId_seccion());
            ps.setInt(8, doc.getId_asignatura());
            ps.setInt(9, doc.getId_lapso());
            ps.setInt(10, doc.getId_p_d());
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

     public int actualizar(Plan_evaluacion doc) {
        String sql="update plan_evaluacion set numero=?, titulo=?, escala=?, peso=?, id_periodo=?, id_anio=?, id_seccion=?, id_asignatura=?, id_lapso=?, id_p_d=? where id_plan=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, doc.getNumero());
            ps.setString(2, doc.getTitulo());
            ps.setInt(3, doc.getEscala());
            ps.setInt(4, doc.getPeso());
            ps.setInt(5, doc.getId_periodo());
            ps.setInt(6, doc.getId_anio());
            ps.setInt(7, doc.getId_seccion());
            ps.setInt(8, doc.getId_asignatura());
            ps.setInt(9, doc.getId_lapso());
            ps.setInt(10, doc.getId_p_d());
            ps.setInt(11, doc.getId_plan());
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
        String sql="delete from plan_evaluacion where id_plan="+id;       
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
