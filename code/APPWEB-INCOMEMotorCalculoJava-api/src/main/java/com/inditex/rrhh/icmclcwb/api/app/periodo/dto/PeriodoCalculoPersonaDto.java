package com.inditex.rrhh.icmclcwb.api.app.periodo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PeriodoCalculoPersonaDto {

  private Long icmIdPeriodo;

  private Long cclIdOrigen;

  private Long stdIdLegEnt;

  private Long cclIdPerson;

  private Long stdOrHrPeriod;

  private Long idTareaActual;

  private Long idTareaUltima;

  private Long idEstado;

  private LocalDateTime fechaHoraCreacion;

  private LocalDateTime fechaHoraActualizacion;

}
