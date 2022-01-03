package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class DesplazamientoRealDto implements Serializable {

  @NotNull
  private LocalDate fechaInicio;

  @NotNull
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
