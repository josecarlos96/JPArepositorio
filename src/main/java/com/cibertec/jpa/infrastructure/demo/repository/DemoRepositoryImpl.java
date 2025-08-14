package com.cibertec.jpa.infrastructure.demo.repository;

import com.cibertec.jpa.domain.demo.model.DemoModel;
import com.cibertec.jpa.domain.demo.repository.DemoRepository;
import com.cibertec.jpa.infrastructure.demo.entity.DemoEntity;
import com.cibertec.jpa.infrastructure.demo.jpa.DemoRepositoryJpa;
import com.cibertec.jpa.infrastructure.demo.mapper.DemoMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DemoRepositoryImpl implements DemoRepository {

    private final DemoRepositoryJpa demoRepositoryJpa;
    private final DemoMapper demoMapper;
    @Override
    public Optional<DemoModel> BuscarPorId(Long demoId) {
        return demoRepositoryJpa.findById(demoId)
                .stream()
                .map(demoMapper::DemoMap)
                .findFirst();
    }

    @Override
    public List<DemoModel> TodosLosDemos() {
        return demoRepositoryJpa.findByNombre("Jose Carlos")
                .stream()
                .map(demoMapper::DemoMap)
                .toList();
    }

    @Override
    public DemoModel Guardar(DemoModel model) {
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setDemoId(model.getDemoId());
        demoEntity.setNombre(model.getNombre());
        demoEntity.setDescripcion(model.getDescripcion());

        DemoEntity demo = demoRepositoryJpa.save(demoEntity);
        DemoModel demoModel = new DemoModel();
        demoModel.setDemoId(demo.getDemoId());
        demoModel.setNombre(demoEntity.getNombre());
        demoModel.setDescripcion(demoEntity.getDescripcion());
        demoModel.setCategoria(demoEntity.getDescripcion());

        return demoModel;
    }

    @Override
    public Page<DemoEntity> TodosLosDemosPage(Pageable pageable) {
        return demoRepositoryJpa.findByNombreContaining("Jose Carlos",pageable);
    }

    @Override
    public Page<DemoEntity> demosPage(String nombre,String esto, Pageable pageable) {
        return demoRepositoryJpa.buscarPorNombrePaginado(nombre,esto,pageable);
    }
}
