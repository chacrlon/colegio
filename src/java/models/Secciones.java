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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_seccion"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secciones.findAll", query = "SELECT s FROM Secciones s")
    , @NamedQuery(name = "Secciones.findByIdSeccion", query = "SELECT s FROM Secciones s WHERE s.idSeccion = :idSeccion")
    , @NamedQuery(name = "Secciones.findByCodigo", query = "SELECT s FROM Secciones s WHERE s.codigo = :codigo")
    , @NamedQuery(name = "Secciones.findByNombre", query = "SELECT s FROM Secciones s WHERE s.nombre = :nombre")})
public class Secciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_seccion", nullable = false)
    private Integer idSeccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seccionesIdSeccion", fetch = FetchType.EAGER)
    private List<EstudiantesSecciones> estudiantesSeccionesList;
    @JoinColumn(name = "status_id_status", referencedColumnName = "id_status", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Status statusIdStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seccionIdSeccion", fetch = FetchType.EAGER)
    private List<PaquetesMaterias> paquetesMateriasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seccionesIdSeccion", fetch = FetchType.EAGER)
    private List<PeriodosSecciones> periodosSeccionesList;

    public Secciones() {
    }

    public Secciones(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Secciones(Integer idSeccion, String codigo, String nombre) {
        this.idSeccion = idSeccion;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
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

    @XmlTransient
    public List<EstudiantesSecciones> getEstudiantesSeccionesList() {
        return estudiantesSeccionesList;
    }

    public void setEstudiantesSeccionesList(List<EstudiantesSecciones> estudiantesSeccionesList) {
        this.estudiantesSeccionesList = estudiantesSeccionesList;
    }

    public Status getStatusIdStatus() {
        return statusIdStatus;
    }

    public void setStatusIdStatus(Status statusIdStatus) {
        this.statusIdStatus = statusIdStatus;
    }

    @XmlTransient
    public List<PaquetesMaterias> getPaquetesMateriasList() {
        return paquetesMateriasList;
    }

    public void setPaquetesMateriasList(List<PaquetesMaterias> paquetesMateriasList) {
        this.paquetesMateriasList = paquetesMateriasList;
    }

    @XmlTransient
    public List<PeriodosSecciones> getPeriodosSeccionesList() {
        return periodosSeccionesList;
    }

    public void setPeriodosSeccionesList(List<PeriodosSecciones> periodosSeccionesList) {
        this.periodosSeccionesList = periodosSeccionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeccion != null ? idSeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secciones)) {
            return false;
        }
        Secciones other = (Secciones) object;
        if ((this.idSeccion == null && other.idSeccion != null) || (this.idSeccion != null && !this.idSeccion.equals(other.idSeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Secciones[ idSeccion=" + idSeccion + " ]";
    }
    
}
