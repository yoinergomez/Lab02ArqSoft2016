package co.edu.udea.logica;

import co.edu.udea.modelo.Carrera;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CarreraFacadeLocal {

    void create(Carrera carrera);

    void edit(Carrera carrera);

    void remove(Carrera carrera);

    Carrera find(Object id);

    List<Carrera> findAll();

    List<Carrera> findRange(int[] range);

    int count();
    
}
