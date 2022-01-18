package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

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
@Table(name = "TAREA_CONFIGURACION")
@Data
public class TareaConfiguracion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_CONFIGURACION")
  private Long id;

  @NotNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

  @NotNull
  @Column(name = "FECHA_INICIO", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicio;

  @NotNull
  @Column(name = "FECHA_FIN", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFin;

  @Column(name = "COD_TIPO_HORA", nullable = true)
  private Integer codTipoHora;

  @NotNull
  @Column(name = "ICM_CK_VENTA_IMPUESTOS", nullable = false)
  private Boolean icmCkVentaImpuestos;

  @NotNull
  @Column(name = "ICM_CK_INC_IVA_EVAL_PTPO", nullable = false)
  private Boolean icmCkIncIvaEvalPtpo;

  @NotNull
  @Column(name = "ICM_CK_RED_JORNADA", nullable = false)
  private Boolean icmCkRedJornada;

}
