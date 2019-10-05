package Controlador;

import Modelo.Administrador;
import Modelo.AdministradorCRUD;
import Modelo.Año;
import Modelo.AñoCRUD;
import Modelo.Periodo;
import Modelo.PeriodoCRUD;
import Modelo.Seccion;
import Modelo.SeccionCRUD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {
    
        int ida, idp, id_año, id_seccion;
             
        Periodo periodo=new Periodo();
        PeriodoCRUD periodoCRUD=new PeriodoCRUD();
        
        Año anio=new Año();
        AñoCRUD anioCRUD=new AñoCRUD();
        
        Seccion seccion=new Seccion();
        SeccionCRUD seccionCRUD=new SeccionCRUD();
                       
        Administrador admin=new Administrador();
        AdministradorCRUD adminCRUD=new AdministradorCRUD();              

        
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        if (menu.equals("Periodo")) {
           
            switch (accion) {
                case "Listar":
                   List lista = periodoCRUD.listar();
                   request.setAttribute("Periodos", lista);
                   request.getRequestDispatcher("period.jsp").forward(request, response);
                break;
                case "Agregar":
                    String nombre_p=request.getParameter("nombre_p");
                    String fecha_inicio=request.getParameter("fecha_inicio");
                    String fecha_fin=request.getParameter("fecha_fin");
                    String estatus_p=request.getParameter("estatus_p");
                    
                    periodo.setNombre(nombre_p);
                    periodo.setFecha_i(fecha_inicio);
                    periodo.setFecha_f(fecha_fin);
                    periodo.setEstatus(estatus_p);
                    
                    periodoCRUD.agregar(periodo);
                    request.getRequestDispatcher("Controlador?menu=Periodo&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idp=Integer.parseInt(request.getParameter("id"));
                    Periodo pe=periodoCRUD.listarId(idp);
                    request.setAttribute("periodo", pe);
                    request.getRequestDispatcher("Controlador?menu=Periodo&accion=Listar").forward(request, response);                    
                break;
                case "Actualizar":
                    String nombre_p1=request.getParameter("nombre_p");
                    String fecha_inicio1=request.getParameter("fecha_inicio");
                    String fecha_fin1=request.getParameter("fecha_fin");
                    String estatus_p1=request.getParameter("estatus_p");
                    
                    periodo.setNombre(nombre_p1);
                    periodo.setFecha_i(fecha_inicio1);
                    periodo.setFecha_f(fecha_fin1);
                    periodo.setEstatus(estatus_p1);
                    
                    periodo.setId_p(idp);
                    periodoCRUD.actualizar(periodo);
                    request.getRequestDispatcher("Controlador?menu=Periodo&accion=Listar").forward(request, response);                    
                break;
                case "Eliminar":
                idp=Integer.parseInt(request.getParameter("id"));
                periodoCRUD.delete(idp);
                request.getRequestDispatcher("Controlador?menu=Periodo&accion=Listar").forward(request, response);                    
                break;
                default:
                    throw new AssertionError();
            }          
        }
        if (menu.equals("Anio")) {
           
            switch (accion) {
                case "Listar":
                   List lista = anioCRUD.listar();
                   request.setAttribute("Anios", lista);
                   request.getRequestDispatcher("año.jsp").forward(request, response);
                break;
                case "Agregar":
                    String codigo_anio=request.getParameter("codigo_anio");
                    String nombre_anio=request.getParameter("nombre_anio");
                    String estatus_anio=request.getParameter("estatus_anio");
                    
                    anio.setCodigo(codigo_anio);
                    anio.setNombre(nombre_anio);
                    anio.setEstatus(estatus_anio);
                    
                    anioCRUD.agregar(anio);
                    request.getRequestDispatcher("Controlador?menu=Anio&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    id_año=Integer.parseInt(request.getParameter("id"));
                    Año pe=anioCRUD.listarId(id_año);
                    request.setAttribute("anio", pe);
                    request.getRequestDispatcher("Controlador?menu=Anio&accion=Listar").forward(request, response);                    
                break;
                case "Actualizar":
                    String codigo_anio1=request.getParameter("codigo_anio");
                    String nombre_anio1=request.getParameter("nombre_anio");
                    String estatus_anio1=request.getParameter("estatus_anio");
                    
                    anio.setCodigo(codigo_anio1);
                    anio.setNombre(nombre_anio1);
                    anio.setEstatus(estatus_anio1);
                    
                    anio.setId_a(id_año);
                    anioCRUD.actualizar(anio);
                    request.getRequestDispatcher("Controlador?menu=Anio&accion=Listar").forward(request, response);                    
                break;
                case "Eliminar":
                id_año=Integer.parseInt(request.getParameter("id"));
                anioCRUD.delete(id_año);
                request.getRequestDispatcher("Controlador?menu=Anio&accion=Listar").forward(request, response);                    
                break;
                default:
                    throw new AssertionError();
            }          
        }
        if (menu.equals("Seccion")) {
           
            switch (accion) {
                case "Listar":
                   List lista = seccionCRUD.listar();
                   request.setAttribute("Secciones", lista);
                   request.getRequestDispatcher("section.jsp").forward(request, response);
                break;
                case "Agregar":
                    String codigo_s=request.getParameter("codigo_s");
                    String nombre_s=request.getParameter("nombre_s");
                    String estatus_s=request.getParameter("estatus_s");
                    
                    seccion.setCodigo(codigo_s);
                    seccion.setNombre(nombre_s);
                    seccion.setEstatus(estatus_s);
                    
                    seccionCRUD.agregar(seccion);
                    request.getRequestDispatcher("Controlador?menu=Seccion&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    id_seccion=Integer.parseInt(request.getParameter("id"));
                    Seccion pe=seccionCRUD.listarId(id_seccion);
                    request.setAttribute("seccion", pe);
                    request.getRequestDispatcher("Controlador?menu=Seccion&accion=Listar").forward(request, response);                    
                break;
                case "Actualizar":
                    String codigo_s1=request.getParameter("codigo_s");
                    String nombre_s1=request.getParameter("nombre_s");
                    String estatus_s1=request.getParameter("estatus_s");
                    
                    seccion.setCodigo(codigo_s1);
                    seccion.setNombre(nombre_s1);
                    seccion.setEstatus(estatus_s1);
                    
                    seccion.setId_s(id_seccion);
                    seccionCRUD.actualizar(seccion);
                    request.getRequestDispatcher("Controlador?menu=Seccion&accion=Listar").forward(request, response);                    
                break;
                case "Eliminar":
                id_seccion=Integer.parseInt(request.getParameter("id"));
                seccionCRUD.delete(id_seccion);
                request.getRequestDispatcher("Controlador?menu=Seccion&accion=Listar").forward(request, response);                    
                break;
                default:
                    throw new AssertionError();
            }          
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
                    request.getRequestDispatcher("Controlador?menu=Administrador&accion=Listar").forward(request, response);                    
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

