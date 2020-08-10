package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Asignaturas;
import models.Secciones;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-08T18:10:29")
@StaticMetamodel(PaquetesMaterias.class)
public class PaquetesMaterias_ { 

    public static volatile SingularAttribute<PaquetesMaterias, Integer> idPaqueteMaterias;
    public static volatile SingularAttribute<PaquetesMaterias, Secciones> seccionIdSeccion;
    public static volatile SingularAttribute<PaquetesMaterias, Asignaturas> asignaturasIdAsignatura;

}