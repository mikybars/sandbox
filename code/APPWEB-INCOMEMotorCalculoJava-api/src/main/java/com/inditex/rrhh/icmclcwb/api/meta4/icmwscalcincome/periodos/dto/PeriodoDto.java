package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PeriodoDto implements Serializable {

  private static final long serialVersionUID = -5607507260079003307L;

  private Long id;

  @NotNull
  private LocalDate fechaInicioPeriodo;

  @NotNull
  private LocalDate fechaFinPeriodo;

}
