package co.edu.udea.controller;

import co.edu.udea.logica.MateriaFacadeLocal;
import co.edu.udea.modelo.Materia;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

public class MateriaBean {

    @EJB
    private MateriaFacadeLocal materiaDAO;
    private List<Materia> materiaList;
    
    public MateriaBean() {
    }
    
    @PostConstruct
    public void init(){
        materiaList = materiaDAO.findAll();
    }

    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
    }
}
