package com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto;

/*
 * Copyright (c) 2021. Inditex
 */
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class HorarioComercialFestivosRequestDto implements Serializable {

  private static final long serialVersionUID = -5173071057906661055L;

  private List<String> idTienda;

  private LocalDate fechaDesde;

  private LocalDate fechaHasta;

}
