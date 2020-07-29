/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.UsuariosRoles;

/**
 *
 * @author G L703
 */
@Stateless
public class UsuariosRolesFacade extends AbstractFacade<UsuariosRoles> implements UsuariosRolesFacadeLocal {

    @PersistenceContext(unitName = "colegioUP")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosRolesFacade() {
        super(UsuariosRoles.class);
    }

    @Override
    public Boolean userHasRol(Integer userId, String rolDescription) {
        try {
            UsuariosRoles ur = em.createQuery("SELECT ur FROM UsuariosRoles ur WHERE ur.usuariosIdUsuario = :userId AND ur.descripcion = :rolDescription", UsuariosRoles.class)
                    .setParameter("userId", userId).setParameter("rolDescription", rolDescription).getSingleResult();
            if (ur != null) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }
    

}
