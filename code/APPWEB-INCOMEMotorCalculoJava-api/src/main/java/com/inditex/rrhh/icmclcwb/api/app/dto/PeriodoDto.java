package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeriodoDto implements Serializable {

  private static final long serialVersionUID = 6414274616668126412L;

  @NonNull
  private LocalDate fechaInicioPeriodo;

  @NonNull
  private LocalDate fechaFinPeriodo;

}
