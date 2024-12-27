package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "TAREA_CONFIGURACION")
@Data
public class TareaConfiguracion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_CONFIGURACION")
  private Long id;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NotBlank
  @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
  private String cclIdOrigen;

  @NonNull
  @Column(name = "FECHA_INICIO", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicio;

  @NonNull
  @Column(name = "FECHA_FIN", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFin;

  @Column(name = "COD_TIPO_HORA", nullable = true)
  private Integer codTipoHora;

  @NonNull
  @Column(name = "ICM_CK_VENTA_IMPUESTOS", nullable = false)
  private Boolean icmCkVentaImpuestos;

  @NonNull
  @Column(name = "ICM_CK_INC_IVA_EVAL_PTPO", nullable = false)
  private Boolean icmCkIncIvaEvalPtpo;

  @NonNull
  @Column(name = "ICM_CK_RED_JORNADA", nullable = false)
  private Boolean icmCkRedJornada;

}
