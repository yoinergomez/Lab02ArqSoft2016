package co.edu.udea.modelo;

import co.edu.udea.modelo.Estudiante;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-09T10:04:40")
@StaticMetamodel(Carrera.class)
public class Carrera_ { 

    public static volatile CollectionAttribute<Carrera, Estudiante> estudianteCollection;
    public static volatile SingularAttribute<Carrera, Integer> id;
    public static volatile SingularAttribute<Carrera, String> nombre;

}