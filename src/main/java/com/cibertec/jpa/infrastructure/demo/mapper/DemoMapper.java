package com.cibertec.jpa.infrastructure.demo.mapper;


import com.cibertec.jpa.domain.demo.model.DemoModel;
import com.cibertec.jpa.infrastructure.demo.entity.DemoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface DemoMapper {
    @Mapping(target = "demoId", source = "demoId")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "nombre", source = "nombre")
    DemoModel DemoMap(DemoEntity entity);
}

