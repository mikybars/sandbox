package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A single aggregated commission line grouped by commission type, calculation type, and hour type.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComisionLineDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String idTipoComision;

  private String idTipoCalculo;

  private String codTipoHora;

  private Double importe;

}
