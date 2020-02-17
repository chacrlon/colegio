package Controlador;

import Modelo.Administrador;
import Modelo.AdministradorCRUD;
import Modelo.Anio;
import Modelo.AnioCRUD;
import Modelo.Asignatura;
import Modelo.AsignaturaCRUD;
import Modelo.Docente;
import Modelo.DocenteCRUD;
import Modelo.Docentemateria;
import Modelo.DocentemateriaCRUD;
import Modelo.Estudiante;
import Modelo.EstudianteCRUD;
import Modelo.Periodo;
import Modelo.PeriodoCRUD;
import Modelo.Representante;
import Modelo.RepresentanteCRUD;
import Modelo.Seccion;
import Modelo.SeccionCRUD;
import Modelo.Usuarios;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controlador extends HttpServlet {
     int ida, idp, id_anio, id_seccion, id_asignatura, id_docente, id_estudiante, id_representante;
             
        Periodo periodo=new Periodo();
        PeriodoCRUD periodoCRUD=new PeriodoCRUD();
        List<Periodo> lista = new ArrayList<>();
        
        Anio anio=new Anio();
        AnioCRUD anioCRUD=new AnioCRUD();
        
        Seccion seccion=new Seccion();
        SeccionCRUD seccionCRUD=new SeccionCRUD();
        
        Asignatura asignatura=new Asignatura();
        AsignaturaCRUD asignaturaCRUD=new AsignaturaCRUD();
                                     
        Administrador admin=new Administrador();
        AdministradorCRUD adminCRUD=new AdministradorCRUD();
        
        Docente doc=new Docente();
        DocenteCRUD docCRUD=new DocenteCRUD();
        
        Docentemateria docma=new Docentemateria();
        DocentemateriaCRUD docmaCRUD=new DocentemateriaCRUD();
        
        Estudiante estudiante=new Estudiante();
        EstudianteCRUD estudianteCRUD=new EstudianteCRUD();
        
        Representante representante=new Representante();
        RepresentanteCRUD representanteCRUD=new RepresentanteCRUD();
        
 private Periodo getPeriodo(HttpServletRequest request, HttpSession sesion) {
     Periodo pee = null;
     String rev = request.getParameter("idp");
     if (rev != null && !rev.equals("")) {
         idp = Integer.parseInt(rev);
         pee = periodoCRUD.listarId(idp);
     } 
     else {
         pee = (Periodo) sesion.getAttribute("periodoses");
     }
     return pee;
 }
 
 private Anio getAnio(HttpServletRequest request, HttpSession sesion) {
     Anio anio2 = null;
     String rev = request.getParameter("idpa");
     if (rev != null && !rev.equals("")){
         id_anio = Integer.parseInt(rev);
         anio2 = anioCRUD.listarId(id_anio);
     }
     else {
         anio2 = (Anio) sesion.getAttribute("anioses");
     }
     return anio2;
 }
 
 private Seccion getSeccion(HttpServletRequest request, HttpSession sesion) {
     Seccion seccion = null;
     String rev = request.getParameter("idpas");
     if (rev != null && !rev.equals("")) {
         id_seccion = Integer.parseInt(rev);
         seccion = seccionCRUD.listarId(id_seccion);         
     }
     else {
         seccion = (Seccion) sesion.getAttribute("seccionoses");
     }
     return seccion;
 }
 
 private Asignatura getAsignatura(HttpServletRequest request, HttpSession sesion) {
     Asignatura asignatura = null;
     String rev = request.getParameter("idpasa");
     if (rev != null && !rev.equals("")) {
         id_asignatura = Integer.parseInt(rev);
         asignatura = asignaturaCRUD.listarId(id_asignatura);         
     }
     else {
         asignatura = (Asignatura) sesion.getAttribute("asignaturases");
     }
     return asignatura;
 }
 
  public static Boolean Rol_usuario(Integer nRol, HttpServletRequest request) {
     HttpSession sesion = request.getSession();
     Usuarios user = (Usuarios) sesion.getAttribute("usuario");
     Boolean sal = false;
     if (user.getTipo_u() == nRol) sal = true;
     return sal;
 }
              
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        String accionn = request.getParameter("accionn");
        String accionnn = request.getParameter("accionnn");
        String accio4 = request.getParameter("accio4");
        String accio5 = request.getParameter("accio5");
        String acciodoc = request.getParameter("acciodoc");
        HttpSession sesion = request.getSession();
        Usuarios user = (Usuarios) sesion.getAttribute("usuario");

        if (menu.equals("Principal")) {
            //request.getRequestDispatcher("home.jsp").forward(request, response);
            if (user != null) {
                if (user.getTipo_u() == 1) {
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                    System.out.println("admin");
                } else if (user.getTipo_u() == 2) {
                    request.getRequestDispatcher("homedocente.jsp").forward(request, response);
                    System.out.println("docente");
                } else {
                    request.getRequestDispatcher("homeestudiante.jsp").forward(request, response);
                    System.out.println("estudiante");
                }
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        String valorr="Probando variables";
        
     if (menu.equals("Periodo")) {
         
        if (user.getTipo_u() == 1) {

         Integer nMostrarBoton = 0;
         request.setAttribute("BoolMostrarBoton", nMostrarBoton);

         switch (accion) {
             case "Listar":
                 List lista = periodoCRUD.listar();
                 request.setAttribute("Periodos", lista);
                 request.getRequestDispatcher("period.jsp").forward(request, response);
                 break;
             case "Agregar":
                 int id_periodo = Integer.parseInt(request.getParameter("id_periodo"));
                 String nombre_p = request.getParameter("nombre_p");
                 String fecha_inicio = request.getParameter("fecha_inicio");
                 String fecha_fin = request.getParameter("fecha_fin");
                 String estatus_p = request.getParameter("estatus_p");

                 periodo.setNombre(nombre_p);
                 periodo.setFecha_i(fecha_inicio);
                 periodo.setFecha_f(fecha_fin);
                 periodo.setEstatus(estatus_p);

                 periodoCRUD.agregar(periodo);
                 request.getRequestDispatcher("Controlador?menu=Periodo&accion=Listar").forward(request, response);
                 break;
             case "Editar":
                 idp = Integer.parseInt(request.getParameter("id"));
                 Periodo pe = periodoCRUD.listarId(idp);
                 request.setAttribute("periodo", pe);
                 request.getRequestDispatcher("Controlador?menu=Periodo&accion=Listar").forward(request, response);
                 break;
             case "Actualizar":
                 String nombre_p1 = request.getParameter("nombre_p");
                 String fecha_inicio1 = request.getParameter("fecha_inicio");
                 String fecha_fin1 = request.getParameter("fecha_fin");
                 String estatus_p1 = request.getParameter("estatus_p");

                 periodo.setNombre(nombre_p1);
                 periodo.setFecha_i(fecha_inicio1);
                 periodo.setFecha_f(fecha_fin1);
                 periodo.setEstatus(estatus_p1);

                 periodo.setId_p(idp);
                 periodoCRUD.actualizar(periodo);
                 request.getRequestDispatcher("Controlador?menu=Periodo&accion=Listar").forward(request, response);
                 break;
             case "Eliminar":
                 idp = Integer.parseInt(request.getParameter("id"));
                 periodoCRUD.delete(idp);
                 request.getRequestDispatcher("Controlador?menu=Periodo&accion=Listar").forward(request, response);
                 break;

                 
                 
                 
                 
             //ENTRAMOS EN LOS AÑOS DEL PERIODO AQUI
             case "Anio_Periodo":
                 switch (accionn) {
                     case "Listar":
                         Periodo pee = getPeriodo(request, sesion);
                         sesion.setAttribute("periodoses", pee);
                         List listaa = anioCRUD.listar();
                         request.setAttribute("Anios", listaa);
                         request.setAttribute("valor", valorr);
                         request.getRequestDispatcher("anio_periodo.jsp").forward(request, response);
                         break;
                     case "Agregar":
                         String codigo_anio = request.getParameter("codigo_anio");
                         String nombre_anio = request.getParameter("nombre_anio");
                         String estatus_anio = request.getParameter("estatus_anio");
                         int id_periodo2 = Integer.parseInt(request.getParameter("id_periodo2"));
                         anio.setCodigo(codigo_anio);
                         anio.setNombre(nombre_anio);
                         anio.setEstatus(estatus_anio);
                         anio.setId_p(id_periodo2);
                         anioCRUD.agregarIDperiodo(anio);
                         request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Listar").forward(request, response);
                         break;
                     case "Editar":
                         id_anio = Integer.parseInt(request.getParameter("id"));
                         Anio pea = anioCRUD.listarId(id_anio);
                         request.setAttribute("anio", pea);
                         request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Listar").forward(request, response);
                         break;
                     case "Actualizar":
                         String codigo_anio1 = request.getParameter("codigo_anio");
                         String nombre_anio1 = request.getParameter("nombre_anio");
                         String estatus_anio1 = request.getParameter("estatus_anio");

                         anio.setCodigo(codigo_anio1);
                         anio.setNombre(nombre_anio1);
                         anio.setEstatus(estatus_anio1);

                         anio.setId_a(id_anio);
                         anioCRUD.actualizar(anio);
                         request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Listar").forward(request, response);
                         break;
                     case "Eliminar":
                         id_anio = Integer.parseInt(request.getParameter("id"));
                         anioCRUD.delete(id_anio);
                         request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Listar").forward(request, response);
                         break;

                         
                         
                         
                         
                     //ENTRAMOS EN LAS SECCIONES DE CADA AÑO DEL PERIODO AQUI
                     case "Seccion":
                         switch (accionnn) {
                             case "Listar":
                                 Periodo pe2 = getPeriodo(request, sesion);
                                 sesion.setAttribute("periodoses", pe2);

                                 Anio anio2 = getAnio(request, sesion);
                                 sesion.setAttribute("anioses", anio2);

                                 List listaaa = seccionCRUD.listar();
                                 request.setAttribute("Secciones", listaaa);
                                 request.getRequestDispatcher("seccion_anio_periodo.jsp").forward(request, response);
                                 break;
                             case "Agregar":
                                 String codigo_s = request.getParameter("codigo_s");
                                 String nombre_s = request.getParameter("nombre_s");
                                 String estatus_s = request.getParameter("estatus_s");

                                 seccion.setCodigo(codigo_s);
                                 seccion.setNombre(nombre_s);
                                 seccion.setEstatus(estatus_s);
                                 seccion.setId_p(idp);
                                 seccion.setId_a(id_anio);

                                 seccionCRUD.agregarIDS(seccion);
                                 request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Seccion&accionnn=Listar").forward(request, response);
                                 break;
                             case "Editar":
                                 id_seccion = Integer.parseInt(request.getParameter("id"));
                                 Seccion pes = seccionCRUD.listarId(id_seccion);
                                 request.setAttribute("seccion", pes);
                                 request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Seccion&accionnn=Listar").forward(request, response);
                                 break;
                             case "Actualizar":
                                 String codigo_s1 = request.getParameter("codigo_s");
                                 String nombre_s1 = request.getParameter("nombre_s");
                                 String estatus_s1 = request.getParameter("estatus_s");

                                 seccion.setCodigo(codigo_s1);
                                 seccion.setNombre(nombre_s1);
                                 seccion.setEstatus(estatus_s1);

                                 seccion.setId_s(id_seccion);
                                 seccionCRUD.actualizar(seccion);
                                 request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Seccion&accionnn=Listar").forward(request, response);
                                 break;
                             case "Eliminar":
                                 id_seccion = Integer.parseInt(request.getParameter("id"));
                                 seccionCRUD.delete(id_seccion);
                                 request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Seccion&accionnn=Listar").forward(request, response);
                                 break;

                                 
                                 
                                 
                                 
                             //ENTRAMOS EN LAS MATERIAS DE LAS SECCIONES DE CADA AÑO DEL PERIODO AQUI    
                             case "Asignatura_periodo": { 
                                 switch (accio4) {
                             case "Listar":

                                 Periodo pe22 = getPeriodo(request, sesion);
                                 sesion.setAttribute("periodoses", pe22);

                                 Anio anio22 = getAnio(request, sesion);
                                 sesion.setAttribute("anioses", anio22);

                                 Seccion seccion = getSeccion(request, sesion);
                                 sesion.setAttribute("seccionoses", seccion);

                                 List listaasig = asignaturaCRUD.listar();
                                 request.setAttribute("Asignaturas", listaasig);
                                 request.getRequestDispatcher("asignatura_periodo.jsp").forward(request, response);
                                 break;
                             case "Agregar":
                             String codigo_asigg=request.getParameter("codigo_asigg");
                             String nombre_asigg=request.getParameter("nombre_asigg");
                             double minimo_asigg=Double.parseDouble(request.getParameter("minimo_asigg"));
                             double maximo_asigg=Double.parseDouble(request.getParameter("maximo_asigg"));
                             String estatus_asigg=request.getParameter("estatus_asigg");
                    
                             asignatura.setCodigo(codigo_asigg);
                             asignatura.setNombre(nombre_asigg);
                             asignatura.setMinimo(minimo_asigg);
                             asignatura.setMaximo(maximo_asigg);
                             asignatura.setEstatus(estatus_asigg);
                             asignatura.setId_periodo(idp);
                             asignatura.setId_anio(id_anio);
                             asignatura.setId_seccion(id_seccion);
                    
                             asignaturaCRUD.agregarIDS(asignatura);
                             request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Seccion&accionnn=Asignatura_periodo&accio4=Listar").forward(request, response);
                                  break;
                             case "Editar":
                             id_asignatura=Integer.parseInt(request.getParameter("id"));
                             Asignatura asig=asignaturaCRUD.listarId(id_asignatura);
                             request.setAttribute("asignatura", asig);
                             request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Seccion&accionnn=Asignatura_periodo&accio4=Listar").forward(request, response);                    
                                  break;
                             case "Actualizar":
                             String codigo_asig1=request.getParameter("codigo_asigg");
                             String nombre_asig1=request.getParameter("nombre_asigg");
                             double minimo_asig1=Double.parseDouble(request.getParameter("minimo_asigg"));
                             double maximo_asig1=Double.parseDouble(request.getParameter("maximo_asigg"));
                             String estatus_asig1=request.getParameter("estatus_asigg");
                    
                             asignatura.setCodigo(codigo_asig1);
                             asignatura.setNombre(nombre_asig1);
                             asignatura.setMinimo(minimo_asig1);
                             asignatura.setMaximo(maximo_asig1);
                             asignatura.setEstatus(estatus_asig1);
                    
                             asignatura.setId_a(id_asignatura);
                             asignaturaCRUD.actualizar(asignatura);
                             request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Seccion&accionnn=Asignatura_periodo&accio4=Listar").forward(request, response);                    
                                   break;
                             case "Eliminar":
                             id_asignatura=Integer.parseInt(request.getParameter("id"));
                             asignaturaCRUD.delete(id_asignatura);
                             request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Seccion&accionnn=Asignatura_periodo&accio4=Listar").forward(request, response);                    
                                   break;
                                   
                                   
                                   
                                   
                                   
                             //ENTRAMOS EN EL MODULO DE LOS ESTUDIANTES Y SUS LAPSOS
                             case "Estudiantes_Lapsos":
                                 switch (accio5) {
                                     case "Listar":
                                         
                                 Periodo pe222 = getPeriodo(request, sesion);
                                 sesion.setAttribute("periodoses", pe222);

                                 Anio anio222 = getAnio(request, sesion);
                                 sesion.setAttribute("anioses", anio222);

                                 Seccion seccion2 = getSeccion(request, sesion);
                                 sesion.setAttribute("seccionoses", seccion2);
                                 
                                 Asignatura asignatura = getAsignatura(request, sesion);
                                 sesion.setAttribute("asignaturases", asignatura);
                                 
                                 
                                         List list4 = estudianteCRUD.listar();
                                         request.setAttribute("Estudiantesl", list4);
                                         request.getRequestDispatcher("estudiantelapsos.jsp").forward(request, response);
                                         break;
                                     case "Asignar_Docente":
                                         List list5 = docCRUD.listar();
                                         request.setAttribute("Asignadoc", list5);
                                         request.getRequestDispatcher("asignar_docente.jsp").forward(request, response);
                                         
                                         if (acciodoc.equals("Asignar")) { 
                                             int select_docente=Integer.parseInt(request.getParameter("select_docente"));

                                             docma.setDocente(select_docente);
                                             docma.setPeriodo(idp);
                                             docma.setAnio(id_anio);
                                             docma.setSeccion(id_seccion);
                                             docma.setMateria(id_asignatura);
                                             
                                             docmaCRUD.asignarmateria(docma);
                                             request.getRequestDispatcher("Controlador?menu=Periodo&accion=Anio_Periodo&accionn=Seccion&accionnn=Asignatura_periodo&accio4=Estudiantes_Lapsos&accio5=Asignar_Docente").forward(request, response);                    
                                   
                                         }
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
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }         
     }
        if (menu.equals("Anio")) {
            if (user.getTipo_u() == 1) {           
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
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }         
            
        }
        if (menu.equals("Seccion")) {
            if (user.getTipo_u() == 1) {            
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
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }                     
        }
        if (menu.equals("Asignatura")) {
            if (user.getTipo_u() == 1) { 
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
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }                     
            
        }
             
        if (menu.equals("Administrador")) {
            if (user.getTipo_u() == 1) { 
            Integer nMostrarBoton = 0;
            request.setAttribute("BoolMostrarBoton", nMostrarBoton);
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
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }                     
            
        }
        
        if (menu.equals("Docente")) {
            if (user.getTipo_u() == 2) {
            switch (accion) {
                case "Listar":
                   List lista = docCRUD.listar();
                   request.setAttribute("Docentes", lista);
                   request.getRequestDispatcher("teacher.jsp").forward(request, response);
                break;
                case "Agregar":
                    String nombred1=request.getParameter("nombred1");
                    String nombred2=request.getParameter("nombred2");
                    String apellidod1=request.getParameter("apellidod1");
                    String apellidod2=request.getParameter("apellidod2");
                    String cedulad=request.getParameter("cedulad");
                    String sexod=request.getParameter("sexod");
                    String fechad=request.getParameter("fechad");
                    String nacionalidadd=request.getParameter("nacionalidadd");
                    String celulard=request.getParameter("celulard");
                    String telefonod=request.getParameter("telefonod");
                    String correod=request.getParameter("correod");
                    String direcciond=request.getParameter("direcciond");
                    String estatusd=request.getParameter("estatusd");
                    doc.setNombre1(nombred1);
                    doc.setNombre2(nombred2);
                    doc.setApellido1(apellidod1);
                    doc.setApellido2(apellidod2);
                    doc.setCedula(cedulad);
                    doc.setSexo(sexod);
                    doc.setFecha(fechad);
                    doc.setNacionalidad(nacionalidadd);
                    doc.setCelular(celulard);
                    doc.setTelefono(telefonod);
                    doc.setCorreo(correod);
                    doc.setDireccion(direcciond);
                    doc.setEstatus(estatusd);
                    docCRUD.agregar(doc);
                    request.getRequestDispatcher("Controlador?menu=Docente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    id_docente=Integer.parseInt(request.getParameter("id"));
                    Docente a=docCRUD.listarId(id_docente);
                    request.setAttribute("docente", a);
                    request.getRequestDispatcher("Controlador?menu=Docente&accion=Listar").forward(request, response);                    
                break;
                case "Actualizar":
                    String nombred11=request.getParameter("nombred1");
                    String nombred21=request.getParameter("nombred2");
                    String apellidod11=request.getParameter("apellidod1");
                    String apellidod21=request.getParameter("apellidod2");
                    String cedulad1=request.getParameter("cedulad");
                    String sexod1=request.getParameter("sexod");
                    String fechad1=request.getParameter("fechad");
                    String nacionalidadd1=request.getParameter("nacionalidadd");
                    String celulard1=request.getParameter("celulard");
                    String telefonod1=request.getParameter("telefonod");
                    String correod1=request.getParameter("correod");
                    String direcciond1=request.getParameter("direcciond");
                    String estatusd1=request.getParameter("estatusd");
                    doc.setNombre1(nombred11);
                    doc.setNombre2(nombred21);
                    doc.setApellido1(apellidod11);
                    doc.setApellido2(apellidod21);
                    doc.setCedula(cedulad1);
                    doc.setSexo(sexod1);
                    doc.setFecha(fechad1);
                    doc.setNacionalidad(nacionalidadd1);
                    doc.setCelular(celulard1);
                    doc.setTelefono(telefonod1);
                    doc.setCorreo(correod1);
                    doc.setDireccion(direcciond1);
                    doc.setEstatus(estatusd1);
                    doc.setId_p_d(id_docente);
                    docCRUD.actualizar(doc);
                    request.getRequestDispatcher("Controlador?menu=Docente&accion=Listar").forward(request, response);                    
                break;
                case "Eliminar":
                id_docente=Integer.parseInt(request.getParameter("id"));
                docCRUD.delete(id_docente);
                request.getRequestDispatcher("Controlador?menu=Docente&accion=Listar").forward(request, response);                    
                break;
                default:
                    throw new AssertionError();
            }  
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }                     
            
        }
        
        if (menu.equals("Estudiante")) {
            if (user.getTipo_u() == 1) {
            switch (accion) {
                case "Listar":
                   List lista = estudianteCRUD.listar();
                   request.setAttribute("Estudiantes", lista);
                   request.getRequestDispatcher("student.jsp").forward(request, response);
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
                    String procedencia=request.getParameter("procedencia");
                    String anio=request.getParameter("anio");
                    String cedula_r=request.getParameter("cedula_r");
                    estudiante.setNombre1(nombre1);
                    estudiante.setNombre2(nombre2);
                    estudiante.setApellido1(apellido1);
                    estudiante.setApellido2(apellido2);
                    estudiante.setCedula(cedula);
                    estudiante.setSexo(sexo);
                    estudiante.setFecha(fecha);
                    estudiante.setNacionalidad(nacionalidad);
                    estudiante.setCelular(celular);
                    estudiante.setTelefono(telefono);
                    estudiante.setCorreo(correo);
                    estudiante.setDireccion(direccion);
                    estudiante.setProcedencia(procedencia);
                    estudiante.setAnio(anio);
                    estudiante.setCedula_r(cedula_r);
                    estudianteCRUD.agregar(estudiante);
                    request.getRequestDispatcher("Controlador?menu=Estudiante&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    id_estudiante=Integer.parseInt(request.getParameter("id"));
                    Estudiante a=estudianteCRUD.listarId(id_estudiante);
                    request.setAttribute("estudiante", a);
                    request.getRequestDispatcher("Controlador?menu=Estudiante&accion=Listar").forward(request, response);                    
                break;
                case "Actualizar":
                    String nombre1e=request.getParameter("nombre1");
                    String nombre2e=request.getParameter("nombre2");
                    String apellido1e=request.getParameter("apellido1");
                    String apellido2e=request.getParameter("apellido2");
                    String cedulae=request.getParameter("cedula");
                    String sexoe=request.getParameter("sexo");
                    String fechae=request.getParameter("fecha");
                    String nacionalidade=request.getParameter("nacionalidad");
                    String celulare=request.getParameter("celular");
                    String telefonoe=request.getParameter("telefono");
                    String correoe=request.getParameter("correo");
                    String direccione=request.getParameter("direccion");
                    String procedenciae=request.getParameter("procedencia");
                    String anioe=request.getParameter("anio");
                    String cedula_re=request.getParameter("cedula_r");
                    estudiante.setNombre1(nombre1e);
                    estudiante.setNombre2(nombre2e);
                    estudiante.setApellido1(apellido1e);
                    estudiante.setApellido2(apellido2e);
                    estudiante.setCedula(cedulae);
                    estudiante.setSexo(sexoe);
                    estudiante.setFecha(fechae);
                    estudiante.setNacionalidad(nacionalidade);
                    estudiante.setCelular(celulare);
                    estudiante.setTelefono(telefonoe);
                    estudiante.setCorreo(correoe);
                    estudiante.setDireccion(direccione);
                    estudiante.setProcedencia(procedenciae);
                    estudiante.setAnio(anioe);
                    estudiante.setCedula_r(cedula_re);
                    estudiante.setId_p_e(id_estudiante);
                    estudianteCRUD.actualizar(estudiante);
                    request.getRequestDispatcher("Controlador?menu=Estudiante&accion=Listar").forward(request, response);                    
                break;
                case "Eliminar":
                id_estudiante=Integer.parseInt(request.getParameter("id"));
                estudianteCRUD.delete(id_estudiante);
                request.getRequestDispatcher("Controlador?menu=Estudiante&accion=Listar").forward(request, response);                    
                break;
                default:
                    throw new AssertionError();
            }  
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }                     
            
        }
        
        if (menu.equals("Representante")) {
            if (user.getTipo_u() == 1) {
            switch (accion) {
                case "Listar":
                   List lista = representanteCRUD.listar();
                   request.setAttribute("Representantes", lista);
                   request.getRequestDispatcher("representative.jsp").forward(request, response);
                break;
                case "Agregar":
                    String nombred1=request.getParameter("nombred1");
                    String nombred2=request.getParameter("nombred2");
                    String apellidod1=request.getParameter("apellidod1");
                    String apellidod2=request.getParameter("apellidod2");
                    String cedulad=request.getParameter("cedulad");
                    String sexod=request.getParameter("sexod");
                    String fechad=request.getParameter("fechad");
                    String nacionalidadd=request.getParameter("nacionalidadd");
                    String telefonod=request.getParameter("telefonod");
                    String correod=request.getParameter("correod");
                    String direcciond=request.getParameter("direcciond");
                    representante.setNombre1(nombred1);
                    representante.setNombre2(nombred2);
                    representante.setApellido1(apellidod1);
                    representante.setApellido2(apellidod2);
                    representante.setCedula(cedulad);
                    representante.setSexo(sexod);
                    representante.setFecha(fechad);
                    representante.setNacionalidad(nacionalidadd);
                    representante.setTelefono(telefonod);
                    representante.setCorreo(correod);
                    representante.setDireccion(direcciond);
                    representanteCRUD.agregar(representante);
                    request.getRequestDispatcher("Controlador?menu=Representante&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    id_representante=Integer.parseInt(request.getParameter("id"));
                    Representante a=representanteCRUD.listarId(id_representante);
                    request.setAttribute("representante", a);
                    request.getRequestDispatcher("Controlador?menu=Representante&accion=Listar").forward(request, response);                    
                break;
                case "Actualizar":
                    String nombred11=request.getParameter("nombred1");
                    String nombred21=request.getParameter("nombred2");
                    String apellidod11=request.getParameter("apellidod1");
                    String apellidod21=request.getParameter("apellidod2");
                    String cedulad1=request.getParameter("cedulad");
                    String sexod1=request.getParameter("sexod");
                    String fechad1=request.getParameter("fechad");
                    String nacionalidadd1=request.getParameter("nacionalidadd");
                    String telefonod1=request.getParameter("telefonod");
                    String correod1=request.getParameter("correod");
                    String direcciond1=request.getParameter("direcciond");
                    representante.setNombre1(nombred11);
                    representante.setNombre2(nombred21);
                    representante.setApellido1(apellidod11);
                    representante.setApellido2(apellidod21);
                    representante.setCedula(cedulad1);
                    representante.setSexo(sexod1);
                    representante.setFecha(fechad1);
                    representante.setNacionalidad(nacionalidadd1);
                    representante.setTelefono(telefonod1);
                    representante.setCorreo(correod1);
                    representante.setDireccion(direcciond1);
                    representante.setId_p_r(id_representante);
                    representanteCRUD.actualizar(representante);
                    request.getRequestDispatcher("Controlador?menu=Representante&accion=Listar").forward(request, response);                    
                break;
                case "Eliminar":
                id_representante=Integer.parseInt(request.getParameter("id"));
                representanteCRUD.delete(id_representante);
                request.getRequestDispatcher("Controlador?menu=Representante&accion=Listar").forward(request, response);                    
                break;
                default:
                    throw new AssertionError();
            }  
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
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

