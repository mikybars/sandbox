package com.inditex.rrhh.icmclcwb.api.app.simulacion.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SimulacionLocalizacionBandaExcepcionDto {

  @NotNull
  private String cclIdCodOrigen;

  @NotNull
  private String cclIdSeccion;

  @NotNull
  private Boolean esExcepcionBanda0;

  @NotNull
  private Boolean esExcepcionBanda1;

  @NotNull
  private Boolean esExcepcionBanda2;

}
