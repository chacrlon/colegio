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
    @UniqueConstraint(columnNames = {"id_docentes"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docentes.findAll", query = "SELECT d FROM Docentes d")
    , @NamedQuery(name = "Docentes.findByIdDocentes", query = "SELECT d FROM Docentes d WHERE d.idDocentes = :idDocentes")
    , @NamedQuery(name = "Docentes.findByNombre1", query = "SELECT d FROM Docentes d WHERE d.nombre1 = :nombre1")
    , @NamedQuery(name = "Docentes.findByNombre2", query = "SELECT d FROM Docentes d WHERE d.nombre2 = :nombre2")
    , @NamedQuery(name = "Docentes.findByApellido1", query = "SELECT d FROM Docentes d WHERE d.apellido1 = :apellido1")
    , @NamedQuery(name = "Docentes.findByApellido2", query = "SELECT d FROM Docentes d WHERE d.apellido2 = :apellido2")
    , @NamedQuery(name = "Docentes.findByCedula", query = "SELECT d FROM Docentes d WHERE d.cedula = :cedula")
    , @NamedQuery(name = "Docentes.findBySexo", query = "SELECT d FROM Docentes d WHERE d.sexo = :sexo")
    , @NamedQuery(name = "Docentes.findByFecha", query = "SELECT d FROM Docentes d WHERE d.fecha = :fecha")
    , @NamedQuery(name = "Docentes.findByNacionalidad", query = "SELECT d FROM Docentes d WHERE d.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Docentes.findByCelular", query = "SELECT d FROM Docentes d WHERE d.celular = :celular")
    , @NamedQuery(name = "Docentes.findByTelefono", query = "SELECT d FROM Docentes d WHERE d.telefono = :telefono")
    , @NamedQuery(name = "Docentes.findByCorreo", query = "SELECT d FROM Docentes d WHERE d.correo = :correo")
    , @NamedQuery(name = "Docentes.findByDireccion", query = "SELECT d FROM Docentes d WHERE d.direccion = :direccion")})
public class Docentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_docentes", nullable = false)
    private Integer idDocentes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String nombre1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String nombre2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String apellido1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String apellido2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String nacionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docentesIdDocentes", fetch = FetchType.EAGER)
    private List<Calificacion> calificacionList;
    @JoinColumn(name = "usuarios_id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuarios usuariosIdUsuario;
    @JoinColumn(name = "status_id_status", referencedColumnName = "id_status", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Status statusIdStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docentesIdDocentes", fetch = FetchType.EAGER)
    private List<DocentesMaterias> docentesMateriasList;

    public Docentes() {
    }

    public Docentes(Integer idDocentes) {
        this.idDocentes = idDocentes;
    }

    public Docentes(Integer idDocentes, String nombre1, String nombre2, String apellido1, String apellido2, String cedula, String sexo, String fecha, String nacionalidad, String celular, String telefono, String correo, String direccion) {
        this.idDocentes = idDocentes;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.cedula = cedula;
        this.sexo = sexo;
        this.fecha = fecha;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Integer getIdDocentes() {
        return idDocentes;
    }

    public void setIdDocentes(Integer idDocentes) {
        this.idDocentes = idDocentes;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public List<Calificacion> getCalificacionList() {
        return calificacionList;
    }

    public void setCalificacionList(List<Calificacion> calificacionList) {
        this.calificacionList = calificacionList;
    }

    public Usuarios getUsuariosIdUsuario() {
        return usuariosIdUsuario;
    }

    public void setUsuariosIdUsuario(Usuarios usuariosIdUsuario) {
        this.usuariosIdUsuario = usuariosIdUsuario;
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
        hash += (idDocentes != null ? idDocentes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docentes)) {
            return false;
        }
        Docentes other = (Docentes) object;
        if ((this.idDocentes == null && other.idDocentes != null) || (this.idDocentes != null && !this.idDocentes.equals(other.idDocentes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Docentes[ idDocentes=" + idDocentes + " ]";
    }
    
}
