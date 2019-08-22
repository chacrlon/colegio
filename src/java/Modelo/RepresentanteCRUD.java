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
public class RepresentanteCRUD {
      
     Conexion con= new Conexion();       
     int r;
       

public List listar() {
        String sql="select * from planilla_representante";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Representante>lista=new ArrayList<>();
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){     
            Representante re= new Representante();
            re.setId_p_r(rs.getInt(1));
            re.setNombre1(rs.getString(2));
            re.setNombre2(rs.getString(3));     
            re.setApellido1(rs.getString(4));
            re.setApellido2(rs.getString(5));
            re.setCedula(rs.getString(6));
            re.setSexo(rs.getString(7));     
            re.setFecha(rs.getString(8));
            re.setNacionalidad(rs.getString(9));
            re.setTelefono(rs.getString(10));
            re.setCorreo(rs.getString(11));     
            re.setDireccion(rs.getString(12));
                lista.add(re);
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

public Representante listarId(int id) {
        Representante re= new Representante();
        String sql="select * from planilla_representante where id_p_r="+id;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){                               
            re.setId_p_r(rs.getInt(1));
            re.setNombre1(rs.getString(2));
            re.setNombre2(rs.getString(3));     
            re.setApellido1(rs.getString(4));
            re.setApellido2(rs.getString(5));
            re.setCedula(rs.getString(6));
            re.setSexo(rs.getString(7));     
            re.setFecha(rs.getString(8));
            re.setNacionalidad(rs.getString(9));
            re.setTelefono(rs.getString(10));
            re.setCorreo(rs.getString(11));     
            re.setDireccion(rs.getString(12));   
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
        return re;
    }


public int agregar(Representante re) {
        String sql="insert into planilla_representante(nombre1, nombre2, apellido1, apellido2, cedula, sexo, fecha, nacionalidad, telefono, correo, direccion)values(?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, re.getNombre1());
            ps.setString(2, re.getNombre2());
            ps.setString(3, re.getApellido1());
            ps.setString(4, re.getApellido2());
            ps.setString(5, re.getCedula());
            ps.setString(6, re.getSexo());
            ps.setString(7, re.getFecha());
            ps.setString(8, re.getNacionalidad());
            ps.setString(9, re.getTelefono());
            ps.setString(10, re.getCorreo());
            ps.setString(11, re.getDireccion());
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

     public int actualizar(Representante re) {
        String sql="update planilla_representante set nombre1=?, nombre2=?, apellido1=?, apellido2=?, cedula=?, sexo=?, fecha=?, nacionalidad=?, telefono=?, correo=?, direccion=?, where id_p_r=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, re.getNombre1());
            ps.setString(2, re.getNombre2());
            ps.setString(3, re.getApellido1());
            ps.setString(4, re.getApellido2());
            ps.setString(5, re.getCedula());
            ps.setString(6, re.getSexo());
            ps.setString(7, re.getFecha());
            ps.setString(8, re.getNacionalidad());
            ps.setString(9, re.getTelefono());
            ps.setString(10, re.getCorreo());
            ps.setString(11, re.getDireccion());
            ps.setInt(12, re.getId_p_r());
            int r=ps.executeUpdate();
            if(r==1){ 
                return 1;
            }else{ 
                return 0;
            }
            
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
    }
     
     
     public int delete(int id) {
        String sql="delete from planilla_representante where id_p_r="+id;       
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=con.Conexionn();
            ps=conn.prepareStatement(sql);
            int r=ps.executeUpdate();
            if(r==1){ 
                return 1;
            }else{ 
                return 0;
            }
            
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
    }
}
