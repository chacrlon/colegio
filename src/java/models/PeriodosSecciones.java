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
@Table(name = "periodos_secciones", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_periodos_secciones"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeriodosSecciones.findAll", query = "SELECT p FROM PeriodosSecciones p")
    , @NamedQuery(name = "PeriodosSecciones.findByIdPeriodosSecciones", query = "SELECT p FROM PeriodosSecciones p WHERE p.idPeriodosSecciones = :idPeriodosSecciones")})
public class PeriodosSecciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_periodos_secciones", nullable = false)
    private Integer idPeriodosSecciones;
    @JoinColumn(name = "periodo_id_periodo", referencedColumnName = "id_periodo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Periodo periodoIdPeriodo;
    @JoinColumn(name = "secciones_id_seccion", referencedColumnName = "id_seccion", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Secciones seccionesIdSeccion;

    public PeriodosSecciones() {
    }

    public PeriodosSecciones(Integer idPeriodosSecciones) {
        this.idPeriodosSecciones = idPeriodosSecciones;
    }

    public Integer getIdPeriodosSecciones() {
        return idPeriodosSecciones;
    }

    public void setIdPeriodosSecciones(Integer idPeriodosSecciones) {
        this.idPeriodosSecciones = idPeriodosSecciones;
    }

    public Periodo getPeriodoIdPeriodo() {
        return periodoIdPeriodo;
    }

    public void setPeriodoIdPeriodo(Periodo periodoIdPeriodo) {
        this.periodoIdPeriodo = periodoIdPeriodo;
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
        hash += (idPeriodosSecciones != null ? idPeriodosSecciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodosSecciones)) {
            return false;
        }
        PeriodosSecciones other = (PeriodosSecciones) object;
        if ((this.idPeriodosSecciones == null && other.idPeriodosSecciones != null) || (this.idPeriodosSecciones != null && !this.idPeriodosSecciones.equals(other.idPeriodosSecciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.PeriodosSecciones[ idPeriodosSecciones=" + idPeriodosSecciones + " ]";
    }
    
}
