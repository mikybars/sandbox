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
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "TAREA_AGRUPACION_CONFIGURACION")
@Data
public class TareaAgrupacionConfiguracion extends CommonFieldsTask {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_AGRUPACION_CONFIGURACION")
  private Long id;

  @NonNull
  @Column(name = "ICM_ID_AGRUPACION_ONLINE", nullable = false)
  private Long icmIdAgrupacionOnline;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_VENTA_CONCEPTO", nullable = false)
  private TipoVentaConcepto tipoVentaConcepto;

  @NonNull
  @Column(name = "PORCENTAJE_INCLUSION", nullable = false, precision = 23, scale = 8)
  private BigDecimal porcentajeInclusion;

}
