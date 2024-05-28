package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPresupuesto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConceptoChallenge;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TAREA_LOCALIZACION_PRESUPUESTO_VENTA")
@Data
public class TareaLocalizacionPresupuestoVenta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_LOCALIZACION_PRESUPUESTO_VENTA")
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotNull
  @Column(name = "FECHA_INICIO", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicio;

  @NotNull
  @Column(name = "FECHA_FIN", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFin;

  @NotBlank
  @Column(name = "CCL_ID_COD_ORIGEN", nullable = false, length = 48)
  private String cclIdCodOrigen;

  @NotBlank
  @Column(name = "CCL_ID_CADENA", nullable = false, length = 48)
  private String cclIdCadena;

  @NotBlank
  @Column(name = "CCL_ID_SECCION", nullable = false, length = 48)
  private String cclIdSeccion;

  @NotNull
  @Column(name = "ICM_ORDINAL", nullable = false)
  private Integer ordinal;

  @NotNull
  @Column(name = "IMPORTE_SIN_IMPUESTOS", nullable = false)
  private Double importeSinImpuestos;

  @NotNull
  @Column(name = "IMPORTE_CON_IMPUESTOS", nullable = false)
  private Double importeConImpuestos;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_PRESUPUESTO", nullable = false)
  private TipoPresupuesto tipoPresupuesto;

  @OneToOne
  @JoinColumn(name = "ID_TIPO_VENTA_CONCEPTO_CHALLENGE", nullable = false)
  private TipoVentaConceptoChallenge tipoVentaConceptoChallenge;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

  @ManyToOne
  @JoinColumn(name = "ID_TIPO_DATO", nullable = false)
  private TipoDato tipoDato;

  @NotNull
  @Column(name = "ES_ACTIVO", nullable = false)
  private Boolean activo;

}
