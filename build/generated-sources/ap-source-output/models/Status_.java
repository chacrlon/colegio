package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Asignaturas;
import models.Docentes;
import models.Estudiantes;
import models.Periodo;
import models.Secciones;
import models.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-08T18:10:29")
@StaticMetamodel(Status.class)
public class Status_ { 

    public static volatile SingularAttribute<Status, Integer> idStatus;
    public static volatile SingularAttribute<Status, String> descripcion;
    public static volatile ListAttribute<Status, Usuarios> usuariosList;
    public static volatile ListAttribute<Status, Estudiantes> estudiantesList;
    public static volatile ListAttribute<Status, Docentes> docentesList;
    public static volatile ListAttribute<Status, Periodo> periodoList;
    public static volatile ListAttribute<Status, Asignaturas> asignaturasList;
    public static volatile ListAttribute<Status, Secciones> seccionesList;

}