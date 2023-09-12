package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto;

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
public class SincronizacionFilterParametersDto implements Serializable {

  private static final long serialVersionUID = -1L;

  private String idEmpleado;

  private String idOrigen;

  private String idEmpresa;

  private LocalDate fechaInicio;

  private LocalDate fechaFin;

}
