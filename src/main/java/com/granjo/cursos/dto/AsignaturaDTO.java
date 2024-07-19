package com.granjo.cursos.dto;

import java.util.Set;

public class AsignaturaDTO {

    private Long id;
    private String nombre;
    private Set<CursoDTO> cursos;
    private Set<ProfesorDTO> profesores;
    
    public AsignaturaDTO() {
    }

    public AsignaturaDTO(Long id, String nombre, Set<CursoDTO> cursos, Set<ProfesorDTO> profesores) {
        this.id = id;
        this.nombre = nombre;
        this.cursos = cursos;
        this.profesores = profesores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<CursoDTO> getCursos() {
        return cursos;
    }

    public void setCursos(Set<CursoDTO> cursos) {
        this.cursos = cursos;
    }

    public Set<ProfesorDTO> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<ProfesorDTO> profesores) {
        this.profesores = profesores;
    }

    

    
    


}
