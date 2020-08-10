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
@Table(name="estudiantes",uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_estudiantes"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e")
    , @NamedQuery(name = "Estudiantes.findByIdEstudiantes", query = "SELECT e FROM Estudiantes e WHERE e.idEstudiantes = :idEstudiantes")
    , @NamedQuery(name = "Estudiantes.findByNombre1", query = "SELECT e FROM Estudiantes e WHERE e.nombre1 = :nombre1")
    , @NamedQuery(name = "Estudiantes.findByNombre2", query = "SELECT e FROM Estudiantes e WHERE e.nombre2 = :nombre2")
    , @NamedQuery(name = "Estudiantes.findByApellido1", query = "SELECT e FROM Estudiantes e WHERE e.apellido1 = :apellido1")
    , @NamedQuery(name = "Estudiantes.findByApellido2", query = "SELECT e FROM Estudiantes e WHERE e.apellido2 = :apellido2")
    , @NamedQuery(name = "Estudiantes.findByCedula", query = "SELECT e FROM Estudiantes e WHERE e.cedula = :cedula")
    , @NamedQuery(name = "Estudiantes.findBySexo", query = "SELECT e FROM Estudiantes e WHERE e.sexo = :sexo")
    , @NamedQuery(name = "Estudiantes.findByFecha", query = "SELECT e FROM Estudiantes e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "Estudiantes.findByNacionalidad", query = "SELECT e FROM Estudiantes e WHERE e.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Estudiantes.findByCelular", query = "SELECT e FROM Estudiantes e WHERE e.celular = :celular")
    , @NamedQuery(name = "Estudiantes.findByTelefono", query = "SELECT e FROM Estudiantes e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Estudiantes.findByCorreo", query = "SELECT e FROM Estudiantes e WHERE e.correo = :correo")
    , @NamedQuery(name = "Estudiantes.findByDireccion", query = "SELECT e FROM Estudiantes e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Estudiantes.findByProcedencia", query = "SELECT e FROM Estudiantes e WHERE e.procedencia = :procedencia")
    , @NamedQuery(name = "Estudiantes.findByAnio", query = "SELECT e FROM Estudiantes e WHERE e.anio = :anio")
    , @NamedQuery(name = "Estudiantes.findByCedulaR", query = "SELECT e FROM Estudiantes e WHERE e.cedulaR = :cedulaR")})
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estudiantes", nullable = false)
    private Integer idEstudiantes;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String procedencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String anio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(name = "cedula_r", nullable = false, length = 99)
    private String cedulaR;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiantesIdPE", fetch = FetchType.EAGER)
    private List<EstudiantesSecciones> estudiantesSeccionesList;
    @JoinColumn(name = "status_id_status", referencedColumnName = "id_status", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Status statusIdStatus;
    @JoinColumn(name = "usuarios_id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuarios usuariosIdUsuario;

    public Estudiantes() {
    }

    public Estudiantes(Integer idEstudiantes) {
        this.idEstudiantes = idEstudiantes;
    }

    public Estudiantes(Integer idEstudiantes, String nombre1, String nombre2, String apellido1, String apellido2, String cedula, String sexo, String fecha, String nacionalidad, String celular, String telefono, String correo, String direccion, String procedencia, String anio, String cedulaR) {
        this.idEstudiantes = idEstudiantes;
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
        this.procedencia = procedencia;
        this.anio = anio;
        this.cedulaR = cedulaR;
    }

    public Integer getIdEstudiantes() {
        return idEstudiantes;
    }

    public void setIdEstudiantes(Integer idEstudiantes) {
        this.idEstudiantes = idEstudiantes;
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

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getCedulaR() {
        return cedulaR;
    }

    public void setCedulaR(String cedulaR) {
        this.cedulaR = cedulaR;
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

    public Usuarios getUsuariosIdUsuario() {
        return usuariosIdUsuario;
    }

    public void setUsuariosIdUsuario(Usuarios usuariosIdUsuario) {
        this.usuariosIdUsuario = usuariosIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudiantes != null ? idEstudiantes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.idEstudiantes == null && other.idEstudiantes != null) || (this.idEstudiantes != null && !this.idEstudiantes.equals(other.idEstudiantes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Estudiantes[ idEstudiantes=" + idEstudiantes + " ]";
    }
    
}
