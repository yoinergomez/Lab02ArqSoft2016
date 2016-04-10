package co.edu.udea.controller;

import co.edu.udea.logica.CarreraFacadeLocal;
import co.edu.udea.modelo.Carrera;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

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
    
    //Internacionalización
    private Locale locale =  FacesContext.getCurrentInstance().getViewRoot().getLocale();
    public Locale getLocale(){
        return locale;
    }
    public String getLanguage(){
        return locale.getLanguage();
    }
    public void changeLanguage(String language){
        locale=new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
        
    } 
}
