package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LiquidacionFilterParametersDto implements Serializable {

  private static final long serialVersionUID = -1L;

  private LocalDate fechaFin;

  private String idOrigen;

  private String idEmpresa;

  private String idEmpleado;

  private String orEmpleado;

  private LocalDate fechainicio;

}
