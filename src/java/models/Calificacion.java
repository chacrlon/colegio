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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author G L703
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_calificacion"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c")
    , @NamedQuery(name = "Calificacion.findByIdCalificacion", query = "SELECT c FROM Calificacion c WHERE c.idCalificacion = :idCalificacion")
    , @NamedQuery(name = "Calificacion.findByCalificacion", query = "SELECT c FROM Calificacion c WHERE c.calificacion = :calificacion")
    , @NamedQuery(name = "Calificacion.findByFechaCarga", query = "SELECT c FROM Calificacion c WHERE c.fechaCarga = :fechaCarga")})
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calificacion", nullable = false)
    private Integer idCalificacion;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double calificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(name = "fecha_carga", nullable = false, length = 99)
    private String fechaCarga;
    @JoinColumn(name = "docentes_id_docentes", referencedColumnName = "id_docentes", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Docentes docentesIdDocentes;
    @JoinColumn(name = "plan_evaluacion_id_plan_evaluacion", referencedColumnName = "id_plan_evaluacion", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PlanEvaluacion planEvaluacionIdPlanEvaluacion;

    public Calificacion() {
    }

    public Calificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Calificacion(Integer idCalificacion, double calificacion, String fechaCarga) {
        this.idCalificacion = idCalificacion;
        this.calificacion = calificacion;
        this.fechaCarga = fechaCarga;
    }

    public Integer getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(String fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Docentes getDocentesIdDocentes() {
        return docentesIdDocentes;
    }

    public void setDocentesIdDocentes(Docentes docentesIdDocentes) {
        this.docentesIdDocentes = docentesIdDocentes;
    }

    public PlanEvaluacion getPlanEvaluacionIdPlanEvaluacion() {
        return planEvaluacionIdPlanEvaluacion;
    }

    public void setPlanEvaluacionIdPlanEvaluacion(PlanEvaluacion planEvaluacionIdPlanEvaluacion) {
        this.planEvaluacionIdPlanEvaluacion = planEvaluacionIdPlanEvaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalificacion != null ? idCalificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.idCalificacion == null && other.idCalificacion != null) || (this.idCalificacion != null && !this.idCalificacion.equals(other.idCalificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Calificacion[ idCalificacion=" + idCalificacion + " ]";
    }
    
}
