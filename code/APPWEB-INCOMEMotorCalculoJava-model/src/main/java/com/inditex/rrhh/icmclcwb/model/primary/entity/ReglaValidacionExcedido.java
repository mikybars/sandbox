package com.inditex.rrhh.icmclcwb.model.primary.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "REGLA_VALIDACION_EXCEDIDOS", schema = "GESTION_COMISION")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ReglaValidacionExcedidoId.class)
public class ReglaValidacionExcedido {

  @Id
  @Column(name = "CCL_ID_ORIGEN")
  private String cclIdOrigen;

  @Id
  @Column(name = "STD_ID_LEG_ENT")
  private String stdIdLegEnt;

  @Id
  @Column(name = "ID_TIPO_CALCULO")
  private String idTipoCalculo;

  @Column(name = "IMPORTE")
  private BigDecimal importe;

}
