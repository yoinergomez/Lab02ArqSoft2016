package co.edu.udea.modelo;

import co.edu.udea.modelo.Estudiante;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-09T10:04:40")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile CollectionAttribute<Materia, Estudiante> estudianteCollection;
    public static volatile SingularAttribute<Materia, Integer> codigo;
    public static volatile SingularAttribute<Materia, String> horario;
    public static volatile SingularAttribute<Materia, String> nombre;
    public static volatile SingularAttribute<Materia, Integer> cupo;

}