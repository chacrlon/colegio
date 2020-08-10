package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.PeriodosSecciones;
import models.Status;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-08T18:10:29")
@StaticMetamodel(Periodo.class)
public class Periodo_ { 

    public static volatile ListAttribute<Periodo, PeriodosSecciones> periodosSeccionesList;
    public static volatile SingularAttribute<Periodo, String> fechaInicio;
    public static volatile SingularAttribute<Periodo, Status> statusIdStatus;
    public static volatile SingularAttribute<Periodo, Integer> idPeriodo;
    public static volatile SingularAttribute<Periodo, String> nombre;
    public static volatile SingularAttribute<Periodo, String> fechaFin;
    public static volatile SingularAttribute<Periodo, Integer> anio;

}