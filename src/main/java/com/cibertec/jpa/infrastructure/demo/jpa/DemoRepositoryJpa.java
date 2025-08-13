package com.cibertec.jpa.infrastructure.demo.jpa;



import com.cibertec.jpa.infrastructure.demo.entity.DemoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DemoRepositoryJpa extends JpaRepository<DemoEntity, Long> {
    List<DemoEntity> findByNombre(String name);
    Page<DemoEntity> findByNombreContaining(String name, Pageable pageable);



}
