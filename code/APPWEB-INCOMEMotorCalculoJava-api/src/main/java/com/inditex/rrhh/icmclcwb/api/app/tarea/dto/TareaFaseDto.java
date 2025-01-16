package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TareaFaseDto implements Serializable {

  private Long id;

  private Long idTarea;

  private Integer idFase;

  private EstadoTareaFaseDto estadoTareaFase;

  private LocalDateTime fechaHoraCreacion;

  private LocalDateTime fechaHoraInicio;

  private LocalDateTime fechaHoraFin;

  @NotNull
  private Boolean activo;

}
