package co.edu.udea.controller;

import co.edu.udea.logica.EstudianteFacadeLocal;
import java.io.Serializable;
import co.edu.udea.modelo.Estudiante;
import java.awt.Event;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class EstudianteBean implements Serializable {

    @EJB
    private EstudianteFacadeLocal estudianteDAO;
    private List<Estudiante> studentList;
    
    private String cedula;

    @PostConstruct
    public void init() {
        studentList = estudianteDAO.findAll();
    }

    public EstudianteBean() {

    }

    public void matricularEstudiante() {
        System.out.println(cedula);
    }
    
    public List<Estudiante> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Estudiante> studentList) {
        this.studentList = studentList;
    }

    public void mensajes(Event e) {
        FacesMessage msg = new FacesMessage("Swiped Left", "nose");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
