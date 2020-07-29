/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author G L703
 */
@Entity
@Table(name = "status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s")
    , @NamedQuery(name = "Status.findByIdStatus", query = "SELECT s FROM Status s WHERE s.idStatus = :idStatus")
    , @NamedQuery(name = "Status.findByDescripcion", query = "SELECT s FROM Status s WHERE s.descripcion = :descripcion")})
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_status", nullable = false)
    private Integer idStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion",nullable = false, length = 45)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusIdStatus", fetch = FetchType.EAGER)
    private List<Periodo> periodoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusIdStatus", fetch = FetchType.EAGER)
    private List<Estudiantes> estudiantesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusIdStatus", fetch = FetchType.EAGER)
    private List<Usuarios> usuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusIdStatus", fetch = FetchType.EAGER)
    private List<Secciones> seccionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusIdStatus", fetch = FetchType.EAGER)
    private List<Asignaturas> asignaturasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusIdStatus", fetch = FetchType.EAGER)
    private List<Docentes> docentesList;

    public Status() {
    }

    public Status(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public Status(Integer idStatus, String descripcion) {
        this.idStatus = idStatus;
        this.descripcion = descripcion;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Periodo> getPeriodoList() {
        return periodoList;
    }

    public void setPeriodoList(List<Periodo> periodoList) {
        this.periodoList = periodoList;
    }

    @XmlTransient
    public List<Estudiantes> getEstudiantesList() {
        return estudiantesList;
    }

    public void setEstudiantesList(List<Estudiantes> estudiantesList) {
        this.estudiantesList = estudiantesList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @XmlTransient
    public List<Secciones> getSeccionesList() {
        return seccionesList;
    }

    public void setSeccionesList(List<Secciones> seccionesList) {
        this.seccionesList = seccionesList;
    }

    @XmlTransient
    public List<Asignaturas> getAsignaturasList() {
        return asignaturasList;
    }

    public void setAsignaturasList(List<Asignaturas> asignaturasList) {
        this.asignaturasList = asignaturasList;
    }

    @XmlTransient
    public List<Docentes> getDocentesList() {
        return docentesList;
    }

    public void setDocentesList(List<Docentes> docentesList) {
        this.docentesList = docentesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatus != null ? idStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.idStatus == null && other.idStatus != null) || (this.idStatus != null && !this.idStatus.equals(other.idStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Status[ idStatus=" + idStatus + " ]";
    }
    
}
