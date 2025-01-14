package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

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

  @NonNull
  private Boolean activo;

}
