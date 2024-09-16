package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaPersonaEstructuraDesplazamientoRealDto implements Serializable {

  private String id;

  @NotNull
  private Long idTarea;

  @NotNull
  private LocalDateTime fechaInicio;

  @NotNull
  private LocalDateTime fechaFin;

  @NotBlank
  private String cclIdOrigen;

  @NotBlank
  private String stdIdHr;

  @NotBlank
  private String stdOrHrPeriod;

  @NotBlank
  private String icmIdEstrComision;

  @NotBlank
  private String icmIdEstrComisionPadre;

  @NotBlank
  private String icmIdEstrComisionBase;

  @NotBlank
  private String icmIdEstructuraAmbito;

  @NotNull
  private LocalDate fechaInicioPeriodo;

}
