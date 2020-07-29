package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Asignaturas;
import models.Calificacion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-27T22:34:14")
@StaticMetamodel(PlanEvaluacion.class)
public class PlanEvaluacion_ { 

    public static volatile SingularAttribute<PlanEvaluacion, Integer> numero;
    public static volatile SingularAttribute<PlanEvaluacion, Integer> peso;
    public static volatile SingularAttribute<PlanEvaluacion, Integer> idPlanEvaluacion;
    public static volatile SingularAttribute<PlanEvaluacion, String> titulo;
    public static volatile ListAttribute<PlanEvaluacion, Calificacion> calificacionList;
    public static volatile SingularAttribute<PlanEvaluacion, Integer> escala;
    public static volatile SingularAttribute<PlanEvaluacion, Asignaturas> asignaturasIdAsignatura;

}