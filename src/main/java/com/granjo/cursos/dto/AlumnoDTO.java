package com.granjo.cursos.dto;

import java.util.Set;


public class AlumnoDTO extends PersonaDTO{

    private DireccionDTO direccion;
    private Set<CalificacionDTO> calificaciones;
    private CentroFormacionDTO centroFormacion;
    private Set<CursoDTO> cursos;

    public AlumnoDTO() {
    }

    public AlumnoDTO(Long id, String nombre, String apellidos, String dni, String telefono, DireccionDTO direccion, Set<CalificacionDTO> calificaciones, CentroFormacionDTO centroFormacion,
            Set<CursoDTO> cursos) {
        super(id, nombre, apellidos, dni, telefono);
        this.direccion = direccion;
        this.calificaciones = calificaciones;
        this.centroFormacion = centroFormacion;
        this.cursos = cursos;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

    public Set<CalificacionDTO> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Set<CalificacionDTO> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public CentroFormacionDTO getCentroFormacion() {
        return centroFormacion;
    }

    public void setCentroFormacion(CentroFormacionDTO centroFormacion) {
        this.centroFormacion = centroFormacion;
    }

    public Set<CursoDTO> getCursos() {
        return cursos;
    }

    public void setCursos(Set<CursoDTO> cursos) {
        this.cursos = cursos;
    }

    

    

    



}
