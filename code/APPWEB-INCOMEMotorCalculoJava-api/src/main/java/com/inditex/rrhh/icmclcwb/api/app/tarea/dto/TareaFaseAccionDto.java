package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TareaFaseAccionDto implements Serializable {

  private Long id;

  private Long idTareaFase;

  private Integer idAccion;

  private Integer idPuntoEjecucion;

  private Integer idEstadoTareaFaseAccion;

  private LocalDateTime fechaHoraCreacion;

  private LocalDateTime fechaHoraInicio;

  private LocalDateTime fechaHoraFin;

  private Boolean activo;

  private Integer peso;

  private Integer reaccionPeso;

}
