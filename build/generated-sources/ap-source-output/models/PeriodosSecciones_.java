package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Periodo;
import models.Secciones;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-27T22:34:13")
@StaticMetamodel(PeriodosSecciones.class)
public class PeriodosSecciones_ { 

    public static volatile SingularAttribute<PeriodosSecciones, Integer> idPeriodosSecciones;
    public static volatile SingularAttribute<PeriodosSecciones, Periodo> periodoIdPeriodo;
    public static volatile SingularAttribute<PeriodosSecciones, Secciones> seccionesIdSeccion;

}