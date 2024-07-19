package com.granjo.cursos.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class CentroFormacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id", nullable = false)
    private Direccion direccion;

    @OneToMany(mappedBy = "centroFormacion", cascade = CascadeType.ALL)
    private Set<Alumno> alumnos;

    @OneToMany(mappedBy = "centroFormacion", cascade = CascadeType.ALL)
    private Set<Profesor> profesores;
    
    
    public CentroFormacion() {
    }

    public CentroFormacion(Long id, String nombre, Direccion direccion, Set<Alumno> alumnos, Set<Profesor> profesores) {
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    

}
