package com.granjo.cursos.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DtoConverter {

    private final ModelMapper modelMapper;

    public DtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <D, T> D convertToDto (T entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public <D, T> T convertToEntity (D dto, Class<T> entityClass) {
        return modelMapper.map(dto, entityClass);
    }


    


}
