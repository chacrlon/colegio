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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author G L703
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicaciones.findAll", query = "SELECT p FROM Publicaciones p")
    , @NamedQuery(name = "Publicaciones.findByIdPublicacion", query = "SELECT p FROM Publicaciones p WHERE p.idPublicacion = :idPublicacion")
    , @NamedQuery(name = "Publicaciones.findByTitulo", query = "SELECT p FROM Publicaciones p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Publicaciones.findByMensaje", query = "SELECT p FROM Publicaciones p WHERE p.mensaje = :mensaje")
    , @NamedQuery(name = "Publicaciones.findByFecha", query = "SELECT p FROM Publicaciones p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Publicaciones.findByHora", query = "SELECT p FROM Publicaciones p WHERE p.hora = :hora")})
public class Publicaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_publicacion", nullable = false)
    private Integer idPublicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String mensaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(nullable = false, length = 99)
    private String hora;

    public Publicaciones() {
    }

    public Publicaciones(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Publicaciones(Integer idPublicacion, String titulo, String mensaje, String fecha, String hora) {
        this.idPublicacion = idPublicacion;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPublicacion != null ? idPublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicaciones)) {
            return false;
        }
        Publicaciones other = (Publicaciones) object;
        if ((this.idPublicacion == null && other.idPublicacion != null) || (this.idPublicacion != null && !this.idPublicacion.equals(other.idPublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Publicaciones[ idPublicacion=" + idPublicacion + " ]";
    }
    
}
