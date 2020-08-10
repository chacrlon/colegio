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
@Table(name = "asignaturas",uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_asignatura"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignaturas.findAll", query = "SELECT a FROM Asignaturas a")
    , @NamedQuery(name = "Asignaturas.findByIdAsignatura", query = "SELECT a FROM Asignaturas a WHERE a.idAsignatura = :idAsignatura")
    , @NamedQuery(name = "Asignaturas.findByCodigo", query = "SELECT a FROM Asignaturas a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Asignaturas.findByNombre", query = "SELECT a FROM Asignaturas a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Asignaturas.findByMinimo", query = "SELECT a FROM Asignaturas a WHERE a.minimo = :minimo")
    , @NamedQuery(name = "Asignaturas.findByMaximo", query = "SELECT a FROM Asignaturas a WHERE a.maximo = :maximo")})
public class Asignaturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asignatura", nullable = false)
    private Integer idAsignatura;
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
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double minimo;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double maximo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignaturasIdAsignatura", fetch = FetchType.EAGER)
    private List<PlanEvaluacion> planEvaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignaturasIdAsignatura", fetch = FetchType.EAGER)
    private List<PaquetesMaterias> paquetesMateriasList;
    @JoinColumn(name = "status_id_status", referencedColumnName = "id_status", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Status statusIdStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignaturasIdAsignatura", fetch = FetchType.EAGER)
    private List<DocentesMaterias> docentesMateriasList;

    public Asignaturas() {
    }

    public Asignaturas(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Asignaturas(Integer idAsignatura, String codigo, String nombre, double minimo, double maximo) {
        this.idAsignatura = idAsignatura;
        this.codigo = codigo;
        this.nombre = nombre;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
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

    public double getMinimo() {
        return minimo;
    }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    public double getMaximo() {
        return maximo;
    }

    public void setMaximo(double maximo) {
        this.maximo = maximo;
    }

    @XmlTransient
    public List<PlanEvaluacion> getPlanEvaluacionList() {
        return planEvaluacionList;
    }

    public void setPlanEvaluacionList(List<PlanEvaluacion> planEvaluacionList) {
        this.planEvaluacionList = planEvaluacionList;
    }

    @XmlTransient
    public List<PaquetesMaterias> getPaquetesMateriasList() {
        return paquetesMateriasList;
    }

    public void setPaquetesMateriasList(List<PaquetesMaterias> paquetesMateriasList) {
        this.paquetesMateriasList = paquetesMateriasList;
    }

    public Status getStatusIdStatus() {
        return statusIdStatus;
    }

    public void setStatusIdStatus(Status statusIdStatus) {
        this.statusIdStatus = statusIdStatus;
    }

    @XmlTransient
    public List<DocentesMaterias> getDocentesMateriasList() {
        return docentesMateriasList;
    }

    public void setDocentesMateriasList(List<DocentesMaterias> docentesMateriasList) {
        this.docentesMateriasList = docentesMateriasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignatura != null ? idAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignaturas)) {
            return false;
        }
        Asignaturas other = (Asignaturas) object;
        if ((this.idAsignatura == null && other.idAsignatura != null) || (this.idAsignatura != null && !this.idAsignatura.equals(other.idAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Asignaturas[ idAsignatura=" + idAsignatura + " ]";
    }
    
}
