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
public class Asignatura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "asignaturas")
    private Set<Curso> cursos;

    @ManyToMany
    @JoinTable(
        name = "asignatura_profesor",
        joinColumns = @JoinColumn(name = "asignatura_id"),
        inverseJoinColumns = @JoinColumn(name = "profesor_id")
    )
    private Set<Profesor> profesores;

    
    public Asignatura() {}

    public Asignatura(Long id, String nombre, Set<Curso> cursos, Set<Profesor> profesores) {
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

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    

    
    


}
