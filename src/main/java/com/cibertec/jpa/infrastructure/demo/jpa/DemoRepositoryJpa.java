package com.cibertec.jpa.infrastructure.demo.jpa;



import com.cibertec.jpa.infrastructure.demo.entity.DemoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DemoRepositoryJpa extends JpaRepository<DemoEntity, Long> {
    List<DemoEntity> findByNombre(String name);
    Page<DemoEntity> findByNombreContaining(String name, Pageable pageable);

    @Query(value = """
                    select
                        demo_id
                         ,descripcion
                         ,fecha_actualizacion
                         ,fecha_crecion
                         ,nombre
                         ,usuario_actualizacion
                         ,usuario_creacion
                    from demo
                    where nombre = :name
            """,
            nativeQuery = true)
    Page<DemoEntity> buscarPorNombrePaginado(@Param("name")String name, Pageable pageable);



}
