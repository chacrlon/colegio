
<%@page import="Controlador.ControladorDocente"%>
<%@page import="Controlador.Controlador"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="es">
<head>
	<title>Historial</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="./css/main.css">
</head>
<body>
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
                        <% if (Controlador.Rol_usuario(1, request)){%>						
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
                                 <% if (ControladorDocente.Rol_usuario(2, request)){%>						
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
         <% } %>  

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
			  <h1 class="text-titles"><i class="zmdi zmdi-account zmdi-hc-fw"></i> Usuarios <small>Administrador</small></h1>
			</div>
			<p class="lead"></p>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<ul class="nav nav-tabs" style="margin-bottom: 15px;">
                                                <li class="active"><a href="#list" data-toggle="tab">List</a></li>
					  	<li ><a href="#new" data-toggle="tab">New</a></li>
					</ul>	
                                                <div id="myTabContent" class="tab-content">
                                                    <div class="tab-pane fade active in" id="list">
							<div class="table-responsive">
								<table class="table table-hover text-center">
									<thead>
										<tr>
											<th class="text-center">Id</th>
											<th class="text-center">Primer nombre</th>
											<th class="text-center">Segundo nombre</th>
											<th class="text-center">Primer apellido</th>
											<th class="text-center">Segundo apellido</th>
                                                                                        <th class="text-center">Cedula</th>
											<th class="text-center">Historia</th>
                                                                                        <th class="text-center">Lapsos</th>
										</tr>
									</thead>
									<tbody>
                                                                             <c:forEach var="es" items="${Estudiantesl}">
                                                                                <tr>
                                                                                        <td>${es.getId_p_e()}</td>
											<td>${es.getNombre1()}</td>
											<td>${es.getNombre2()}</td>
											<td>${es.getApellido1()}</td>
                                                                                        <td>${es.getApellido2()}</td>
											<td>${es.getCedula()}</td>											
                                                                                <% if (Controlador.Rol_usuario(1, request)){%>                                                                                             
                                                                                <td><a href="Controlador?menu=EstudianteHistoria=Listar" class="btn btn-primary btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i>Historial</a></td>
                                                                                <td><a href="Controlador?menu=EstudianteLapsos=Listar" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i>1</a></td>
                                                                                <td><a href="Controlador?menu=EstudianteLapsos=Listar" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i>2</a></td>
                                                                                <td><a href="Controlador?menu=EstudianteLapsos=Listar" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i>3</a></td>
                                                                                <td><a href="Controlador?menu=EstudianteLapsos=Listar" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i>Final</a></td>
										<% } %>
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
									    <form action="Controlador?menu=EstudianteLapsos" name="formulario" method="POST">
									    	<div class="form-group label-floating">
											  <label id="error" class="control-label">Codigo de la materia</label>
                                                                                           <input class="form-control" type="text" value="${asignatura.getCodigo()}" name="codigo_asig">
											</div>
                                                                                        <div class="form-group label-floating">
											  <label class="control-label">Nombre de la materia</label>
											  <input class="form-control" type="text" value="${asignatura.getNombre()}" name="nombre_asig">
											</div>
                                                                                        <div class="form-group label-floating">
											  <label class="control-label">Calificacion minima</label>
											  <input class="form-control" type="text" value="${asignatura.getMinimo()}" name="minimo_asig">
											</div>
                                                                                        <div class="form-group label-floating">
											  <label class="control-label">Calificacion maxima</label>
											  <input class="form-control" type="text" value="${asignatura.getMaximo()}" name="maximo_asig">
											</div>
                                                                                        <div class="form-group label-floating">
											  <label class="control-label">Estatus</label>
											  <input class="form-control" type="text" value="${asignatura.getEstatus()}" name="estatus_asig">
											</div>											                                                                                       
											
										    </div>
										    <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                                                                                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
									    </form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Notifications area -->
	<section class="full-box Notifications-area">
		<div class="full-box Notifications-bg btn-Notifications-area"></div>
		<div class="full-box Notifications-body">
			<div class="Notifications-body-title text-titles text-center">
				Notifications <i class="zmdi zmdi-close btn-Notifications-area"></i>
			</div>
			<div class="list-group">
			  	<div class="list-group-item">
				    <div class="row-action-primary">
				      	<i class="zmdi zmdi-alert-triangle"></i>
				    </div>
				    <div class="row-content">
				      	<div class="least-content">17m</div>
				      	<h4 class="list-group-item-heading">Tile with a label</h4>
				      	<p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus.</p>
				    </div>
			  	</div>
			  	<div class="list-group-separator"></div>
			  	<div class="list-group-item">
				    <div class="row-action-primary">
				      	<i class="zmdi zmdi-alert-octagon"></i>
				    </div>
				    <div class="row-content">
				      	<div class="least-content">15m</div>
				      	<h4 class="list-group-item-heading">Tile with a label</h4>
				      	<p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus.</p>
				    </div>
			  	</div>
			  	<div class="list-group-separator"></div>
				<div class="list-group-item">
				    <div class="row-action-primary">
				      	<i class="zmdi zmdi-help"></i>
				    </div>
				    <div class="row-content">
				      	<div class="least-content">10m</div>
				      	<h4 class="list-group-item-heading">Tile with a label</h4>
				      	<p class="list-group-item-text">Maecenas sed diam eget risus varius blandit.</p>
				    </div>
				</div>
			  	<div class="list-group-separator"></div>
			  	<div class="list-group-item">
				    <div class="row-action-primary">
				      	<i class="zmdi zmdi-info"></i>
				    </div>
				    <div class="row-content">
				      	<div class="least-content">8m</div>
				      	<h4 class="list-group-item-heading">Tile with a label</h4>
				      	<p class="list-group-item-text">Maecenas sed diam eget risus varius blandit.</p>
				    </div>
			  	</div>
			</div>

		</div>
	</section>

	<!-- Dialog help -->
	<div class="modal fade" tabindex="-1" role="dialog" id="Dialog-Help">
	  	<div class="modal-dialog" role="document">
		    <div class="modal-content">
			    <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			    	<h4 class="modal-title">Help</h4>
			    </div>
			    <div class="modal-body">
			        <p>
			        	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nesciunt beatae esse velit ipsa sunt incidunt aut voluptas, nihil reiciendis maiores eaque hic vitae saepe voluptatibus. Ratione veritatis a unde autem!
			        </p>
			    </div>
		      	<div class="modal-footer">
		        	<button type="button" class="btn btn-primary btn-raised" data-dismiss="modal"><i class="zmdi zmdi-thumb-up"></i> Ok</button>
		      	</div>
		    </div>
	  	</div>
	</div>
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
</body>
</html>