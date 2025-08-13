package com.cibertec.jpa.domain.demo.model;


import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class DemoModel {

    private Long demoId;
    private String nombre;
    private String descripcion;
    private String categoria;

}
