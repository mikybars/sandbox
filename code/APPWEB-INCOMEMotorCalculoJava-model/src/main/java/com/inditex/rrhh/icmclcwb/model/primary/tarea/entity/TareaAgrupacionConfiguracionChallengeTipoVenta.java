package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConceptoChallenge;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TAREA_AGRUPACION_CONFIGURACION_CHALLENGE_TIPO_VENTA")
@Data
public class TareaAgrupacionConfiguracionChallengeTipoVenta extends CommonFieldsTaskOrigin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_AGRUPACION_CONFIGURACION_CHALLENGE_TIPO_VENTA")
  private Long id;

  @NotNull
  @Column(name = "ICM_ID_AGRUPACION_ONLINE", nullable = false)
  private Long icmIdAgrupacionOnline;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_VENTA_CONCEPTO_CHALLENGE", nullable = false)
  private TipoVentaConceptoChallenge tipoVentaConceptoChallenge;

}
