package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class DesplazamientoRealDto implements Serializable {

  @NonNull
  private LocalDate fechaInicio;

  @NonNull
  private LocalDate fechaFin;

  private String cclIdOrigen;

  private String idEstructura;

  private String idEstructuraBase;

  private String idEstructuraPadre;

  private String idEstructuraAmbito;

  @NotBlank
  private String stdIdHr;

  @NotBlank
  private String stdOrHrPeriod;

}
