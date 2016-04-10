
package co.edu.udea.controller;

import co.edu.udea.logica.EstudianteFacadeLocal;
import java.io.Serializable;
import co.edu.udea.logica.MateriaFacadeLocal;
import co.edu.udea.modelo.Estudiante;
import co.edu.udea.modelo.Materia;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class MatriculaBean implements Serializable{
    
    @EJB
    private MateriaFacadeLocal materiaDAO;
    @EJB
    private EstudianteFacadeLocal estudianteDAO;
    private List<Materia> listaMaterias;
    private List<Materia> copiaListaMaterias;
    private List<Materia> listaMateriasMatriculadas;
    private String codigoStr;
    private Estudiante estudiante; 
    private String cedula;

    private boolean mostrarPanelCaptcha;
    private boolean desactivarAgregarMateriaBoton;
    private boolean desactivarRegistrarMateriaBoton;

    
    private UIComponent codigoMateria;
    
    
    
    
    @PostConstruct
    public void init() {
        listaMaterias = materiaDAO.findAll();
        copiaListaMaterias=listaMaterias;
        listaMateriasMatriculadas=new ArrayList<>();
        estudiante=estudianteDAO.find(cedula);

        mostrarPanelCaptcha=false;
        desactivarAgregarMateriaBoton=false;
        desactivarRegistrarMateriaBoton=true;
        
    }
    public MatriculaBean() {
        
    }

    public List<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(List<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public String getCodigoStr() {
        return codigoStr;
    }

    public void setCodigoStr(String codigoStr) {
        this.codigoStr = codigoStr;
    }

    public List<Materia> getCopiaListaMaterias() {
        return copiaListaMaterias;
    }

    public void setCopiaListaMaterias(List<Materia> copiaListaMaterias) {
        this.copiaListaMaterias = copiaListaMaterias;
    }

    public List<Materia> getListaMateriasMatriculadas() {
        return listaMateriasMatriculadas;
    }

    public void setListaMateriasMatriculadas(List<Materia> listaMateriasMatriculadas) {
        this.listaMateriasMatriculadas = listaMateriasMatriculadas;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


    public boolean isMostrarPanelCaptcha() {
        return mostrarPanelCaptcha;
    }

    public void setMostrarPanelCaptcha(boolean mostrarPanelCaptcha) {
        this.mostrarPanelCaptcha = mostrarPanelCaptcha;
    }

    public UIComponent getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(UIComponent codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public boolean isDesactivarAgregarMateriaBoton() {
        return desactivarAgregarMateriaBoton;
    }

    public void setDesactivarAgregarMateriaBoton(boolean desactivarAgregarMateriaBoton) {
        this.desactivarAgregarMateriaBoton = desactivarAgregarMateriaBoton;
    }

    public boolean isDesactivarRegistrarMateriaBoton() {
        return desactivarRegistrarMateriaBoton;
    }

    public void setDesactivarRegistrarMateriaBoton(boolean desactivarRegistrarMateriaBoton) {
        this.desactivarRegistrarMateriaBoton = desactivarRegistrarMateriaBoton;
    }

    
    
    public void agregarMateria() {
        int codigo=0;
        if(!codigoStr.equalsIgnoreCase("") && codigoStr!=null){
            codigo=Integer.parseInt(codigoStr);
            Materia m=materiaDAO.find(codigo);
            if(m!=null && copiaListaMaterias.contains(m)){
               listaMateriasMatriculadas.add(m);
               copiaListaMaterias.remove(m);
               desactivarRegistrarMateriaBoton=false;
            }else{
                FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Materia no encontrada en la lista de oferta",null);
                FacesContext context=FacesContext.getCurrentInstance();
                context.addMessage(codigoMateria.getClientId(context), message);
            }
        }
    }
    

    public void registrarMaterias(){
        mostrarPanelCaptcha=true;
        desactivarAgregarMateriaBoton=true;
        desactivarRegistrarMateriaBoton=true;
        
    }
    
    public void terminarMatricula(){
        estudiante.setMateriaCollection(listaMateriasMatriculadas);
        estudianteDAO.edit(estudiante);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
          try{
              ec.redirect("faces/result.xhtml");
          }catch(IOException e){
              System.out.println(e.getMessage());
          }     
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
