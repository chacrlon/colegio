/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author G L703
 */
public class ConstantesUtils {

    public static class RolesList {

        private static final String ADMINISTRADOR = "Administrador";
        private static final String DOCENTE = "Docente";
        private static final String ESTUDIANTE = "Estudiante";

        public static List<String> getRolesList() {
            try {
                List<String> rolesList = new ArrayList(Arrays.asList(ADMINISTRADOR, DOCENTE, ESTUDIANTE));
                return rolesList;
            } catch (Exception e) {
                e.getStackTrace();
                return null;
            }
        }

    }

    public static class MensajesList {

        public static final String ADVERTENCIA = "Advertencia";
        public static final String ERROR = "Error";
        public static final String EXITO = "Éxito";

    }
}
