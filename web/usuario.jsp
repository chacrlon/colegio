
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<t:genericpage>
    <jsp:attribute name="header">
        <link href="css/alertify.min.css" rel="stylesheet" type="text/css"/>

    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

        <!-- Content page-->
        <section class="full-box dashboard-contentPage">

            <!-- NavBar -->
            <nav class="full-box dashboard-Navbar">
                <ul class="full-box list-unstyled text-right">
                    <li class="pull-left">
                        <a href="#!" class="btn-menu-dashboard"><i class="zmdi zmdi-more-vert"></i></a>
                    </li>
                    <li>
                        <a href="#!" class="btn-Notifications-area">
                            <i class="zmdi zmdi-notifications-none"></i>
                            <span class="badge">7</span>
                        </a>
                    </li>
                    <li>
                        <a href="#!" class="btn-search">
                            <i class="zmdi zmdi-search"></i>
                        </a>
                    </li>
                    <li>
                        <a href="#!" class="btn-modal-help">
                            <i class="zmdi zmdi-help-outline"></i>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- Content page -->
            <div class="container-fluid">
                <div class="page-header">
                    <h1 class="text-titles"><i class="zmdi zmdi-male-alt zmdi-hc-fw"></i> Users <small>Teacher</small></h1>
                </div>
                <p class="lead"></p>
            </div>
            <c:if test="${not empty message}">
                <c:set var="mensaje" value="${message}"/>
                <c:if test="${fn:contains(mensaje,'Error')}">
                    <div class="alert alert-danger alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>Error!</strong> ${fn:replace(mensaje, 'Error','')}
                </div>
                </c:if>
                <c:if test="${fn:contains(mensaje,'Éxito')}">
                    <div class="alert alert-success alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>Éxito!</strong> ${fn:replace(mensaje, 'Éxito','')}
                </div>
                </c:if>
                <c:if test="${fn:contains(mensaje,'Advertencia')}">
                    <div class="alert alert-info alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>Advertencia!</strong> ${fn:replace(mensaje, 'Advertencia','')}
                </div>
                </c:if>
                
    <script>
        console.log("mensaje");
         console.log(${message});
    </script>
            </c:if>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xs-12">
                        <ul class="nav nav-tabs" style="margin-bottom: 15px;">
                            
                            <c:if test="${!Controlador.Rol_usuario(1, request)}">
                                <li class="active"><a href="#list" data-toggle="tab">List</a></li>
                                <li ><a href="#new" data-toggle="tab">New</a></li>
                                </c:if>  
                        </ul>	
                        <div id="myTabContent" class="tab-content">
                            <div class="tab-pane fade active in" id="list">
                                <div class="table-responsive">
                                    <table class="table table-hover text-center">
                                        <thead>
                                            <tr>
                                                <th class="text-center">Id</th>
                                                <th class="text-center">Nick</th>
                                                <th class="text-center">Contraseña</th>
                                                <th class="text-center">Estatus</th>
                                                <th class="text-center">Tipo de usuario</th>
                                                <th class="text-center">ACCIONES</th>			
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="usu" items="${Usuarios}">
                                                <tr>
                                                    <td>${usu.getIdUsuario()}</td>
                                                    <td>${usu.getNick()}</td>
                                                    <td>${usu.getPassword()}</td>
                                                    <td>${usu.getStatusIdStatus().getDescripcion()}</td>
                                                    <td>${usu.getRolesString()}</td>
                                                    <!--											<td>{usu.getTipo_u()}</td>							   -->
                                                    <c:if  test="${!Controlador.Rol_usuario(1, request)}">   
                                                        <td><a href="Controlador?menu=Usuario&accion=Editar&id=${usu.getIdUsuario()}" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i></a></td>
                                                        <td><a href="Controlador?menu=Usuario&accion=Eliminar&id=${usu.getIdUsuario()}" class="btn btn-danger btn-raised btn-xs"><i class="zmdi zmdi-delete"></i></a></td>
                                                            </c:if>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <ul class="pagination pagination-sm">
                                        <li class="disabled"><a href="#!">«</a></li>
                                        <li class="active"><a href="#!">1</a></li>
                                        <li><a href="#!">2</a></li>
                                        <li><a href="#!">3</a></li>
                                        <li><a href="#!">4</a></li>
                                        <li><a href="#!">5</a></li>
                                        <li><a href="#!">»</a></li>
                                    </ul>
                                </div>
                            </div>

                            <div class="tab-pane fade in" id="new">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-xs-12 col-md-10 col-md-offset-1">
                                            <form action="Controlador?menu=Usuario" name="formulario" method="POST" onsubmit="return validar()">
                                                <div class="form-group label-floating">
                                                    <label id="error" class="control-label">Nick</label>
                                                    <input class="form-control" type="text" value="${user.getNick()}" name="nicku">
                                                </div>
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Contraseña</label>
                                            <input class="form-control" type="text" value="${user.getPassword()}" name="passu">
                                                </div>
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Tipo de usuario</label>
                                                    <select class="form-control" name="rol">
                                                        <c:forEach var="rol" items="${Roles}">
                                                            <option value="${rol}">${rol}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Estatus</label>
                                                    <select class="form-control" name="Status">
                                                        <c:forEach var="s" items="${Status}">
                                                            <option value="${s.getIdStatus()}">${s.getDescripcion()}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>

                                        </div>
                                        <input type="submit" name="accion" value="Agregar"  class="btn btn-primary">
                                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </section>
        <script>
            function validar() {
                var nick = document.formulario.nicku.value;
                var pass = document.formulario.passu.value;
                if (nick.length === 0 || pass.length === 0) {
                    alertify.alert("Error", "No debe de haber campos vacíos.").set('label', 'Ok');
                    return false;
                } else {
                    return true;
                }

            }
        </script>
        <script src="js/alertify.min.js" type="text/javascript"></script>

        <script type="text/javascript">
           alertify.defaults.transition = "slide";
           alertify.defaults.theme.ok = "btn btn-primary";
           alertify.defaults.theme.cancel = "btn btn-danger";
           alertify.defaults.theme.input = "form-control";
        </script>

    </jsp:body>
</t:genericpage>

