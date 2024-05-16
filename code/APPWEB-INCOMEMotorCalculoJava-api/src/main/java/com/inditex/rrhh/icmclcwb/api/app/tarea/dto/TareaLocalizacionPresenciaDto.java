package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionPresenciaDto {

  private Long id;

  @NotNull
  private Long idTarea;

  private LocalDate fecha;

  @NotBlank
  private String cclIdCodOrigen;

  @NotBlank
  private String cclIdSeccion;

  @NotBlank
  private String cclIdCadena;

  @NotNull
  private Long minutos;

}
