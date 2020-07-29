package Controlador;


import BD.Conexion;
import java.util.List;
import Modelo.Usuarios;
import Modelo.UsuariosCRUD;
import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Status;
import persistence.StatusFacadeLocal;
import persistence.UsuariosFacadeLocal;
import utils.ListRolesUsuariosUtil;

public class ControladorIngresar extends HttpServlet {
        @EJB
        private StatusFacadeLocal statusFacade;
         @EJB
        private UsuariosFacadeLocal usuariosFacade;
    Usuarios us= new Usuarios();
    UsuariosCRUD usCRUD= new UsuariosCRUD();
    Conexion con= new Conexion();       
     int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession sesion = request.getSession();
        String accion = request.getParameter("accion");
        String tipo_usuario="";
           List<Status> status = statusFacade.findAll();
        if (accion.equalsIgnoreCase("Ingresar")) {
            String nick = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            models.Usuarios usuario= usuariosFacade.findByNickPass(nick, pass);
            us = usCRUD.validar(nick, pass);
            if (us.getNick() != null) {
                
                sesion.setAttribute("usuario", usuario);
                models.Usuarios user = (models.Usuarios) sesion.getAttribute("usuario");
                List<models.Usuarios> listita= new ArrayList();
                if(user != null){
                    
                listita.add(user);
                    ListRolesUsuariosUtil.setUsuariosRolesString(listita);
                }
                if (listita.get(0).getRolesString().contains("Administrador")) {
                    request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                }
                else if (listita.get(0).getRolesString().contains("siguiente rol")) {
                    request.getRequestDispatcher("ControladorDocente?menu=Principal").forward(request, response);
                }
                else if (listita.get(0).getRolesString().contains("siguiente rol")) {
                    request.getRequestDispatcher("ControladorEstudiante?menu=Principal").forward(request, response);
                }
                
                
                
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        } 

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
