package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Docentes;
import models.PlanEvaluacion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-27T22:34:14")
@StaticMetamodel(Calificacion.class)
public class Calificacion_ { 

    public static volatile SingularAttribute<Calificacion, Double> calificacion;
    public static volatile SingularAttribute<Calificacion, String> fechaCarga;
    public static volatile SingularAttribute<Calificacion, Docentes> docentesIdDocentes;
    public static volatile SingularAttribute<Calificacion, Integer> idCalificacion;
    public static volatile SingularAttribute<Calificacion, PlanEvaluacion> planEvaluacionIdPlanEvaluacion;

}