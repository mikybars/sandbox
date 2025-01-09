package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class TareaLocalizacionEstadoDto implements Serializable {

  private static final long serialVersionUID = 5015061072450952695L;

  private String id;

  @NonNull
  private Long idTarea;

  @NotBlank
  private String stdIdWorkLocat;

  @NotBlank
  private String cclIdOrigen;

  @NotBlank
  private String stdIdLegEnt;

  @NotBlank
  private String cclIdSeccion;

  @NotBlank
  private String icmIdEstado;

  @NonNull
  private LocalDateTime fechaInicio;

  @NonNull
  private LocalDateTime fechaFin;

  private Integer icmNumDias;

}
