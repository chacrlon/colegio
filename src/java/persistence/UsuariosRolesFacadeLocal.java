/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import models.UsuariosRoles;

/**
 *
 * @author G L703
 */
@Local
public interface UsuariosRolesFacadeLocal {

    void create(UsuariosRoles usuariosRoles);

    void edit(UsuariosRoles usuariosRoles);

    void remove(UsuariosRoles usuariosRoles);

    UsuariosRoles find(Object id);

    List<UsuariosRoles> findAll();

    List<UsuariosRoles> findRange(int[] range);

    int count();
    public Boolean userHasRol(Integer userId, String rolDescription);
}
