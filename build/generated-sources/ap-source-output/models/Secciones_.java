package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.EstudiantesSecciones;
import models.PaquetesMaterias;
import models.PeriodosSecciones;
import models.Status;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-27T22:34:14")
@StaticMetamodel(Secciones.class)
public class Secciones_ { 

    public static volatile ListAttribute<Secciones, PeriodosSecciones> periodosSeccionesList;
    public static volatile SingularAttribute<Secciones, String> codigo;
    public static volatile ListAttribute<Secciones, PaquetesMaterias> paquetesMateriasList;
    public static volatile SingularAttribute<Secciones, Status> statusIdStatus;
    public static volatile ListAttribute<Secciones, EstudiantesSecciones> estudiantesSeccionesList;
    public static volatile SingularAttribute<Secciones, Integer> idSeccion;
    public static volatile SingularAttribute<Secciones, String> nombre;

}