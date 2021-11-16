package com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto;

/*
 * Copyright (c) 2021. Inditex
 */
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.SlrhorcomsPageRequestDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HorarioComercialFestivosRequestDto extends SlrhorcomsPageRequestDto implements Serializable {

  private static final long serialVersionUID = -5173071057906661055L;

  private List<String> idTienda;

  private String idCadena;

  private String idPais;

  private LocalDate fechaDesde;

  private LocalDate fechaHasta;

}
