
package co.edu.udea.controller;

import co.edu.udea.logica.EstudianteFacadeLocal;
import java.io.Serializable;
import co.edu.udea.logica.MateriaFacadeLocal;
import co.edu.udea.modelo.Estudiante;
import co.edu.udea.modelo.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;

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
    
    
    @PostConstruct
    public void init() {
        listaMaterias = materiaDAO.findAll();
        copiaListaMaterias=listaMaterias;
        listaMateriasMatriculadas=new ArrayList<>();
        estudiante=estudianteDAO.find(cedula);
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
    
    
    public void agregarMateria() {
        int codigo=0;
        if(!codigoStr.equalsIgnoreCase("") && codigoStr!=null){
            codigo=Integer.parseInt(codigoStr);
            Materia m=materiaDAO.find(codigo);
            if(m!=null && copiaListaMaterias.contains(m)){
               listaMateriasMatriculadas.add(m);
               copiaListaMaterias.remove(m);
            }else{
                //crear FaceMessage
                System.out.println("materia no encontrada");
            }
        }
    }
    
    public void terminarMatricula(){
        estudiante.setMateriaCollection(listaMateriasMatriculadas);
        estudianteDAO.edit(estudiante);
        
    }
    
    
}
