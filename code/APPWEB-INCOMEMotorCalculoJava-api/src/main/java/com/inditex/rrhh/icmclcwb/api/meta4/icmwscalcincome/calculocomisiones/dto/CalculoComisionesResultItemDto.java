package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Commission calculation results for a single employee, containing identification and aggregated commission amounts grouped by commission
 * type, calculation type, and hour type.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculoComisionesResultItemDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String idEmpleado;

  private String idEmpresa;

  private String idLugarTrabajo;

  private List<ComisionLineDto> comisiones;

}
