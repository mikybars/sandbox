package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionHistoricoDto implements Serializable {

  private static final long serialVersionUID = -5607507260079003307L;

  private String id;

  @NotNull
  private Long idTarea;

  @NotBlank
  private String cclIdCodOrigen;

  @NotBlank
  private String stdIdWorkLocat;

  @NotBlank
  private String stdIdCountry;

  private String stdIdSubGeoDiv;

  @NotBlank
  private String cclIdOrigen;

  @NotBlank
  private String stdIdLegEnt;

  @NotBlank
  private String cclIdCadena;

  @NotNull
  private LocalDateTime fechaInicio;

  @NotNull
  private LocalDateTime fechaFin;

}
