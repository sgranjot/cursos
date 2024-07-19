package com.granjo.cursos.dto;

import java.util.Set;

import com.granjo.cursos.model.Alumno;

public class CursoDTO {

    private Long id;
    private String nombre;
    private int horas;
    private Set<Alumno> alumnos;
    private Set<AsignaturaDTO> asignaturas;
    
    public CursoDTO() {
    }

    public CursoDTO(Long id, String nombre, int horas, Set<Alumno> alumnos, Set<AsignaturaDTO> asignaturas) {
        this.id = id;
        this.nombre = nombre;
        this.horas = horas;
        this.alumnos = alumnos;
        this.asignaturas = asignaturas;
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

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Set<AsignaturaDTO> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Set<AsignaturaDTO> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    

}
