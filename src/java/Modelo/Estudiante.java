/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
/**
 *
 * @author AARON ROMAN
 */
public class Estudiante {
    
    private int id_p_e;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String cedula;
    private String sexo;
    private String fecha;
    private String nacionalidad;
    private String celular;
    private String telefono;
    private String correo;
    private String direccion;
    private String procedencia;
    private String anio;
    private String cedula_r;
    

    public Estudiante() {
    }

    public Estudiante(int id_p_e, String nombre1, String nombre2, String apellido1, String apellido2, String cedula, String sexo, String fecha, String nacionalidad, String celular, String telefono, String correo, String direccion, String procedencia, String anio, String cedula_r) {
        this.id_p_e = id_p_e;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.cedula = cedula;
        this.sexo = sexo;
        this.fecha = fecha;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.procedencia = procedencia;
        this.anio = anio;
        this.cedula_r = cedula_r;
    }

    public int getId_p_e() {
        return id_p_e;
    }

    public void setId_p_e(int id_p_e) {
        this.id_p_e = id_p_e;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
    
    public String getCedula_r(){ 
        return cedula_r;
    }
    
    public void setCedula_r(String cedula_r){ 
        this.cedula_r = cedula_r;
    }
}
