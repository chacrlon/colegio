package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.EstudiantesSecciones;
import models.Status;
import models.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-08T18:10:29")
@StaticMetamodel(Estudiantes.class)
public class Estudiantes_ { 

    public static volatile SingularAttribute<Estudiantes, String> apellido2;
    public static volatile SingularAttribute<Estudiantes, String> procedencia;
    public static volatile SingularAttribute<Estudiantes, String> apellido1;
    public static volatile SingularAttribute<Estudiantes, String> cedula;
    public static volatile SingularAttribute<Estudiantes, String> direccion;
    public static volatile SingularAttribute<Estudiantes, Status> statusIdStatus;
    public static volatile ListAttribute<Estudiantes, EstudiantesSecciones> estudiantesSeccionesList;
    public static volatile SingularAttribute<Estudiantes, String> nombre2;
    public static volatile SingularAttribute<Estudiantes, String> nombre1;
    public static volatile SingularAttribute<Estudiantes, String> nacionalidad;
    public static volatile SingularAttribute<Estudiantes, Integer> idEstudiantes;
    public static volatile SingularAttribute<Estudiantes, String> cedulaR;
    public static volatile SingularAttribute<Estudiantes, String> fecha;
    public static volatile SingularAttribute<Estudiantes, Usuarios> usuariosIdUsuario;
    public static volatile SingularAttribute<Estudiantes, String> correo;
    public static volatile SingularAttribute<Estudiantes, String> celular;
    public static volatile SingularAttribute<Estudiantes, String> sexo;
    public static volatile SingularAttribute<Estudiantes, String> telefono;
    public static volatile SingularAttribute<Estudiantes, String> anio;

}