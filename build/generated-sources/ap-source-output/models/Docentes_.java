package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Calificacion;
import models.DocentesMaterias;
import models.Status;
import models.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-27T22:34:14")
@StaticMetamodel(Docentes.class)
public class Docentes_ { 

    public static volatile ListAttribute<Docentes, DocentesMaterias> docentesMateriasList;
    public static volatile SingularAttribute<Docentes, String> apellido2;
    public static volatile SingularAttribute<Docentes, String> apellido1;
    public static volatile SingularAttribute<Docentes, String> cedula;
    public static volatile SingularAttribute<Docentes, String> direccion;
    public static volatile SingularAttribute<Docentes, Status> statusIdStatus;
    public static volatile SingularAttribute<Docentes, String> nombre2;
    public static volatile SingularAttribute<Docentes, Integer> idDocentes;
    public static volatile SingularAttribute<Docentes, String> nombre1;
    public static volatile SingularAttribute<Docentes, String> nacionalidad;
    public static volatile SingularAttribute<Docentes, String> fecha;
    public static volatile SingularAttribute<Docentes, Usuarios> usuariosIdUsuario;
    public static volatile SingularAttribute<Docentes, String> correo;
    public static volatile SingularAttribute<Docentes, String> celular;
    public static volatile SingularAttribute<Docentes, String> sexo;
    public static volatile SingularAttribute<Docentes, String> telefono;
    public static volatile ListAttribute<Docentes, Calificacion> calificacionList;

}