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
@Table(name = "docentes_materias", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_docentes_materias"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocentesMaterias.findAll", query = "SELECT d FROM DocentesMaterias d")
    , @NamedQuery(name = "DocentesMaterias.findByIdDocentesMaterias", query = "SELECT d FROM DocentesMaterias d WHERE d.idDocentesMaterias = :idDocentesMaterias")})
public class DocentesMaterias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_docentes_materias", nullable = false)
    private Integer idDocentesMaterias;
    @JoinColumn(name = "asignaturas_id_asignatura", referencedColumnName = "id_asignatura", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Asignaturas asignaturasIdAsignatura;
    @JoinColumn(name = "docentes_id_docentes", referencedColumnName = "id_docentes", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Docentes docentesIdDocentes;

    public DocentesMaterias() {
    }

    public DocentesMaterias(Integer idDocentesMaterias) {
        this.idDocentesMaterias = idDocentesMaterias;
    }

    public Integer getIdDocentesMaterias() {
        return idDocentesMaterias;
    }

    public void setIdDocentesMaterias(Integer idDocentesMaterias) {
        this.idDocentesMaterias = idDocentesMaterias;
    }

    public Asignaturas getAsignaturasIdAsignatura() {
        return asignaturasIdAsignatura;
    }

    public void setAsignaturasIdAsignatura(Asignaturas asignaturasIdAsignatura) {
        this.asignaturasIdAsignatura = asignaturasIdAsignatura;
    }

    public Docentes getDocentesIdDocentes() {
        return docentesIdDocentes;
    }

    public void setDocentesIdDocentes(Docentes docentesIdDocentes) {
        this.docentesIdDocentes = docentesIdDocentes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocentesMaterias != null ? idDocentesMaterias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocentesMaterias)) {
            return false;
        }
        DocentesMaterias other = (DocentesMaterias) object;
        if ((this.idDocentesMaterias == null && other.idDocentesMaterias != null) || (this.idDocentesMaterias != null && !this.idDocentesMaterias.equals(other.idDocentesMaterias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.DocentesMaterias[ idDocentesMaterias=" + idDocentesMaterias + " ]";
    }
    
}
