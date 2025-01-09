package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "TAREA_CONFIGURACION")
@Data
public class TareaConfiguracion extends CommonFieldsTaskOrigin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_CONFIGURACION")
  private Long id;

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
