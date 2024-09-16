package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TareaFaseAccionVentaIntegraDto {

  private Long idTareaFaseAccion;

  private Integer idTipoDato;

  private String tienda;

  private LocalDate fechaDesintegridad;

}
