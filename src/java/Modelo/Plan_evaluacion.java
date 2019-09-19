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
public class Plan_evaluacion {
       
    private int id_plan;
    private int numero;
    private String titulo;
    private int escala;
    private int peso;
    private int id_periodo;
    private int id_anio;
    private int id_seccion;
    private int id_asignatura;
    private int id_lapso;
    private int id_p_d;

    public Plan_evaluacion() {
    }

    public Plan_evaluacion(int id_plan, int numero, String titulo, int escala, int peso, int id_periodo, int id_anio, int id_seccion, int id_asignatura, int id_lapso, int id_p_d) {
        this.id_plan = id_plan;
        this.numero = numero;
        this.titulo = titulo;
        this.escala = escala;
        this.peso = peso;
        this.id_periodo = id_periodo;
        this.id_anio = id_anio;
        this.id_seccion = id_seccion;
        this.id_asignatura = id_asignatura;
        this.id_lapso = id_lapso;
        this.id_p_d = id_p_d;
    }

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getEscala() {
        return escala;
    }

    public void setEscala(int escala) {
        this.escala = escala;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }

    public int getId_anio() {
        return id_anio;
    }

    public void setId_anio(int id_anio) {
        this.id_anio = id_anio;
    }

    public int getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(int id_seccion) {
        this.id_seccion = id_seccion;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public int getId_lapso() {
        return id_lapso;
    }

    public void setId_lapso(int id_lapso) {
        this.id_lapso = id_lapso;
    }

    public int getId_p_d() {
        return id_p_d;
    }

    public void setId_p_d(int id_p_d) {
        this.id_p_d = id_p_d;
    }
    
    
}
