package com.granjo.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.granjo.cursos.model.CentroFormacion;

public interface ICentroFormacionDao extends JpaRepository <CentroFormacion, Long>{

}
