package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.math.BigDecimal;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConcepto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TAREA_AGRUPACION_CONFIGURACION")
@Data
public class TareaAgrupacionConfiguracion extends CommonFieldsTaskOrigin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_AGRUPACION_CONFIGURACION")
  private Long id;

  @NotNull
  @Column(name = "ICM_ID_AGRUPACION_ONLINE", nullable = false)
  private Long icmIdAgrupacionOnline;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_VENTA_CONCEPTO", nullable = false)
  private TipoVentaConcepto tipoVentaConcepto;

  @NotNull
  @Column(name = "PORCENTAJE_INCLUSION", nullable = false, precision = 23, scale = 8)
  private BigDecimal porcentajeInclusion;

}
