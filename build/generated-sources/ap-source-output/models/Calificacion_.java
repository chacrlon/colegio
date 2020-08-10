package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Docentes;
import models.PlanEvaluacion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-08T18:10:29")
@StaticMetamodel(Calificacion.class)
public class Calificacion_ { 

    public static volatile SingularAttribute<Calificacion, Double> calificacion;
    public static volatile SingularAttribute<Calificacion, String> fechaCarga;
    public static volatile SingularAttribute<Calificacion, Docentes> docentesIdDocentes;
    public static volatile SingularAttribute<Calificacion, Integer> idCalificacion;
    public static volatile SingularAttribute<Calificacion, PlanEvaluacion> planEvaluacionIdPlanEvaluacion;

}