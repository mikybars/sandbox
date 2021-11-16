package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

/*
 * Copyright (c) 2021. Inditex
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Embeddable
@Data
public class TareaCalculoAjusteComisionPk implements Serializable {

  private static final long serialVersionUID = -7226320974817129391L;

  @Column(name = "ID_TAREA_CALCULO_AJUSTE_COMISION")
  private Long id;

  @NotNull
  @Column(name = "FECHA_INICIO_PERIODO", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicioPeriodo;

}
