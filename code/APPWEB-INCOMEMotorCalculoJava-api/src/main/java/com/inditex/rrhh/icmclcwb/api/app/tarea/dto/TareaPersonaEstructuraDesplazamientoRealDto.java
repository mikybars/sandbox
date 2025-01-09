package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class TareaPersonaEstructuraDesplazamientoRealDto implements Serializable {

  private String id;

  @NonNull
  private Long idTarea;

  @NonNull
  private LocalDateTime fechaInicio;

  @NonNull
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

  @NonNull
  private LocalDate fechaInicioPeriodo;

}
