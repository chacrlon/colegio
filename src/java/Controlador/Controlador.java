package Controlador;

import Modelo.Administrador;
import Modelo.AdministradorCRUD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {
    
        
        Administrador admin=new Administrador();
        AdministradorCRUD adminCRUD=new AdministradorCRUD();
        int ida;
        
        

 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        if (menu.equals("Administrador")) {
            //request.getRequestDispatcher("admin.jsp").forward(request, response);
            switch (accion) {
                case "Listar":
                   List lista = adminCRUD.listar();
                   request.setAttribute("Administradores", lista);
                   request.getRequestDispatcher("admin.jsp").forward(request, response);
                break;
                case "Agregar":
                    String nombre1=request.getParameter("nombre1");
                    String nombre2=request.getParameter("nombre2");
                    String apellido1=request.getParameter("apellido1");
                    String apellido2=request.getParameter("apellido2");
                    String cedula=request.getParameter("cedula");
                    String sexo=request.getParameter("sexo");
                    String fecha=request.getParameter("fecha");
                    String nacionalidad=request.getParameter("nacionalidad");
                    String celular=request.getParameter("celular");
                    String telefono=request.getParameter("telefono");
                    String correo=request.getParameter("correo");
                    String direccion=request.getParameter("direccion");
                    String estatus=request.getParameter("estatus");
                    admin.setNombre1(nombre1);
                    admin.setNombre2(nombre2);
                    admin.setApellido1(apellido1);
                    admin.setApellido2(apellido2);
                    admin.setCedula(cedula);
                    admin.setSexo(sexo);
                    admin.setFecha(fecha);
                    admin.setNacionalidad(nacionalidad);
                    admin.setCelular(celular);
                    admin.setTelefono(telefono);
                    admin.setCorreo(correo);
                    admin.setDireccion(direccion);
                    admin.setEstatus(estatus);
                    adminCRUD.agregar(admin);
                    request.getRequestDispatcher("Controlador?menu=Administrador&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ida=Integer.parseInt(request.getParameter("id"));
                    Administrador a=adminCRUD.listarId(ida);
                    request.setAttribute("administrador", a);
                    request.getRequestDispatcher("Controlador?menu=Administrador&accion=Listar&#new").forward(request, response);                    
                break;
                case "Actualizar":
                    String nombre1_a=request.getParameter("nombre1");
                    String nombre2_a=request.getParameter("nombre2");
                    String apellido1_a=request.getParameter("apellido1");
                    String apellido2_a=request.getParameter("apellido2");
                    String cedula_a=request.getParameter("cedula");
                    String sexo_a=request.getParameter("sexo");
                    String fecha_a=request.getParameter("fecha");
                    String nacionalidad_a=request.getParameter("nacionalidad");
                    String celular_a=request.getParameter("celular");
                    String telefono_a=request.getParameter("telefono");
                    String correo_a=request.getParameter("correo");
                    String direccion_a=request.getParameter("direccion");
                    String estatus_a=request.getParameter("estatus");
                    admin.setNombre1(nombre1_a);
                    admin.setNombre2(nombre2_a);
                    admin.setApellido1(apellido1_a);
                    admin.setApellido2(apellido2_a);
                    admin.setCedula(cedula_a);
                    admin.setSexo(sexo_a);
                    admin.setFecha(fecha_a);
                    admin.setNacionalidad(nacionalidad_a);
                    admin.setCelular(celular_a);
                    admin.setTelefono(telefono_a);
                    admin.setCorreo(correo_a);
                    admin.setDireccion(direccion_a);
                    admin.setEstatus(estatus_a);
                    admin.setId_p_a(ida);
                    adminCRUD.actualizar(admin);
                    request.getRequestDispatcher("Controlador?menu=Administrador&accion=Listar").forward(request, response);                    
                break;
                case "Eliminar":
                ida=Integer.parseInt(request.getParameter("id"));
                adminCRUD.delete(ida);
                request.getRequestDispatcher("Controlador?menu=Administrador&accion=Listar").forward(request, response);                    
                break;
                default:
                    throw new AssertionError();
            }
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

