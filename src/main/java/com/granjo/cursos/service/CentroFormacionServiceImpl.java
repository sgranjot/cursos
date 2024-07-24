package com.granjo.cursos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.granjo.cursos.model.CentroFormacion;
import com.granjo.cursos.repository.ICentroFormacionDao;

@Service
public class CentroFormacionServiceImpl implements ICentroFormacionService {

    @Autowired
    private ICentroFormacionDao centroFormacionDao;

    @Override
    public CentroFormacion createCentro(CentroFormacion centroFormacion) {
        return centroFormacionDao.save(centroFormacion);
    }

    @Override
    public List<CentroFormacion> findAllCentros() {
        return centroFormacionDao.findAll();
    }

    @Override
    public Optional<CentroFormacion> findCentroById(Long id) {
        return centroFormacionDao.findById(id);
    }

    @Override
    public CentroFormacion updateCentro(Long id, CentroFormacion centroFormacion) {
        Optional<CentroFormacion> centroBuscado = centroFormacionDao.findById(id);
        
        if(centroBuscado.isPresent()){
            centroBuscado.get().setNombre(centroFormacion.getNombre());
            centroBuscado.get().setDireccion(centroFormacion.getDireccion());
            centroBuscado.get().setAlumnos(centroFormacion.getAlumnos());
            centroBuscado.get().setProfesores(centroFormacion.getProfesores());
            return centroFormacionDao.save(centroBuscado.get());
        }else{
            throw new IllegalArgumentException("Producto no encontrado");
        }
    }

    @Override
    public void deleteCentro(Long id) {
        centroFormacionDao.deleteById(id);
    }

}
