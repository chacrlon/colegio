/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
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
@Table(name = "usuarios_roles", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_usuarios_roles"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosRoles.findAll", query = "SELECT u FROM UsuariosRoles u")
    , @NamedQuery(name = "UsuariosRoles.findByIdUsuariosRoles", query = "SELECT u FROM UsuariosRoles u WHERE u.idUsuariosRoles = :idUsuariosRoles")
    , @NamedQuery(name = "UsuariosRoles.findByDescripcion", query = "SELECT u FROM UsuariosRoles u WHERE u.descripcion = :descripcion")})
public class UsuariosRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuarios_roles", nullable = false)
    private Integer idUsuariosRoles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String descripcion;
    @JoinColumn(name = "usuarios_id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(cascade = CascadeType.REMOVE, optional = false, fetch = FetchType.EAGER)
    private Usuarios usuariosIdUsuario;

    public UsuariosRoles() {
    }

    public UsuariosRoles(Integer idUsuariosRoles) {
        this.idUsuariosRoles = idUsuariosRoles;
    }

    public UsuariosRoles(Integer idUsuariosRoles, String descripcion) {
        this.idUsuariosRoles = idUsuariosRoles;
        this.descripcion = descripcion;
    }

    public Integer getIdUsuariosRoles() {
        return idUsuariosRoles;
    }

    public void setIdUsuariosRoles(Integer idUsuariosRoles) {
        this.idUsuariosRoles = idUsuariosRoles;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idUsuariosRoles != null ? idUsuariosRoles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosRoles)) {
            return false;
        }
        UsuariosRoles other = (UsuariosRoles) object;
        if ((this.idUsuariosRoles == null && other.idUsuariosRoles != null) || (this.idUsuariosRoles != null && !this.idUsuariosRoles.equals(other.idUsuariosRoles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.UsuariosRoles[ idUsuariosRoles=" + idUsuariosRoles + " ]";
    }
    
}
