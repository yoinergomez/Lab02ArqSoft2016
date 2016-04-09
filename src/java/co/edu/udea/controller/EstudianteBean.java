package co.edu.udea.controller;

import co.edu.udea.logica.EstudianteFacadeLocal;
import java.io.Serializable;
import co.edu.udea.modelo.Estudiante;
import co.edu.udea.modelo.Materia;
import java.awt.Event;
import java.util.ArrayList;
import java.util.Collection;
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
    private String desabilitarVerMatricula;
    private String desabilitarMatricula;

    @PostConstruct
    public void init() {
        studentList = estudianteDAO.findAll();
    }

    public EstudianteBean() {
        desabilitarVerMatricula = "none";
        desabilitarMatricula = "none";
    }

    public void matricularEstudiante() {
        System.out.println(cedula);
        Estudiante estudiante = estudianteDAO.find(cedula);
        if (estudiante != null) {
            studentList.clear();
            studentList.add(estudiante);
            Collection<Materia> materiaEstudiante = estudiante.getMateriaCollection();
            
            // El estudiante esta matriculado?
            if(materiaEstudiante.isEmpty()){
               desabilitarMatricula = "block";
               desabilitarVerMatricula = "none";
            } else {
               desabilitarMatricula = "none";
               desabilitarVerMatricula = "block";
            }
        } else{
            desabilitarMatricula = "none";
            desabilitarVerMatricula = "none";
        }
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

    public String getDesabilitarVerMatricula() {
        return desabilitarVerMatricula;
    }

    public void setDesabilitarVerMatricula(String desabilitarVerMatricula) {
        this.desabilitarVerMatricula = desabilitarVerMatricula;
    }

    public String getDesabilitarMatricula() {
        return desabilitarMatricula;
    }

    public void setDesabilitarMatricula(String desabilitarMatricula) {
        this.desabilitarMatricula = desabilitarMatricula;
    } 
}
