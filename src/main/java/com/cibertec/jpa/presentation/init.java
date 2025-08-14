package com.cibertec.jpa.presentation;

import com.cibertec.jpa.domain.demo.model.DemoModel;
import com.cibertec.jpa.domain.demo.service.DemoService;
import com.cibertec.jpa.infrastructure.demo.entity.DemoEntity;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class init {

    private final DemoService demoService;


    @PostConstruct
    public void start(){
//        List<DemoModel> lista = demoService.demos();
//        lista.forEach(d-> log.info("Data sin paginar: {}", d.toString()));


//        Pageable pageable = PageRequest.of(6, 10);
//        Page<DemoEntity> paginado = demoService.demosPage(pageable);
//
//        paginado.forEach(p->  log.info("Data paginada: {}", p.toString()));

        Pageable pageable = PageRequest.of(0, 50);
        Page<DemoEntity> paginado = demoService.demosPage("Jose Carlos",pageable);

        paginado.forEach(p -> log.info("Data paginada: {}", p.toString()));

    }
}
