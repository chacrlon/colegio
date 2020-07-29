package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Estudiantes;
import models.Secciones;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-27T22:34:13")
@StaticMetamodel(EstudiantesSecciones.class)
public class EstudiantesSecciones_ { 

    public static volatile SingularAttribute<EstudiantesSecciones, Integer> idestudiantesSecciones;
    public static volatile SingularAttribute<EstudiantesSecciones, Secciones> seccionesIdSeccion;
    public static volatile SingularAttribute<EstudiantesSecciones, Estudiantes> estudiantesIdPE;

}