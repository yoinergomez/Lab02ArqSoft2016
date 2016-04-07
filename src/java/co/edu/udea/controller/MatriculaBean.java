
package co.edu.udea.controller;

import java.io.Serializable;
import co.edu.udea.logica.MateriaFacadeLocal;
import javax.ejb.EJB;

public class MatriculaBean implements Serializable{
    
    @EJB
    private MateriaFacadeLocal materiaDAO;
    
    public MatriculaBean() {
    }
    
}
