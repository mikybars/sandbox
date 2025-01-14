package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class LocalizacionFicticiaHistoricoDto implements Serializable {

  private static final long serialVersionUID = -5607507260079003307L;

  @NotBlank
  private String cclIdCodOrigen;

  @NotBlank
  private String stdIdWorkLocat;

  @NotBlank
  private String stdIdCountry;

  @NotBlank
  private String cclIdOrigen;

  @NotBlank
  private String stdIdLegEnt;

  @NotBlank
  private String cclIdCadena;

  @NonNull
  private LocalDate fechaInicio;

  @NonNull
  private LocalDate fechaFin;

}
