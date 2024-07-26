package com.granjo.cursos.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Alumno extends Persona {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id", nullable = false)
    private Direccion direccion;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private Set<Calificacion> calificaciones;

    @ManyToOne
    @JoinColumn(name = "centroFormacion_id", nullable = false)
    private CentroFormacion centroFormacion;

    @ManyToMany
    @JoinTable(
        name = "alumno_curso",
        joinColumns = @JoinColumn(name = "alumno_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private Set<Curso> cursos;


    public Alumno() {}

    public Alumno(String nombre, String apellidos, String dni, String telefono, Direccion direccion, Set<Calificacion> calificaciones, CentroFormacion centroFormacion,
            Set<Curso> cursos) {
        super(nombre, apellidos, dni, telefono);
        this.direccion = direccion;
        this.calificaciones = calificaciones;
        this.centroFormacion = centroFormacion;
        this.cursos = cursos;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Set<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Set<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public CentroFormacion getCentroFormacion() {
        return centroFormacion;
    }

    public void setCentroFormacion(CentroFormacion centroFormacion) {
        this.centroFormacion = centroFormacion;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    

    

    



}
