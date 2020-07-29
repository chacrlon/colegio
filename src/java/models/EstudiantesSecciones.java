/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author G L703
 */
@Entity
@Table(name = "estudiantes_secciones", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idestudiantes_secciones"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstudiantesSecciones.findAll", query = "SELECT e FROM EstudiantesSecciones e")
    , @NamedQuery(name = "EstudiantesSecciones.findByIdestudiantesSecciones", query = "SELECT e FROM EstudiantesSecciones e WHERE e.idestudiantesSecciones = :idestudiantesSecciones")})
public class EstudiantesSecciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestudiantes_secciones", nullable = false)
    private Integer idestudiantesSecciones;
    @JoinColumn(name = "estudiantes_id_p_e", referencedColumnName = "id_estudiantes", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Estudiantes estudiantesIdPE;
    @JoinColumn(name = "secciones_id_seccion", referencedColumnName = "id_seccion", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Secciones seccionesIdSeccion;

    public EstudiantesSecciones() {
    }

    public EstudiantesSecciones(Integer idestudiantesSecciones) {
        this.idestudiantesSecciones = idestudiantesSecciones;
    }

    public Integer getIdestudiantesSecciones() {
        return idestudiantesSecciones;
    }

    public void setIdestudiantesSecciones(Integer idestudiantesSecciones) {
        this.idestudiantesSecciones = idestudiantesSecciones;
    }

    public Estudiantes getEstudiantesIdPE() {
        return estudiantesIdPE;
    }

    public void setEstudiantesIdPE(Estudiantes estudiantesIdPE) {
        this.estudiantesIdPE = estudiantesIdPE;
    }

    public Secciones getSeccionesIdSeccion() {
        return seccionesIdSeccion;
    }

    public void setSeccionesIdSeccion(Secciones seccionesIdSeccion) {
        this.seccionesIdSeccion = seccionesIdSeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestudiantesSecciones != null ? idestudiantesSecciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudiantesSecciones)) {
            return false;
        }
        EstudiantesSecciones other = (EstudiantesSecciones) object;
        if ((this.idestudiantesSecciones == null && other.idestudiantesSecciones != null) || (this.idestudiantesSecciones != null && !this.idestudiantesSecciones.equals(other.idestudiantesSecciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.EstudiantesSecciones[ idestudiantesSecciones=" + idestudiantesSecciones + " ]";
    }
    
}
