package com.granjo.cursos.service;

import java.util.List;

import com.granjo.cursos.dto.CentroFormacionDTO;

public interface ICentroFormacionService {

    public CentroFormacionDTO createCentro(CentroFormacionDTO centroFormacionDTO);

    public List<CentroFormacionDTO> findAllCentros ();
    
    public CentroFormacionDTO findCentroById(Long id);

    public CentroFormacionDTO updateCentro(Long id, CentroFormacionDTO centroFormacionDTO);

    public void deleteCentro(Long id);


}
