package com.granjo.cursos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.granjo.cursos.dto.CentroFormacionDTO;
import com.granjo.cursos.model.Alumno;
import com.granjo.cursos.model.CentroFormacion;
import com.granjo.cursos.model.Direccion;
import com.granjo.cursos.model.Profesor;
import com.granjo.cursos.repository.ICentroFormacionDao;
import com.granjo.cursos.util.DtoConverter;

@Service
public class CentroFormacionServiceImpl implements ICentroFormacionService {

    @Autowired
    private ICentroFormacionDao centroFormacionDao;

    @Autowired
    private DtoConverter dtoConverter;

    @Override
    public CentroFormacionDTO createCentro(CentroFormacionDTO centroFormacionDTO) {
        CentroFormacion centroFormacion = dtoConverter.convertToEntity(centroFormacionDTO, CentroFormacion.class);
        CentroFormacion centroCreado = centroFormacionDao.save(centroFormacion);
        return dtoConverter.convertToDto(centroCreado, CentroFormacionDTO.class);
    }

    @Override
    public List<CentroFormacionDTO> findAllCentros() { 
        return centroFormacionDao.findAll().stream()
            .map(centroFormacion -> dtoConverter.convertToDto(centroFormacion, CentroFormacionDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public CentroFormacionDTO findCentroById(Long id) {
        Optional<CentroFormacion>centroBuscado = centroFormacionDao.findById(id);

        if(centroBuscado.isPresent()) {
            return dtoConverter.convertToDto(centroBuscado.get(), CentroFormacionDTO.class);
        }else{
            throw new IllegalArgumentException("Centro de formación no encontrado");
        }
    }

    @Override
    public CentroFormacionDTO updateCentro(Long id, CentroFormacionDTO centroFormacionDTO) {
        Optional<CentroFormacion> centroBuscado = centroFormacionDao.findById(id);
        
        if(centroBuscado.isPresent()){
            centroBuscado.get().setNombre(centroFormacionDTO.getNombre());
            centroBuscado.get().setDireccion(dtoConverter.convertToEntity(centroFormacionDTO.getDireccion(), Direccion.class));
            centroBuscado.get().setAlumnos(centroFormacionDTO.getAlumnos()
                .stream()
                .map(alumnoDTO -> dtoConverter.convertToEntity(alumnoDTO, Alumno.class))
                .collect(Collectors.toSet()));
            centroBuscado.get().setProfesores(centroFormacionDTO.getProfesores()
                .stream()
                .map(profesorDTO -> dtoConverter.convertToEntity(profesorDTO, Profesor.class))
                .collect(Collectors.toSet()));
            CentroFormacion centroActualizado = centroFormacionDao.save(centroBuscado.get());
            return dtoConverter.convertToDto(centroActualizado, CentroFormacionDTO.class);
        }else{
            throw new IllegalArgumentException("Centro de formación no encontrado");
        }
    }

    @Override
    public void deleteCentro(Long id) {
        centroFormacionDao.deleteById(id);
    }

}
