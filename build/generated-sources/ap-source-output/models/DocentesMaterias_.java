package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Asignaturas;
import models.Docentes;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-08T18:10:29")
@StaticMetamodel(DocentesMaterias.class)
public class DocentesMaterias_ { 

    public static volatile SingularAttribute<DocentesMaterias, Docentes> docentesIdDocentes;
    public static volatile SingularAttribute<DocentesMaterias, Asignaturas> asignaturasIdAsignatura;
    public static volatile SingularAttribute<DocentesMaterias, Integer> idDocentesMaterias;

}