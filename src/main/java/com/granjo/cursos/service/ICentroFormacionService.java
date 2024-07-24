package com.granjo.cursos.service;

import java.util.List;
import java.util.Optional;

import com.granjo.cursos.model.CentroFormacion;

public interface ICentroFormacionService {

    public CentroFormacion createCentro(CentroFormacion centroFormacion);

    public List<CentroFormacion> findAllCentros ();
    
    public Optional<CentroFormacion> findCentroById(Long id);

    public CentroFormacion updateCentro(Long id, CentroFormacion centroFormacion);

    public void deleteCentro(Long id);


}
