package com.cibertec.jpa.domain.demo.repository;

import com.cibertec.jpa.domain.demo.model.DemoModel;
import com.cibertec.jpa.infrastructure.demo.entity.DemoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DemoRepository {
    Optional<DemoModel> BuscarPorId(Long demoId);


    List<DemoModel> TodosLosDemos();

    DemoModel Guardar(DemoModel demoModel);

    Page<DemoEntity> TodosLosDemosPage(Pageable pageable);

    Page<DemoEntity>demosPage(String nombre, String esto, Pageable pageable);

}
