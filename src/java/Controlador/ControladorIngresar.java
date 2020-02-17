package Controlador;


import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.Usuarios;
import Modelo.UsuariosCRUD;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControladorIngresar extends HttpServlet {

    Usuarios us= new Usuarios();
    UsuariosCRUD usCRUD= new UsuariosCRUD();
    Conexion con= new Conexion();       
     int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession sesion = request.getSession();
        String accion = request.getParameter("accion");
        String tipo_usuario="";

        if (accion.equalsIgnoreCase("Ingresar")) {
            String nick = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            us = usCRUD.validar(nick, pass);
            if (us.getNick() != null) {
                
                sesion.setAttribute("usuario", us);
                Usuarios user = (Usuarios) sesion.getAttribute("usuario");
                if (user.getTipo_u() == 1) {
                    request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                }
                if (user.getTipo_u() == 2) {
                    request.getRequestDispatcher("ControladorDocente?menu=Principal").forward(request, response);
                }
                if (user.getTipo_u() == 3) {
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
