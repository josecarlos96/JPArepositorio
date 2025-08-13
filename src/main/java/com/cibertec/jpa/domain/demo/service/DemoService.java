package com.cibertec.jpa.domain.demo.service;

import com.cibertec.jpa.domain.demo.model.DemoModel;
import com.cibertec.jpa.infrastructure.demo.entity.DemoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DemoService {
    Optional<DemoModel> BuscarDemo(Long demoId);
    DemoModel Guardar();

    List<DemoModel> demos();

    Page<DemoEntity> demosPage(Pageable pageable);

}
