package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.DocentesMaterias;
import models.PaquetesMaterias;
import models.PlanEvaluacion;
import models.Status;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-08T18:10:29")
@StaticMetamodel(Asignaturas.class)
public class Asignaturas_ { 

    public static volatile ListAttribute<Asignaturas, DocentesMaterias> docentesMateriasList;
    public static volatile SingularAttribute<Asignaturas, String> codigo;
    public static volatile SingularAttribute<Asignaturas, Double> minimo;
    public static volatile ListAttribute<Asignaturas, PaquetesMaterias> paquetesMateriasList;
    public static volatile SingularAttribute<Asignaturas, Double> maximo;
    public static volatile SingularAttribute<Asignaturas, Status> statusIdStatus;
    public static volatile ListAttribute<Asignaturas, PlanEvaluacion> planEvaluacionList;
    public static volatile SingularAttribute<Asignaturas, Integer> idAsignatura;
    public static volatile SingularAttribute<Asignaturas, String> nombre;

}