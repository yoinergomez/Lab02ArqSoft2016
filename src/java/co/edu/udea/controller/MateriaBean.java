package co.edu.udea.controller;

import co.edu.udea.logica.MateriaFacadeLocal;
import co.edu.udea.modelo.Materia;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

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
