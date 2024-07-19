package com.granjo.cursos.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Profesor extends Persona {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id", nullable = false)
    private Direccion direccion;

    @ManyToMany(mappedBy="profesores")
    private Set<Asignatura> asignaturas;

    @ManyToOne
    @JoinColumn(name = "centroFormacion_id", nullable = false)
    private CentroFormacion centroFormacion;

    
    public Profesor() {
    }

    public Profesor(String nombre, String apellidos, String dni, String telefono, Direccion direccion,
            Set<Asignatura> asignaturas, CentroFormacion centroFormacion) {
        super(nombre, apellidos, dni, telefono);
        this.direccion = direccion;
        this.asignaturas = asignaturas;
        this.centroFormacion = centroFormacion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Set<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Set<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public CentroFormacion getCentroFormacion() {
        return centroFormacion;
    }

    public void setCentroFormacion(CentroFormacion centroFormacion) {
        this.centroFormacion = centroFormacion;
    }

    



    
    

}
