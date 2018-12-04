package com.inditex.rrhh.icmclcwb.model.secondary.entity;

import java.util.Date;

import lombok.Data;

@Data
public class PtrPresenciaMockDetalle {

    private Integer tienda;

    private Integer seccion;

    private Integer persona;

    private Integer horas;

    private Date fecha;

    private Integer minutos;

    private Integer tipo;

    private Integer origen;

    private Boolean modificado_income;

    private Integer cadena;
}
