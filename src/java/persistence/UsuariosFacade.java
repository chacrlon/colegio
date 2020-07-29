/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Usuarios;

/**
 *
 * @author G L703
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "colegioUP")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    @Override
    public Usuarios findByNickPass(String nick, String pass) {
        try {
            Usuarios u = em.createQuery("SELECT u FROM Usuarios u where u.nick = :nick AND u.password = :pass", Usuarios.class)
                    .setParameter("nick", nick)
                    .setParameter("pass", pass)
                    .getSingleResult();
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean verifyUserExists(String nick) {
        try {
            List<Usuarios> u = em.createQuery("SELECT u FROM Usuarios u where u.nick = :nick", Usuarios.class)
                    .setParameter("nick", nick)
                    .getResultList();
            if (u != null && !u.isEmpty()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
