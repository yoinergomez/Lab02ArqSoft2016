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
    private int codigo = 0;
    private String nombre ="";
    private int cupo=0;
    private String horario="";

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
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
    
    public void guardarMateria(){
        Materia asignatura =  new Materia(codigo, nombre, cupo);
        materiaDAO.create(asignatura);
    }
    
}
