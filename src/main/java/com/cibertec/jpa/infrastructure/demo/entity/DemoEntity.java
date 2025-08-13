package com.cibertec.jpa.infrastructure.demo.entity;

import com.cibertec.jpa.infrastructure.shared.Auditoria;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "demo")
@Getter
@Setter
@ToString
public class DemoEntity extends Auditoria<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "demo_id")
    private Long demoId;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;

}