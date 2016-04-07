
package co.edu.udea.controller;

import java.io.Serializable;
import co.edu.udea.logica.MateriaFacadeLocal;
import co.edu.udea.modelo.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

public class MatriculaBean implements Serializable{
    
    @EJB
    private MateriaFacadeLocal materiaDAO;
    private List<Materia> listaMaterias;
    private List<Materia> copiaListaMaterias;
    private List<Materia> listaMateriasMatriculadas;
    private String codigoStr;
    
    @PostConstruct
    public void init() {
        listaMaterias = materiaDAO.findAll();
        copiaListaMaterias=listaMaterias;
        listaMateriasMatriculadas=new ArrayList<>();
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

    
    public void agregarMateria() {
        int codigo=0;
        if(!codigoStr.equalsIgnoreCase("") && codigoStr!=null){
            codigo=Integer.parseInt(codigoStr);
            Materia m=materiaDAO.find(codigo);
            if(m!=null){
               listaMateriasMatriculadas.add(m);
               copiaListaMaterias.remove(m);
            }else{
                System.out.println("materia no encontrada");
            }
        }
        
     
    }
    
    
}
