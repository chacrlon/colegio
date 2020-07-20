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
public class Anio {
    private int id_a;
    private String codigo;
    private String nombre;
    private String estatus;
    private int id_p;
    private int id_p_d;

    public Anio() {
    }

    public Anio(int id_a, String codigo, String nombre, String estatus, int id_p, int id_p_d) {
        this.id_a = id_a;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estatus = estatus;
        this.id_p = id_p;
        this.id_p = id_p_d;
    }

    public int getId_a() {
        return id_a;
    }

    public void setId_a(int id_a) {
        this.id_a = id_a;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }
    
    public int getId_p_d() {
        return id_p_d;
    }

    public void setId_p_d(int id_p_d) {
        this.id_p_d = id_p_d;
    }

    

}
