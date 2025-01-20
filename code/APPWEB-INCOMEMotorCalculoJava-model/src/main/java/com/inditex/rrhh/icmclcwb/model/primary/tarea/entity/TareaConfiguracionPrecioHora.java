package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "TAREA_CONFIGURACION_PRECIO_HORA")
@Data
public class TareaConfiguracionPrecioHora extends CommonFieldsTaskOrigin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TAREA_CONFIGURACION_PRECIO_HORA")
  private Long id;

  @NotNull
  @Column(name = "ICM_CK_TP_HORA_COMIS", nullable = false)
  private Boolean icmCkTpHoraComis;

  @NotNull
  @Column(name = "ICM_CK_TP_HORA_INC_PTPO", nullable = false)
  private Boolean icmCkTpHoraIncPtpo;

}
