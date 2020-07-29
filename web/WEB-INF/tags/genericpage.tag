<%-- 
    Document   : template
    Created on : 27/07/2020, 03:47:19 PM
    Author     : G L703
--%>
<%@tag import="Controlador.Controlador" %>
<%@tag import="Controlador.ControladorDocente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Overall page template"  pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="body" fragment="true" %> 
<!DOCTYPE html>
<!DOCTYPE html>
<html> 
    <body> 
        <div id="pageheader"> 
            <jsp:invoke fragment="header"/>
            <head>
                <title>Perfiles de usuarios</title>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
                <link rel="stylesheet" href="./css/main.css">
            </head>
        </div>
        <div id="body">
            <jsp:doBody/> 
            <!--inicio body template -->

            <!-- SideBar -->
            <section class="full-box cover dashboard-sideBar">
                <div class="full-box dashboard-sideBar-bg btn-menu-dashboard"></div>
                <div class="full-box dashboard-sideBar-ct">
                    <!--SideBar Title -->
                    <div class="full-box text-uppercase text-center text-titles dashboard-sideBar-title">
                        company <i class="zmdi zmdi-close btn-menu-dashboard visible-xs"></i>
                    </div>
                    <!-- SideBar User info -->
                    <div class="full-box dashboard-sideBar-UserInfo">
                        <figure class="full-box">
                            <img src="./assets/img/avatar.jpg" alt="UserIcon">
                            <figcaption class="text-center text-titles">User Name</figcaption>
                        </figure>
                        <ul class="full-box list-unstyled text-center">
                            <li>
                                <a href="#!">
                                    <i class="zmdi zmdi-settings"></i>
                                </a>
                            </li>
                            <li>
                                <a href="#!" class="btn-exit-system">
                                    <i class="zmdi zmdi-power"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <!-- MENU PARA DIRECTIVOS -->
                    <% if (Controlador.Rol_usuario(1, request)) {%>						
                    <ul class="list-unstyled full-box dashboard-sideBar-Menu">
                        <li>
                            <a href="home.jsp">
                                <i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i> Dashboard
                            </a>
                        </li>
                        <li>
                            <a href="#!" class="btn-sideBar-SubMenu">
                                <i class="zmdi zmdi-case zmdi-hc-fw"></i> Administracion <i class="zmdi zmdi-caret-down pull-right"></i>
                            </a>
                            <ul class="list-unstyled full-box">

                                <li>
                                    <a href="Controlador?menu=Periodo&accion=Listar"><i class="zmdi zmdi-timer zmdi-hc-fw"></i> Periodos</a>
                                </li>

                                <li>
                                    <a href="Controlador?menu=Anio&accion=Listar"><i class="zmdi zmdi-book zmdi-hc-fw"></i> Año escolar</a>
                                </li>
                                <li>
                                    <a href="Controlador?menu=Seccion&accion=Listar"><i class="zmdi zmdi-graduation-cap zmdi-hc-fw"></i> Section</a>
                                </li>
                                <li>
                                    <a href="Controlador?menu=Asignatura&accion=Listar"><i class="zmdi zmdi-font zmdi-hc-fw"></i> Materias</a>
                                </li>

                            </ul>
                        </li>
                        <li>
                            <a href="#!" class="btn-sideBar-SubMenu">
                                <i class="zmdi zmdi-account-add zmdi-hc-fw"></i> Usuarios <i class="zmdi zmdi-caret-down pull-right"></i>
                            </a>
                            <ul class="list-unstyled full-box">
                                <li>
                                    <a href="Controlador?menu=Administrador&accion=Listar"><i class="zmdi zmdi-account zmdi-hc-fw"></i> Administradores</a>
                                </li>
                                <li>
                                    <a href="Controlador?menu=Docente&accion=Listar"><i class="zmdi zmdi-male-alt zmdi-hc-fw"></i> Docentes</a>
                                </li>
                                <li>
                                    <a href="Controlador?menu=Estudiante&accion=Listar"><i class="zmdi zmdi-face zmdi-hc-fw"></i> Estudiantes</a>
                                </li>
                                <li>
                                    <a href="Controlador?menu=Representante&accion=Listar"><i class="zmdi zmdi-male-female zmdi-hc-fw"></i> Representantes</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#!" class="btn-sideBar-SubMenu">
                                <i class="zmdi zmdi-card zmdi-hc-fw"></i> Pagos <i class="zmdi zmdi-caret-down pull-right"></i>
                            </a>
                            <ul class="list-unstyled full-box">
                                <li>
                                    <a href="registration.jsp"><i class="zmdi zmdi-money-box zmdi-hc-fw"></i> Registration</a>
                                </li>
                                <li>
                                    <a href="payments.jsp"><i class="zmdi zmdi-money zmdi-hc-fw"></i> Payments</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#!" class="btn-sideBar-SubMenu">
                                <i class="zmdi zmdi-shield-security zmdi-hc-fw"></i> Settings School <i class="zmdi zmdi-caret-down pull-right"></i>
                            </a>
                            <ul class="list-unstyled full-box">
                                <li>
                                    <a href="school.jsp"><i class="zmdi zmdi-balance zmdi-hc-fw"></i> School Data</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </section>
            <% } %>   

            <!-- MENU PARA DOCENTES -->
            <% if (ControladorDocente.Rol_usuario(2, request)) {%>						
            <ul class="list-unstyled full-box dashboard-sideBar-Menu">
                <li>
                    <a href="home.jsp">
                        <i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i> Dashboard
                    </a>
                </li>
                <li>
                    <a href="#!" class="btn-sideBar-SubMenu">
                        <i class="zmdi zmdi-case zmdi-hc-fw"></i> Administracion <i class="zmdi zmdi-caret-down pull-right"></i>
                    </a>
                    <ul class="list-unstyled full-box">

                        <li>
                            <a href="ControladorDocente?menu=Periodo&accion=Listar"><i class="zmdi zmdi-timer zmdi-hc-fw"></i> Periodos Docentes</a>
                        </li>

                        <li>
                            <a href="ControladorDocente?menu=Anio&accion=Listar"><i class="zmdi zmdi-book zmdi-hc-fw"></i> Año escolar</a>
                        </li>
                        <li>
                            <a href="ControladorDocente?menu=Seccion&accion=Listar"><i class="zmdi zmdi-graduation-cap zmdi-hc-fw"></i> Section</a>
                        </li>
                        <li>
                            <a href="ControladorDocente?menu=Asignatura&accion=Listar"><i class="zmdi zmdi-font zmdi-hc-fw"></i> Materias</a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="#!" class="btn-sideBar-SubMenu">
                        <i class="zmdi zmdi-account-add zmdi-hc-fw"></i> Usuarios <i class="zmdi zmdi-caret-down pull-right"></i>
                    </a>
                    <ul class="list-unstyled full-box">
                        <li>
                            <a href="ControladorDocente?menu=Administrador&accion=Listar"><i class="zmdi zmdi-account zmdi-hc-fw"></i> Administradores</a>
                        </li>
                        <li>
                            <a href="ControladorDocente?menu=Docente&accion=Listar"><i class="zmdi zmdi-male-alt zmdi-hc-fw"></i> Docentes</a>
                        </li>
                        <li>
                            <a href="ControladorDocente?menu=Estudiante&accion=Listar"><i class="zmdi zmdi-face zmdi-hc-fw"></i> Estudiantes</a>
                        </li>
                        <li>
                            <a href="ControladorDocente?menu=Representante&accion=Listar"><i class="zmdi zmdi-male-female zmdi-hc-fw"></i> Representantes</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#!" class="btn-sideBar-SubMenu">
                        <i class="zmdi zmdi-card zmdi-hc-fw"></i> Pagos <i class="zmdi zmdi-caret-down pull-right"></i>
                    </a>
                    <ul class="list-unstyled full-box">
                        <li>
                            <a href="registration.jsp"><i class="zmdi zmdi-money-box zmdi-hc-fw"></i> Registration</a>
                        </li>
                        <li>
                            <a href="payments.jsp"><i class="zmdi zmdi-money zmdi-hc-fw"></i> Payments</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#!" class="btn-sideBar-SubMenu">
                        <i class="zmdi zmdi-shield-security zmdi-hc-fw"></i> Settings School <i class="zmdi zmdi-caret-down pull-right"></i>
                    </a>
                    <ul class="list-unstyled full-box">
                        <li>
                            <a href="school.jsp"><i class="zmdi zmdi-balance zmdi-hc-fw"></i> School Data</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </section>
    <% }%>  
    <!--fin body template -->
</div> 
<!-- div body-->
<div id="pagefooter">
    <jsp:invoke fragment="footer"/>

    <!--====== Scripts -->
    <script src="./js/jquery-3.1.1.min.js"></script>
    <script src="./js/sweetalert2.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/material.min.js"></script>
    <script src="./js/ripples.min.js"></script>
    <script src="./js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="./js/main.js"></script>
    <script>
        $.material.init();
    </script>
</div> 
</body> 
</html>

