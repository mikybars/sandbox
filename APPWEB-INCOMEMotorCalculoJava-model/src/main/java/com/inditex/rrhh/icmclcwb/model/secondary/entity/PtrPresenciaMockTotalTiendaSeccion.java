package com.inditex.rrhh.icmclcwb.model.secondary.entity;

import java.util.Date;

import lombok.Data;

@Data
public class PtrPresenciaMockTotalTiendaSeccion {

    private Integer tienda;

    private Date fecha;

    private Integer seccion;

    private Integer minutos;

    private Integer origen;

}
