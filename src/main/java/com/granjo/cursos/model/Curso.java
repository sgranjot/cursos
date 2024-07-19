package com.granjo.cursos.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private int horas;

    @ManyToMany(mappedBy = "cursos")
    private Set<Alumno> alumnos;

    @ManyToMany
    @JoinTable(
        name = "curso_asignatura",
        joinColumns = @JoinColumn(name="curso_id"),
        inverseJoinColumns = @JoinColumn(name="asignatura_id")
    )
    private Set<Asignatura> asignaturas;
    
    
    public Curso() {
    }

    public Curso(Long id, String nombre, int horas, Set<Alumno> alumnos, Set<Asignatura> asignaturas) {
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

    public Set<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Set<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    

}
