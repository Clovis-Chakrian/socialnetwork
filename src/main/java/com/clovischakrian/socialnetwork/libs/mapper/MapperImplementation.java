package com.clovischakrian.socialnetwork.libs.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MapperImplementation implements Mapper {
    private final ModelMapper mapper;

    public MapperImplementation(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public <T, U> U map(T source, Class<U> destination) {
        return mapper.map(source, destination);
    }
}
