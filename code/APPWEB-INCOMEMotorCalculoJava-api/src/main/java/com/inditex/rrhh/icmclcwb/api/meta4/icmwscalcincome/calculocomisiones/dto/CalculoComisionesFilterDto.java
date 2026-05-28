package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Filter parameters for commission calculation searches.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculoComisionesFilterDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long idPeriodo;

  private Long idOrigen;

  private AmbitoFilter ambito;

  private List<String> empresas;

  private List<String> tiendas;

  private List<String> empleados;

}
