/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.List;
import models.Usuarios;
import models.UsuariosRoles;

/**
 *
 * @author G L703
 */
public class ListRolesUsuariosUtil {

    public static void setUsuariosRolesString(List<Usuarios> listaUsuarios) {
        try {

            if (listaUsuarios != null && !listaUsuarios.isEmpty()) {
                for (Usuarios lu : listaUsuarios) {
                    if (lu.getUsuariosRolesList() != null && !lu.getUsuariosRolesList().isEmpty()) {
                        StringBuilder sb = new StringBuilder();
                        for (UsuariosRoles ur : lu.getUsuariosRolesList()) {
                            if (ur.equals(lu.getUsuariosRolesList().get(lu.getUsuariosRolesList().size() - 1))) {
                                sb.append(ur.getDescripcion());
                            } else {
                                sb.append(ur.getDescripcion()).append(",");
                            }
                        }
                        lu.setRolesString(sb.toString());
                    }
                }
            }
        } catch (Exception e) {
        }
    }

}
