package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReglaValidacionExcedidoDto implements Serializable {

  private String cclIdOrigen;

  private String stdIdLegEnt;

  private String idTipoCalculo;

  private BigDecimal importe;

}
