/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.controller;

import co.edu.udea.logica.EstudianteFacadeLocal;
import co.edu.udea.modelo.Estudiante;
import co.edu.udea.modelo.Materia;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author esteban
 */
public class DetalleMatriculaBean {

    @EJB
    private EstudianteFacadeLocal estudianteDAO;
    private Estudiante estudiante;
    private List<Materia> materiasMatriculadas; 
    private String qr;

    /**
     * Creates a new instance of DetalleMatriculaBean
     */
    
    private String cedula;
    
    @PostConstruct
    public void init(){
        estudiante = estudianteDAO.find(cedula);
        materiasMatriculadas = (List<Materia>) estudiante.getMateriaCollection();
        
        StringBuffer string = new StringBuffer();
        string.append(estudiante.getDocumento()).append("\n");
        string.append(estudiante.getNombre()).append("\n");
        string.append(estudiante.getApellido()).append("\n");
        
        for(Materia materia:materiasMatriculadas){
            string.append(materia.getCodigo()).append("\n");
            string.append(materia.getNombre()).append("\n");
        }
        qr = string.toString();
    }
    
    public DetalleMatriculaBean() {
        
    }
   
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<Materia> getMateriasMatriculadas() {
        return materiasMatriculadas;
    }

    public void setMateriasMatriculadas(List<Materia> materiasMatriculadas) {
        this.materiasMatriculadas = materiasMatriculadas;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }
    
    
    
}
