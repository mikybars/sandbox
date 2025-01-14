package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class TareaLocalizacionComisionHistoricoDto implements Serializable {

  private static final long serialVersionUID = -3399439349202382151L;

  private Long id;

  @NonNull
  private Long idTarea;

  @NotBlank
  private String cclIdCodOrigen;

  @NotBlank
  private String stdIdWorkLocat;

  @NonNull
  private LocalDateTime fechaInicio;

  @NonNull
  private LocalDateTime fechaFin;

  @NonNull
  private Boolean comisionable;

}
