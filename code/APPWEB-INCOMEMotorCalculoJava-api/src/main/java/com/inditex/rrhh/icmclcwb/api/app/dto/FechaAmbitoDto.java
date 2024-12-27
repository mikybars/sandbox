package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
@Builder
@AllArgsConstructor
public class FechaAmbitoDto implements Serializable {

  @NonNull
  private LocalDate fechaInicio;

  @NonNull
  private LocalDate fechaFin;

}
