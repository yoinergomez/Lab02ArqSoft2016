package co.edu.udea.modelo;

import co.edu.udea.modelo.Carrera;
import co.edu.udea.modelo.Materia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-09T10:04:40")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ { 

    public static volatile SingularAttribute<Estudiante, String> apellido;
    public static volatile SingularAttribute<Estudiante, String> documento;
    public static volatile CollectionAttribute<Estudiante, Materia> materiaCollection;
    public static volatile SingularAttribute<Estudiante, Carrera> carrera;
    public static volatile SingularAttribute<Estudiante, String> nombre;

}