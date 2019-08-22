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
public class AdministradorCRUD {
    
    
     Conexion con= new Conexion();       
     int r;
       

public List listar() {
        String sql="select * from planilla_administrador";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Administrador>lista=new ArrayList<>();
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){     
            Administrador doc= new Administrador();
            doc.setId_p_a(rs.getInt(1));
            doc.setNombre1(rs.getString(2));
            doc.setNombre2(rs.getString(3));     
            doc.setApellido1(rs.getString(4));
            doc.setApellido2(rs.getString(5));
            doc.setCedula(rs.getString(6));
            doc.setSexo(rs.getString(7));     
            doc.setFecha(rs.getString(8));
            doc.setNacionalidad(rs.getString(9));
            doc.setCelular(rs.getString(10));
            doc.setTelefono(rs.getString(11));
            doc.setCorreo(rs.getString(12));     
            doc.setDireccion(rs.getString(13));
            doc.setEstatus(rs.getString(14));     
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

public Administrador listarId(int id) {
        Administrador doc= new Administrador();
        String sql="select * from planilla_administrador where id_p_a="+id;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){                               
            doc.setId_p_a(rs.getInt(1));
            doc.setNombre1(rs.getString(2));
            doc.setNombre2(rs.getString(3));     
            doc.setApellido1(rs.getString(4));
            doc.setApellido2(rs.getString(5));
            doc.setCedula(rs.getString(6));
            doc.setSexo(rs.getString(7));     
            doc.setFecha(rs.getString(8));
            doc.setNacionalidad(rs.getString(9));
            doc.setCelular(rs.getString(10));
            doc.setTelefono(rs.getString(11));
            doc.setCorreo(rs.getString(12));     
            doc.setDireccion(rs.getString(13));
            doc.setEstatus(rs.getString(14));   
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


public int agregar(Docente doc) {
        String sql="insert into planilla_administrador(nombre1, nombre2, apellido1, apellido2, cedula, sexo, fecha, nacionalidad, celular, telefono, correo, direccion, estatus)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, doc.getNombre1());
            ps.setString(2, doc.getNombre2());
            ps.setString(3, doc.getApellido1());
            ps.setString(4, doc.getApellido2());
            ps.setString(5, doc.getCedula());
            ps.setString(6, doc.getSexo());
            ps.setString(7, doc.getFecha());
            ps.setString(8, doc.getNacionalidad());
            ps.setString(9, doc.getCelular());
            ps.setString(10, doc.getTelefono());
            ps.setString(11, doc.getCorreo());
            ps.setString(12, doc.getDireccion());
            ps.setString(13, doc.getEstatus());
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

     public int actualizar(Docente doc) {
        String sql="update planilla_administrador set nombre1=?, nombre2=?, apellido1=?, apellido2=?, cedula=?, sexo=?, fecha=?, nacionalidad=?, celular=?, telefono=?, correo=?, direccion=?, estatus=?, where id_p_a=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, doc.getNombre1());
            ps.setString(2, doc.getNombre2());
            ps.setString(3, doc.getApellido1());
            ps.setString(4, doc.getApellido2());
            ps.setString(5, doc.getCedula());
            ps.setString(6, doc.getSexo());
            ps.setString(7, doc.getFecha());
            ps.setString(8, doc.getNacionalidad());
            ps.setString(9, doc.getCelular());
            ps.setString(10, doc.getTelefono());
            ps.setString(11, doc.getCorreo());
            ps.setString(12, doc.getDireccion());
            ps.setString(13, doc.getEstatus());
            ps.setInt(15, doc.getId_p_d());
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
        String sql="delete from planilla_docente where id_p_a="+id;       
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
