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
            Administrador admin= new Administrador();
            admin.setId_p_a(rs.getInt(1));
            admin.setNombre1(rs.getString(2));
            admin.setNombre2(rs.getString(3));     
            admin.setApellido1(rs.getString(4));
            admin.setApellido2(rs.getString(5));
            admin.setCedula(rs.getString(6));
            admin.setSexo(rs.getString(7));     
            admin.setFecha(rs.getString(8));
            admin.setNacionalidad(rs.getString(9));
            admin.setCelular(rs.getString(10));
            admin.setTelefono(rs.getString(11));
            admin.setCorreo(rs.getString(12));     
            admin.setDireccion(rs.getString(13));
            admin.setEstatus(rs.getString(14));     
                lista.add(admin);
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
        Administrador admin= new Administrador();
        String sql="select * from planilla_administrador where id_p_a="+id;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){                               
            admin.setId_p_a(rs.getInt(1));
            admin.setNombre1(rs.getString(2));
            admin.setNombre2(rs.getString(3));     
            admin.setApellido1(rs.getString(4));
            admin.setApellido2(rs.getString(5));
            admin.setCedula(rs.getString(6));
            admin.setSexo(rs.getString(7));     
            admin.setFecha(rs.getString(8));
            admin.setNacionalidad(rs.getString(9));
            admin.setCelular(rs.getString(10));
            admin.setTelefono(rs.getString(11));
            admin.setCorreo(rs.getString(12));     
            admin.setDireccion(rs.getString(13));
            admin.setEstatus(rs.getString(14));   
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


public int agregar(Administrador admin) {
        String sql="insert into planilla_administrador(nombre1, nombre2, apellido1, apellido2, cedula, sexo, fecha, nacionalidad, celular, telefono, correo, direccion, estatus)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, admin.getNombre1());
            ps.setString(2, admin.getNombre2());
            ps.setString(3, admin.getApellido1());
            ps.setString(4, admin.getApellido2());
            ps.setString(5, admin.getCedula());
            ps.setString(6, admin.getSexo());
            ps.setString(7, admin.getFecha());
            ps.setString(8, admin.getNacionalidad());
            ps.setString(9, admin.getCelular());
            ps.setString(10, admin.getTelefono());
            ps.setString(11, admin.getCorreo());
            ps.setString(12, admin.getDireccion());
            ps.setString(13, admin.getEstatus());
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

     public int actualizar(Administrador admin) {
        String sql="update planilla_administrador set nombre1=?, nombre2=?, apellido1=?, apellido2=?, cedula=?, sexo=?, fecha=?, nacionalidad=?, celular=?, telefono=?, correo=?, direccion=?, estatus=?, where id_p_a=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, admin.getNombre1());
            ps.setString(2, admin.getNombre2());
            ps.setString(3, admin.getApellido1());
            ps.setString(4, admin.getApellido2());
            ps.setString(5, admin.getCedula());
            ps.setString(6, admin.getSexo());
            ps.setString(7, admin.getFecha());
            ps.setString(8, admin.getNacionalidad());
            ps.setString(9, admin.getCelular());
            ps.setString(10, admin.getTelefono());
            ps.setString(11, admin.getCorreo());
            ps.setString(12, admin.getDireccion());
            ps.setString(13, admin.getEstatus());
            ps.setInt(14, admin.getId_p_a());
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

