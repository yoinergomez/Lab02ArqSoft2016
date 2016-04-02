package co.edu.udea.logica;

import co.edu.udea.modelo.Estudiante;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EstudianteFacadeLocal {

    void create(Estudiante estudiante);

    void edit(Estudiante estudiante);

    void remove(Estudiante estudiante);

    Estudiante find(Object id);

    List<Estudiante> findAll();

    List<Estudiante> findRange(int[] range);

    int count();
    
}
