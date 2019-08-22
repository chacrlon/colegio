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
public class EstudianteCRUD {
     
     Conexion con= new Conexion();       
     int r;
       

public List listar() {
        String sql="select * from planilla_estudiante";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Estudiante>lista=new ArrayList<>();
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){     
            Estudiante es= new Estudiante();
            es.setId_p_e(rs.getInt(1));
            es.setNombre1(rs.getString(2));
            es.setNombre2(rs.getString(3));     
            es.setApellido1(rs.getString(4));
            es.setApellido2(rs.getString(5));
            es.setCedula(rs.getString(6));
            es.setSexo(rs.getString(7));     
            es.setFecha(rs.getString(8));
            es.setNacionalidad(rs.getString(9));
            es.setCelular(rs.getString(10));
            es.setTelefono(rs.getString(11));
            es.setCorreo(rs.getString(12));     
            es.setDireccion(rs.getString(13));
            es.setProcedencia(rs.getString(14));     
            es.setAnio(rs.getString(15));
            es.setCedula_r(rs.getString(16));
                lista.add(es);
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

public Estudiante listarId(int id) {
        Estudiante es= new Estudiante();
        String sql="select * from planilla_estudiante where id_p_e="+id;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){                               
            es.setId_p_e(rs.getInt(1));
            es.setNombre1(rs.getString(2));
            es.setNombre2(rs.getString(3));     
            es.setApellido1(rs.getString(4));
            es.setApellido2(rs.getString(5));
            es.setCedula(rs.getString(6));
            es.setSexo(rs.getString(7));     
            es.setFecha(rs.getString(8));
            es.setNacionalidad(rs.getString(9));
            es.setCelular(rs.getString(10));
            es.setTelefono(rs.getString(11));
            es.setCorreo(rs.getString(12));     
            es.setDireccion(rs.getString(13));
            es.setProcedencia(rs.getString(14));     
            es.setAnio(rs.getString(15));
            es.setCedula_r(rs.getString(16));
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
        return es;
    }


public int agregar(Estudiante es) {
        String sql="insert into planilla_estudiante(nombre1, nombre2, apellido1, apellido2, cedula, sexo, fecha, nacionalidad, celular, telefono, correo, direccion, procedencia, anio, cedula_r)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, es.getNombre1());
            ps.setString(2, es.getNombre2());
            ps.setString(3, es.getApellido1());
            ps.setString(4, es.getApellido2());
            ps.setString(5, es.getCedula());
            ps.setString(6, es.getSexo());
            ps.setString(7, es.getFecha());
            ps.setString(8, es.getNacionalidad());
            ps.setString(9, es.getCelular());
            ps.setString(10, es.getTelefono());
            ps.setString(11, es.getCorreo());
            ps.setString(12, es.getDireccion());
            ps.setString(13, es.getProcedencia());
            ps.setString(14, es.getAnio());
            ps.setString(15, es.getCedula_r());
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

     public int actualizar(Estudiante es) {
        String sql="update planilla_estudiante set nombre1=?, nombre2=?, apellido1=?, apellido2=?, cedula=?, sexo=?, fecha=?, nacionalidad=?, celular=?, telefono=?, correo=?, direccion=?, procedencia=?, anio=?, cedula_r=?, where id_p_e=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, es.getNombre1());
            ps.setString(2, es.getNombre2());
            ps.setString(3, es.getApellido1());
            ps.setString(4, es.getApellido2());
            ps.setString(5, es.getCedula());
            ps.setString(6, es.getSexo());
            ps.setString(7, es.getFecha());
            ps.setString(8, es.getNacionalidad());
            ps.setString(9, es.getCelular());
            ps.setString(10, es.getTelefono());
            ps.setString(11, es.getCorreo());
            ps.setString(12, es.getDireccion());
            ps.setString(13, es.getProcedencia());
            ps.setString(14, es.getAnio());
            ps.setString(15, es.getCedula_r());
            ps.setInt(16, es.getId_p_e());
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
        String sql="delete from planilla_estudiante where id_p_e="+id;       
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
