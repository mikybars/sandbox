/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.SlrhorcomsPageRequestDto;
import lombok.Data;

@Data
public class HorarioComercialFestivosRequestDto extends SlrhorcomsPageRequestDto implements Serializable {

    private static final long serialVersionUID = -5173071057906661055L;

    private Integer idTienda;

    private Integer idCadena;

    private Integer idPais;

    private LocalDate fechaDesde;

    private LocalDate fechaHasta;

}
