package Controlador;

import Modelo.Administrador;
import Modelo.AdministradorCRUD;
import Modelo.Anio;
import Modelo.AnioCRUD;
import Modelo.Asignatura;
import Modelo.AsignaturaCRUD;
import Modelo.Estudiante;
import Modelo.EstudianteCRUD;
import Modelo.Periodo;
import Modelo.PeriodoCRUD;
import Modelo.Seccion;
import Modelo.SeccionCRUD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {
    
        int ida, idp, id_anio, id_seccion, id_asignatura;
             
        Periodo periodo=new Periodo();
        PeriodoCRUD periodoCRUD=new PeriodoCRUD();
        List<Periodo> lista = new ArrayList<>();
        
        Anio anio=new Anio();
        AnioCRUD anioCRUD=new AnioCRUD();
        
        Seccion seccion=new Seccion();
        SeccionCRUD seccionCRUD=new SeccionCRUD();
        
        Asignatura asignatura=new Asignatura();
        AsignaturaCRUD asignaturaCRUD=new AsignaturaCRUD();
        
        Estudiante estudiante=new Estudiante();
        EstudianteCRUD estudianteCRUD=new EstudianteCRUD();
                       
        Administrador admin=new Administrador();
        AdministradorCRUD adminCRUD=new AdministradorCRUD();              

        
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        String accionn = request.getParameter("accionn");
        String accionnn = request.getParameter("accionnn");
        String accio4 = request.getParameter("accio4");
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
                
                
                
                
                
                //ENTRAMOS EN LOS AÑOS DEL PERIODO AQUI
                case "Anio_Periodo":
                    switch (accionn) {
                case "Listar":
                   List listaa = anioCRUD.listar();
                   request.setAttribute("Anios", listaa);
                   request.getRequestDispatcher("anio_periodo.jsp").forward(request, response);
                break;
                case "Agregar":
                    String codigo_anio=request.getParameter("codigo_anio");
                    String nombre_anio=request.getParameter("nombre_anio");
                    String estatus_anio=request.getParameter("estatus_anio");
                    //int id_p_anio=Integer.parseInt(request.getParameter(idp));
                    anio.setCodigo(codigo_anio);
                    anio.setNombre(nombre_anio);
                    anio.setEstatus(estatus_anio);
                    
                    anioCRUD.agregarIDperiodo(anio);
                    request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Listar").forward(request, response);
                    break;
                case "Editar":
                    id_anio=Integer.parseInt(request.getParameter("id"));
                    Anio pea=anioCRUD.listarId(id_anio);
                    request.setAttribute("anio", pea);
                    request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Listar").forward(request, response);                    
                break;
                case "Actualizar":
                    String codigo_anio1=request.getParameter("codigo_anio");
                    String nombre_anio1=request.getParameter("nombre_anio");
                    String estatus_anio1=request.getParameter("estatus_anio");
                    
                    anio.setCodigo(codigo_anio1);
                    anio.setNombre(nombre_anio1);
                    anio.setEstatus(estatus_anio1);
                    
                    anio.setId_a(id_anio);
                    anioCRUD.actualizar(anio);
                    request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Listar").forward(request, response);                    
                break;
                case "Eliminar":
                id_anio=Integer.parseInt(request.getParameter("id"));
                anioCRUD.delete(id_anio);
                request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Listar").forward(request, response);                    
                break;
                
                
                
                
                
                //ENTRAMOS EN LAS SECCIONES DE CADA AÑO DEL PERIODO AQUI
                case "Seccion":
                    switch (accionnn) {
                case "Listar":
                   List listaaa = seccionCRUD.listar();
                   request.setAttribute("Secciones", listaaa);
                   request.getRequestDispatcher("seccion_anio_periodo.jsp").forward(request, response);
                break;
                case "Agregar":
                    String codigo_s=request.getParameter("codigo_s");
                    String nombre_s=request.getParameter("nombre_s");
                    String estatus_s=request.getParameter("estatus_s");
                    
                    seccion.setCodigo(codigo_s);
                    seccion.setNombre(nombre_s);
                    seccion.setEstatus(estatus_s);
                    
                    seccionCRUD.agregar(seccion);
                    request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Seccion&accionnn=Listar").forward(request, response);
                    break;
                case "Editar":
                    id_seccion=Integer.parseInt(request.getParameter("id"));
                    Seccion pes=seccionCRUD.listarId(id_seccion);
                    request.setAttribute("seccion", pes);
                    request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Seccion&accionnn=Listar").forward(request, response);                    
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
                    request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Seccion&accionnn=Listar").forward(request, response);                    
                break;
                case "Eliminar":
                id_seccion=Integer.parseInt(request.getParameter("id"));
                seccionCRUD.delete(id_seccion);
                request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Seccion&accionnn=Listar").forward(request, response);                    
                break;              
                
                
                
                
                
                //ENTRAMOS EN EL MODULO DE LOS ESTUDIANTES Y SUS LAPSOS
                case "Estudiantes_Lapsos":
                    switch (accio4) {
                case "Listar":
                   List list4 = estudianteCRUD.listar();
                   request.setAttribute("Estudiantesl", list4);
                   request.getRequestDispatcher("estudiantelapsos.jsp").forward(request, response);
                break;
                case "Asignar_Docente":
                   List list5 = estudianteCRUD.listar();
                   request.setAttribute("Estudiantesl", list5);
                   request.getRequestDispatcher("asignar_docente.jsp").forward(request, response);
                break;
                case "Historial":
                   List Historial = estudianteCRUD.listar();
                   request.setAttribute("Historiales", Historial);
                   request.getRequestDispatcher("historial.jsp").forward(request, response);
                break;
                case "Lapso1":
                   List lapso1 = estudianteCRUD.listar();
                   request.setAttribute("Lapsos1", lapso1);
                   request.getRequestDispatcher("lapso.jsp").forward(request, response);
                break;
                case "Lapso2":
                   List lapso2 = estudianteCRUD.listar();
                   request.setAttribute("Lapsos2", lapso2);
                   request.getRequestDispatcher("lapso.jsp").forward(request, response);
                break;
                case "Lapso3":
                   List lapso3 = estudianteCRUD.listar();
                   request.setAttribute("Lapsos3", lapso3);
                   request.getRequestDispatcher("lapso.jsp").forward(request, response);
                break;
                case "Final":
                   List finall = estudianteCRUD.listar();
                   request.setAttribute("Finales", finall);
                   request.getRequestDispatcher("lapso.jsp").forward(request, response);
                break;              
                default:
                    throw new AssertionError();
            }    
                    
                    
                    
                    
                    
                    
                    
                    
                default:
                    throw new AssertionError();
            }       
                
                
                
                
                
                
                
                
                default:
                    throw new AssertionError();
            }                            
                    
                    
                    
                    
                    
                    
                    
                    
                default:
                    throw new AssertionError();
            }          
        }
        if (menu.equals("Anio")) {
           
            switch (accion) {
                case "Listar":
                   List lista = anioCRUD.listar();
                   request.setAttribute("Anios", lista);
                   request.getRequestDispatcher("anio.jsp").forward(request, response);
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
                    id_anio=Integer.parseInt(request.getParameter("id"));
                    Anio pe=anioCRUD.listarId(id_anio);
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
                    
                    anio.setId_a(id_anio);
                    anioCRUD.actualizar(anio);
                    request.getRequestDispatcher("Controlador?menu=Anio&accion=Listar").forward(request, response);                    
                break;
                case "Eliminar":
                id_anio=Integer.parseInt(request.getParameter("id"));
                anioCRUD.delete(id_anio);
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
        if (menu.equals("Asignatura")) {
           
            switch (accion) {
                case "Listar":
                   List lista = asignaturaCRUD.listar();
                   request.setAttribute("Asignaturas", lista);
                   request.getRequestDispatcher("asignatura.jsp").forward(request, response);
                break;
                case "Agregar":
                    String codigo_asig=request.getParameter("codigo_asig");
                    String nombre_asig=request.getParameter("nombre_asig");
                    double minimo_asig=Double.parseDouble(request.getParameter("minimo_asig"));
                    double maximo_asig=Double.parseDouble(request.getParameter("maximo_asig"));
                    String estatus_asig=request.getParameter("estatus_asig");
                    
                    asignatura.setCodigo(codigo_asig);
                    asignatura.setNombre(nombre_asig);
                    asignatura.setMinimo(minimo_asig);
                    asignatura.setMaximo(maximo_asig);
                    asignatura.setEstatus(estatus_asig);
                    
                    asignaturaCRUD.agregar(asignatura);
                    request.getRequestDispatcher("Controlador?menu=Asignatura&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    id_asignatura=Integer.parseInt(request.getParameter("id"));
                    Asignatura pe=asignaturaCRUD.listarId(id_asignatura);
                    request.setAttribute("asignatura", pe);
                    request.getRequestDispatcher("Controlador?menu=Asignatura&accion=Listar").forward(request, response);                    
                break;
                case "Actualizar":
                    String codigo_asig1=request.getParameter("codigo_asig");
                    String nombre_asig1=request.getParameter("nombre_asig");
                    double minimo_asig1=Double.parseDouble(request.getParameter("minimo_asig"));
                    double maximo_asig1=Double.parseDouble(request.getParameter("maximo_asig"));
                    String estatus_asig1=request.getParameter("estatus_asig");
                    
                    asignatura.setCodigo(codigo_asig1);
                    asignatura.setNombre(nombre_asig1);
                    asignatura.setMinimo(minimo_asig1);
                    asignatura.setMaximo(maximo_asig1);
                    asignatura.setEstatus(estatus_asig1);
                    
                    asignatura.setId_a(id_asignatura);
                    asignaturaCRUD.actualizar(asignatura);
                    request.getRequestDispatcher("Controlador?menu=Asignatura&accion=Listar").forward(request, response);                    
                break;
                case "Eliminar":
                id_asignatura=Integer.parseInt(request.getParameter("id"));
                asignaturaCRUD.delete(id_asignatura);
                request.getRequestDispatcher("Controlador?menu=Asignatura&accion=Listar").forward(request, response);                    
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

