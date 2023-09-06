package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class PeriodoDto implements Serializable {

  private static final long serialVersionUID = 6414274616668126412L;

  @NotNull
  private LocalDate fechaInicioPeriodo;

  @NotNull
  private LocalDate fechaFinPeriodo;

}
