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
public class Seccion {
    
    private int id_s;
    private String codigo;
    private String nombre;
    private String estatus;
    private int id_p;
    private int id_a;

    public Seccion() {
    }

    public Seccion(int id_s, String codigo, String nombre, String estatus, int id_p, int id_a) {
        this.id_s = id_s;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estatus = estatus;
        this.id_p = id_p;
        this.id_a = id_a;
    }

    public int getId_s() {
        return id_s;
    }

    public void setId_s(int id_s) {
        this.id_s = id_s;
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

    public int getId_a() {
        return id_a;
    }

    public void setId_a(int id_a) {
        this.id_a = id_a;
    }

}
