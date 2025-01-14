package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaDto implements Serializable {

  private static final long serialVersionUID = -7287619714621366577L;

  private Long id;

  private EstadoTareaDto estado;

  @NonNull
  private Long idTrabajo;

  private LocalDateTime fechaHoraCreacion;

  private LocalDateTime fechaHoraInicioTarea;

  private LocalDateTime fechaHoraFinTarea;

  @NotBlank
  private String idOrganization;

  @NotBlank
  private String stdIdLegEnt;

  @NonNull
  private LocalDate fechaInicioPeriodo;

  @NonNull
  private LocalDate fechaFinPeriodo;

  private List<TareaAmbitoDto> ambito;

  private List<TareaAmbitoPersonaDto> persona;

  private List<TareaAmbitoLocalizacionDto> localizacion;

}
