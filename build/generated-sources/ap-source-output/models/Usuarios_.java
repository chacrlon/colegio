package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Docentes;
import models.Estudiantes;
import models.Status;
import models.UsuariosRoles;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-27T22:34:14")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> nick;
    public static volatile SingularAttribute<Usuarios, String> password;
    public static volatile ListAttribute<Usuarios, Estudiantes> estudiantesList;
    public static volatile ListAttribute<Usuarios, Docentes> docentesList;
    public static volatile SingularAttribute<Usuarios, Integer> idUsuario;
    public static volatile SingularAttribute<Usuarios, Status> statusIdStatus;
    public static volatile ListAttribute<Usuarios, UsuariosRoles> usuariosRolesList;

}