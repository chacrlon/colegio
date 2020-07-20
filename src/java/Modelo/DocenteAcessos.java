
package Modelo;

public class DocenteAcessos {
    
    private int id_dm;
    private String id_p_d;
    private String id_periodo;
    private String id_anio;
    private String id_seccion;
    private String id_asignatura;

    public DocenteAcessos() {
    }

    public DocenteAcessos(int id_dm, String id_p_d, String id_periodo, String id_anio, String id_seccion, String id_asignatura) {
        this.id_dm = id_dm;
        this.id_p_d = id_p_d;
        this.id_periodo = id_periodo;
        this.id_anio = id_anio;
        this.id_seccion = id_seccion;
        this.id_asignatura = id_asignatura;
    }

    public int getId_dm() {
        return id_dm;
    }

    public void setId_dm(int id_dm) {
        this.id_dm = id_dm;
    }

    public String getId_p_d() {
        return id_p_d;
    }

    public void setId_p_d(String id_p_d) {
        this.id_p_d = id_p_d;
    }

    public String getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(String id_periodo) {
        this.id_periodo = id_periodo;
    }

    public String getId_anio() {
        return id_anio;
    }

    public void setId_anio(String id_anio) {
        this.id_anio = id_anio;
    }

    public String getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(String id_seccion) {
        this.id_seccion = id_seccion;
    }

    public String getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(String id_asignatura) {
        this.id_asignatura = id_asignatura;
    }
    
    
    
    
}
