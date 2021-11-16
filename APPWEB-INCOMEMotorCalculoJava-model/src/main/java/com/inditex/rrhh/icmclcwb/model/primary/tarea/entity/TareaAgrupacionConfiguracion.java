package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConcepto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TAREA_AGRUPACION_CONFIGURACION")
@Data
public class TareaAgrupacionConfiguracion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_AGRUPACION_CONFIGURACION")
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

  @NotNull
  @Column(name = "ICM_ID_AGRUPACION_ONLINE", nullable = false)
  private Long icmIdAgrupacionOnline;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_VENTA_CONCEPTO", nullable = false)
  private TipoVentaConcepto tipoVentaConcepto;

  @NotNull
  @Column(name = "FECHA_INICIO", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicio;

  @NotNull
  @Column(name = "FECHA_FIN", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFin;

  @NotNull
  @Column(name = "PORCENTAJE_INCLUSION", nullable = false, precision = 23, scale = 8)
  private BigDecimal porcentajeInclusion;

}
