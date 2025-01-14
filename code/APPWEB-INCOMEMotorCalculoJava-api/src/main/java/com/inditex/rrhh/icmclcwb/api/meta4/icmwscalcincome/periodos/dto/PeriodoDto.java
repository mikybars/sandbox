package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class PeriodoDto implements Serializable {

  private static final long serialVersionUID = -5607507260079003307L;

  private Long id;

  @NonNull
  private LocalDate fechaInicioPeriodo;

  @NonNull
  private LocalDate fechaFinPeriodo;

}
