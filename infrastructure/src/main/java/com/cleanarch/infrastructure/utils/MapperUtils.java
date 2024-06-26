package com.cleanarch.infrastructure.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperUtils {
    private final ModelMapper mapper;

    public MapperUtils(ModelMapper mapper) {
      this.mapper = mapper;
    }

    public <O, D> D parseObject(O origin,
                                Class<D> destination) {
      return mapper.map(origin, destination);
    }

    public <O, D> List<D> parseObjectsCollection(Collection<O> origin,
                                                 Class<D> destination) {
      return origin
          .stream()
          .map(o -> mapper.map(o, destination))
          .collect(Collectors.toList());
    }
}
