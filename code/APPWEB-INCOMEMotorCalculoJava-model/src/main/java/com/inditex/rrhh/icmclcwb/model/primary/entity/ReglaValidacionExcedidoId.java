package com.inditex.rrhh.icmclcwb.model.primary.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReglaValidacionExcedidoId implements Serializable {

  private String cclIdOrigen;

  private String stdIdLegEnt;

  private String idTipoCalculo;

}
