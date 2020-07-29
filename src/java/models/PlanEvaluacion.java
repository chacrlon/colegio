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
@Table(name = "plan_evaluacion", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_plan_evaluacion"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanEvaluacion.findAll", query = "SELECT p FROM PlanEvaluacion p")
    , @NamedQuery(name = "PlanEvaluacion.findByIdPlanEvaluacion", query = "SELECT p FROM PlanEvaluacion p WHERE p.idPlanEvaluacion = :idPlanEvaluacion")
    , @NamedQuery(name = "PlanEvaluacion.findByNumero", query = "SELECT p FROM PlanEvaluacion p WHERE p.numero = :numero")
    , @NamedQuery(name = "PlanEvaluacion.findByTitulo", query = "SELECT p FROM PlanEvaluacion p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "PlanEvaluacion.findByEscala", query = "SELECT p FROM PlanEvaluacion p WHERE p.escala = :escala")
    , @NamedQuery(name = "PlanEvaluacion.findByPeso", query = "SELECT p FROM PlanEvaluacion p WHERE p.peso = :peso")})
public class PlanEvaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_plan_evaluacion", nullable = false)
    private Integer idPlanEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int escala;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int peso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planEvaluacionIdPlanEvaluacion", fetch = FetchType.EAGER)
    private List<Calificacion> calificacionList;
    @JoinColumn(name = "asignaturas_id_asignatura", referencedColumnName = "id_asignatura", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Asignaturas asignaturasIdAsignatura;

    public PlanEvaluacion() {
    }

    public PlanEvaluacion(Integer idPlanEvaluacion) {
        this.idPlanEvaluacion = idPlanEvaluacion;
    }

    public PlanEvaluacion(Integer idPlanEvaluacion, int numero, String titulo, int escala, int peso) {
        this.idPlanEvaluacion = idPlanEvaluacion;
        this.numero = numero;
        this.titulo = titulo;
        this.escala = escala;
        this.peso = peso;
    }

    public Integer getIdPlanEvaluacion() {
        return idPlanEvaluacion;
    }

    public void setIdPlanEvaluacion(Integer idPlanEvaluacion) {
        this.idPlanEvaluacion = idPlanEvaluacion;
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

    @XmlTransient
    public List<Calificacion> getCalificacionList() {
        return calificacionList;
    }

    public void setCalificacionList(List<Calificacion> calificacionList) {
        this.calificacionList = calificacionList;
    }

    public Asignaturas getAsignaturasIdAsignatura() {
        return asignaturasIdAsignatura;
    }

    public void setAsignaturasIdAsignatura(Asignaturas asignaturasIdAsignatura) {
        this.asignaturasIdAsignatura = asignaturasIdAsignatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlanEvaluacion != null ? idPlanEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanEvaluacion)) {
            return false;
        }
        PlanEvaluacion other = (PlanEvaluacion) object;
        if ((this.idPlanEvaluacion == null && other.idPlanEvaluacion != null) || (this.idPlanEvaluacion != null && !this.idPlanEvaluacion.equals(other.idPlanEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.PlanEvaluacion[ idPlanEvaluacion=" + idPlanEvaluacion + " ]";
    }
    
}
