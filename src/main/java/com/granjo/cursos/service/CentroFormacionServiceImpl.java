package com.granjo.cursos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.coyote.BadRequestException;
import org.apache.logging.log4j.util.InternalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private static final Logger log = LoggerFactory.getLogger(CentroFormacionServiceImpl.class);


    @Override
    @Transactional
    public CentroFormacionDTO createCentro(CentroFormacionDTO centroFormacionDTO) {

        log.info("inicio del método CentroFormacionServiceiImpl.createCentro");

        CentroFormacion centroFormacion = dtoConverter.convertToEntity(centroFormacionDTO, CentroFormacion.class);
        CentroFormacion centroCreado;

        try {
            centroCreado = centroFormacionDao.save(centroFormacion);
            if (centroCreado != null) {
                log.info("CentroFormacion creado correctamente");
            } else {
                log.error("Error al crear CentroFormacion");
                throw new BadRequestException("Error al crear el CentroFormacion");
            }

        } catch (Exception e) {
            log.error("Error al crear CentroFormacion");
            e.getStackTrace();
            throw new InternalException("Error al crear CentroFormacion");
        }

        return dtoConverter.convertToDto(centroCreado, CentroFormacionDTO.class);
    }


    @Override
    @Transactional(readOnly=true)
    public List<CentroFormacionDTO> findAllCentros() { 

        log.info("Inicio del método CentroFormacionServiceImpl.findAllCentros");

        List<CentroFormacionDTO> centros;

        try {
            centros = centroFormacionDao.findAll()
                .stream()
                .map(centroFormacion -> dtoConverter.convertToDto(centroFormacion, CentroFormacionDTO.class))
                .collect(Collectors.toList());

        } catch (Exception e) {
            log.error("Error al consultar los Centros de Formacion");
            e.getStackTrace();
            throw new InternalException("Error al consultar los Centros de Formacion");

        }
        log.info("Consultar Centros de Formación realizado correctamente");
        return centros;
    }


    @Override
    @Transactional(readOnly=true)
    public CentroFormacionDTO findCentroById(Long id) {

        log.info("Inicio del método CentroFormacionServiceImpl.findCentroById");

        Optional<CentroFormacion> centroBuscado;

        try {
            centroBuscado = centroFormacionDao.findById(id);

            if(centroBuscado.isPresent()) {
                log.info("Centro de Formación encontrado");
                
            }else{
                log.error("Error al consultar centro de formación");
                throw new IllegalArgumentException("Centro de formación no encontrado");
            }
        } catch (Exception e) {
            log.error("Centro de formación no encontrado");
            e.getStackTrace();
            throw new InternalException("Error al consultar Centro de Formación");

        }

        return dtoConverter.convertToDto(centroBuscado.get(), CentroFormacionDTO.class); 
    }
    

    @Override
    @Transactional
    public CentroFormacionDTO updateCentro(Long id, CentroFormacionDTO centroFormacionDTO) {

        log.info("Inicio del método CentroFormacionServiceImpl.updateCentro");

        CentroFormacion centroActualizado=null;

        try {
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

                centroActualizado = centroFormacionDao.save(centroBuscado.get());

                if (centroActualizado != null) {
                    log.info("Centro de Formación actualizado");
                }else {
                    log.error("Error al actualizar el centro de formación");
                    throw new BadRequestException ("Centro de formación no actualizado");
                }
            
            }else{
                log.error ("No se encuentra el centro de formación a actualizar");
                throw new IllegalArgumentException("Centro de formación no encontrado");
            }

        } catch (Exception e) {
            log.error("Error al intentar actualizar el centro de formación");
            e.getStackTrace();
            throw new InternalException("Error al actualizar el centro de formación");
        }
        
        return dtoConverter.convertToDto(centroActualizado, CentroFormacionDTO.class);
    }


    @Override
    @Transactional
    public void deleteCentro(Long id) {

        log.info ("Inicio del método CentroFormacionServiceImpl.deleteCentro");

        try {
            centroFormacionDao.deleteById(id);
            log.info ("Centro de formación eliminado correctamente");
        }catch (Exception e) {
            log.error ("Error al intentar eliminar el centro de formacion");
            e.getStackTrace();
            throw new InternalException ("Error al intentar eliminar el centro de formación");
        }
        
    }

}
