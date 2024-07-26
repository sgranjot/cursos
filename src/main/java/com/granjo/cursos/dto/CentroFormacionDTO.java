package com.granjo.cursos.dto;

import java.util.Set;


public class CentroFormacionDTO {

    private Long id;
    private String nombre;
    private DireccionDTO direccion;
    private Set<AlumnoDTO> alumnos;
    private Set<ProfesorDTO> profesores;
    
    public CentroFormacionDTO() {
    }

    public CentroFormacionDTO(Long id, String nombre, DireccionDTO direccion, Set<AlumnoDTO> alumnos,
            Set<ProfesorDTO> profesores) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.alumnos = alumnos;
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

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

    public Set<AlumnoDTO> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<AlumnoDTO> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<ProfesorDTO> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<ProfesorDTO> profesores) {
        this.profesores = profesores;
    }

   

    

}
