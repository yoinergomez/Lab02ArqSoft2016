package co.edu.udea.controller;

import co.edu.udea.logica.CarreraFacadeLocal;
import co.edu.udea.modelo.Carrera;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

public class CarreraBean implements Serializable{
    
    @EJB
    private CarreraFacadeLocal carreraDAO;
    private List<Carrera> carrerasList;
    
    public CarreraBean() {
        
    }
    
    @PostConstruct
    public void init(){
        carrerasList = carreraDAO.findAll();
    }

    public List<Carrera> getCarrerasList() {
        return carrerasList;
    }

    public void setCarrerasList(List<Carrera> carrerasList) {
        this.carrerasList = carrerasList;
    }
    
    
}
