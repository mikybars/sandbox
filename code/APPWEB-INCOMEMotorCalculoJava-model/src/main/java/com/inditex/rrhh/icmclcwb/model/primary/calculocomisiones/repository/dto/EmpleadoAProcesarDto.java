package com.inditex.rrhh.icmclcwb.model.primary.calculocomisiones.repository.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Intermediate DTO representing an employee to process from Query 1.
 */
@Data
@Builder
public class EmpleadoAProcesarDto {

  private String idOrigen;

  private String idPersona;

  private String stdOrHrPeriod;

  private String idEstado;

  private String idEmpresa;

  private String idLugarTrabajo;
}
