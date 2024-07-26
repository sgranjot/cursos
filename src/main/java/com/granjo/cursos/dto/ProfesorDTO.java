package com.granjo.cursos.dto;

import java.util.Set;

public class ProfesorDTO extends PersonaDTO{

    private DireccionDTO direccion;
    private Set<AsignaturaDTO> asignaturas;
    private CentroFormacionDTO centroFormacion;
    
    public ProfesorDTO() {
    }

    public ProfesorDTO(Long id, String nombre, String apellidos, String dni, String telefono, DireccionDTO direccion,
            Set<AsignaturaDTO> asignaturas, CentroFormacionDTO centroFormacion) {
        super(id, nombre, apellidos, dni, telefono);
        this.direccion = direccion;
        this.asignaturas = asignaturas;
        this.centroFormacion = centroFormacion;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

    public Set<AsignaturaDTO> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Set<AsignaturaDTO> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public CentroFormacionDTO getCentroFormacion() {
        return centroFormacion;
    }

    public void setCentroFormacion(CentroFormacionDTO centroFormacion) {
        this.centroFormacion = centroFormacion;
    }

    



    
    

}
