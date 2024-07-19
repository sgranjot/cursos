package com.granjo.cursos.dto;

public class CalificacionDTO {

    private Long id;
    private AlumnoDTO alumno;
    private AsignaturaDTO asignatura;
    private double nota;
    
    public CalificacionDTO() {
    }

    public CalificacionDTO(Long id, AlumnoDTO alumno, AsignaturaDTO asignatura, double nota) {
        this.id = id;
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AlumnoDTO getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoDTO alumno) {
        this.alumno = alumno;
    }

    public AsignaturaDTO getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(AsignaturaDTO asignatura) {
        this.asignatura = asignatura;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    

}
