package com.cibertec.jpa.applicattion.demo.usecase;

import com.cibertec.jpa.domain.demo.model.DemoModel;
import com.cibertec.jpa.domain.demo.repository.DemoRepository;
import com.cibertec.jpa.domain.demo.service.DemoService;
import com.cibertec.jpa.infrastructure.demo.entity.DemoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService {

    private final DemoRepository demoRepository;

    @Override
    public Optional<DemoModel> BuscarDemo(Long demoId) {
        return demoRepository.BuscarPorId(demoId);
    }

    @Override
    public DemoModel Guardar() {
        DemoModel demo = new DemoModel();
        demo.setDemoId(5L);
        demo.setNombre("Jose Prueba");
        demo.setDescripcion("Prueba de registro");
        return demoRepository.Guardar(demo);
    }

    @Override
    public List<DemoModel> demos() {
        return demoRepository.TodosLosDemos();
    }

    @Override
    public Page<DemoEntity> demosPage(Pageable pageable) {

        return demoRepository.TodosLosDemosPage(pageable);
    }
}
