package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionComisionHistoricoDto implements Serializable {

  private static final long serialVersionUID = -3399439349202382151L;

  private Long id;

  @NotNull
  private Long idTarea;

  @NotBlank
  private String cclIdCodOrigen;

  @NotBlank
  private String stdIdWorkLocat;

  @NotNull
  private LocalDateTime fechaInicio;

  @NotNull
  private LocalDateTime fechaFin;

  @NotNull
  private Boolean comisionable;

}
