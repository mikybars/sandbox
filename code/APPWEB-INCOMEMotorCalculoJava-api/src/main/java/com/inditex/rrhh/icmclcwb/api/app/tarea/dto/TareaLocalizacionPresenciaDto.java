package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class TareaLocalizacionPresenciaDto {

  private Long id;

  @NonNull
  private Long idTarea;

  private LocalDate fecha;

  @NotBlank
  private String cclIdCodOrigen;

  @NotBlank
  private String cclIdSeccion;

  @NotBlank
  private String cclIdCadena;

  @NonNull
  private Long minutos;

}
