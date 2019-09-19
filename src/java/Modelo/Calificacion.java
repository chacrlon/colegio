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
public class Calificacion {

    
    private int id_ca;
    private double calificacion;
    private String fecha_carga;
    private int id_plan;
    private int id_p_e;

    public Calificacion() {
    }
    
    public Calificacion(int id_ca, double calificacion, String fecha_carga, int id_plan, int id_p_e) {
        this.id_ca = id_ca;
        this.calificacion = calificacion;
        this.fecha_carga = fecha_carga;
        this.id_plan = id_plan;
        this.id_p_e = id_p_e;
    }

    public int getId_ca() {
        return id_ca;
    }

    public void setId_ca(int id_ca) {
        this.id_ca = id_ca;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getFecha_carga() {
        return fecha_carga;
    }

    public void setFecha_carga(String fecha_carga) {
        this.fecha_carga = fecha_carga;
    }

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

    public int getId_p_e() {
        return id_p_e;
    }

    public void setId_p_e(int id_p_e) {
        this.id_p_e = id_p_e;
    }
    
    
}
