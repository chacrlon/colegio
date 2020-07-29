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
@Table(name = "paquetes_materias", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_paquete_materias"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaquetesMaterias.findAll", query = "SELECT p FROM PaquetesMaterias p")
    , @NamedQuery(name = "PaquetesMaterias.findByIdPaqueteMaterias", query = "SELECT p FROM PaquetesMaterias p WHERE p.idPaqueteMaterias = :idPaqueteMaterias")})
public class PaquetesMaterias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paquete_materias", nullable = false)
    private Integer idPaqueteMaterias;
    @JoinColumn(name = "asignaturas_id_asignatura", referencedColumnName = "id_asignatura", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Asignaturas asignaturasIdAsignatura;
    @JoinColumn(name = "seccion_id_seccion", referencedColumnName = "id_seccion", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Secciones seccionIdSeccion;

    public PaquetesMaterias() {
    }

    public PaquetesMaterias(Integer idPaqueteMaterias) {
        this.idPaqueteMaterias = idPaqueteMaterias;
    }

    public Integer getIdPaqueteMaterias() {
        return idPaqueteMaterias;
    }

    public void setIdPaqueteMaterias(Integer idPaqueteMaterias) {
        this.idPaqueteMaterias = idPaqueteMaterias;
    }

    public Asignaturas getAsignaturasIdAsignatura() {
        return asignaturasIdAsignatura;
    }

    public void setAsignaturasIdAsignatura(Asignaturas asignaturasIdAsignatura) {
        this.asignaturasIdAsignatura = asignaturasIdAsignatura;
    }

    public Secciones getSeccionIdSeccion() {
        return seccionIdSeccion;
    }

    public void setSeccionIdSeccion(Secciones seccionIdSeccion) {
        this.seccionIdSeccion = seccionIdSeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaqueteMaterias != null ? idPaqueteMaterias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaquetesMaterias)) {
            return false;
        }
        PaquetesMaterias other = (PaquetesMaterias) object;
        if ((this.idPaqueteMaterias == null && other.idPaqueteMaterias != null) || (this.idPaqueteMaterias != null && !this.idPaqueteMaterias.equals(other.idPaqueteMaterias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.PaquetesMaterias[ idPaqueteMaterias=" + idPaqueteMaterias + " ]";
    }
    
}
