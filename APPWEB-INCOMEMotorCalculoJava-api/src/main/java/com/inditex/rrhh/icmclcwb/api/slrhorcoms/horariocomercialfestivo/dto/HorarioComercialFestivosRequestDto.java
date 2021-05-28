/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class HorarioComercialFestivosRequestDto {

    private int idTienda;

    private int idCadena;

    private int idPais;

    private Date fechaDesde;

    private Date fechaHasta;

}
