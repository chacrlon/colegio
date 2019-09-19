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
public class Publicacion {
    private int id_pu;
    private String titulo;
    private String mensaje;
    private String fecha;
    private String hora;

    public Publicacion() {
    }

    public Publicacion(int id_pu, String titulo, String mensaje, String fecha, String hora) {
        this.id_pu = id_pu;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId_pu() {
        return id_pu;
    }

    public void setId_pu(int id_pu) {
        this.id_pu = id_pu;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
}
