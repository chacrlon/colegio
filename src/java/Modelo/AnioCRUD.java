/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.DocenteAcessos;
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
public class AnioCRUD {
    Conexion con= new Conexion();       
     int r;
   
public List listar() {
        String sql="select * from anio";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Anio>lista=new ArrayList<>();
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Anio anio = new Anio();
                anio.setId_a(rs.getInt(1));
                anio.setCodigo(rs.getString(2));
                anio.setNombre(rs.getString(3));              
                anio.setEstatus(rs.getString(4));
                lista.add(anio);
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

public Anio listarId(int id) {
        Anio anio= new Anio();
        String sql="select * from anio where id_anio="+id;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){                               
            anio.setId_a(rs.getInt(1));
            anio.setCodigo(rs.getString(2));
            anio.setNombre(rs.getString(3));              
            anio.setEstatus(rs.getString(4));   
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
        return anio;
    }


public List listarDocente() {
        String sql="select id_anio from docente_materia where id_dm=2";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DocenteAcessos>lista=new ArrayList<>();
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                DocenteAcessos da = new DocenteAcessos();
                da.setId_dm(rs.getInt(1));
                da.setId_p_d(rs.getString(2));
                da.setId_periodo(rs.getString(3));              
                da.setId_anio(rs.getString(4));
                da.setId_seccion(rs.getString(5));              
                da.setId_asignatura(rs.getString(6));
                lista.add(da);
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


public int agregar(Anio admin) {
        String sql="insert into anio(codigo, nombre, estatus)values(?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, admin.getCodigo());
            ps.setString(2, admin.getNombre());
            ps.setString(3, admin.getEstatus());
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


public int agregarIDperiodo(Anio admin) {
        String sql="insert into anio(codigo, nombre, estatus, id_periodo)values(?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, admin.getCodigo());
            ps.setString(2, admin.getNombre());
            ps.setString(3, admin.getEstatus());
            ps.setInt(4, admin.getId_p());
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

    public int agregarIDDocentePeriodo(Anio admin) {
        String sql="insert into anio(codigo, nombre, estatus, id_periodo, id_p_d)valid_periodoues(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, admin.getCodigo());
            ps.setString(2, admin.getNombre());
            ps.setString(3, admin.getEstatus());
            ps.setInt(4, admin.getId_p());
            ps.setInt(5, admin.getId_p_d());
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
    
    
    
     public int actualizar(Anio admin) {
        String sql="update anio set codigo=?, nombre=?, estatus=? where id_anio=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, admin.getCodigo());
            ps.setString(2, admin.getNombre());
            ps.setString(3, admin.getEstatus());
            ps.setInt(4, admin.getId_a());
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
        String sql="delete from anio where id_anio="+id;       
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
