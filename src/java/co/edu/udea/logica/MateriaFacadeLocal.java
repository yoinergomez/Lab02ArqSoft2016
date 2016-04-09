package co.edu.udea.logica;

import co.edu.udea.modelo.Materia;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MateriaFacadeLocal {

    void create(Materia materia);

    void edit(Materia materia);

    void remove(Materia materia);

    Materia find(Object id);

    List<Materia> findAll();

    List<Materia> findRange(int[] range);

    int count();
    
}
