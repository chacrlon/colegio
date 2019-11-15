
package Modelo;


public class Docentemateria {
    
    private int id_dm;
    private int docente;
    private int periodo;
    private int anio;
    private int seccion;
    private int materia;

    public Docentemateria() {
    }

    public Docentemateria(int id_dm, int docente, int periodo, int anio, int seccion, int materia) {
        this.id_dm = id_dm;
        this.docente = docente;
        this.periodo = periodo;
        this.anio = anio;
        this.seccion = seccion;
        this.materia = materia;
    }


    public int getId_dm() {
        return id_dm;
    }

    public void setId_dm(int id_dm) {
        this.id_dm = id_dm;
    }

    public int getDocente() {
        return docente;
    }

    public void setDocente(int docente) {
        this.docente = docente;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public int getMateria() {
        return materia;
    }

    public void setMateria(int materia) {
        this.materia = materia;
    }
    
    
    
}
