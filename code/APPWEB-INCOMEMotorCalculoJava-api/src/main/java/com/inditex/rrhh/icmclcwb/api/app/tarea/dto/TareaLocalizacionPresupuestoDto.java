package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TareaLocalizacionPresupuestoDto implements Serializable {

  private static final long serialVersionUID = -7248640494629053287L;

  @NonNull
  private Long idTarea;

  private LocalDate fechaInicio;

  private LocalDate fechaFin;

  @NotBlank
  private String cclIdCodOrigen;

  @NotBlank
  private String cclIdSeccion;

  @NotBlank
  private String stdIdLegEnt;

  @NotBlank
  private String cclIdOrigen;

}
