package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

/*
 * Copyright (c) 2022. Inditex
 */
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Embeddable
@Data
public class TareaFaseAccionDatoPk implements Serializable {

  @OneToOne
  @JoinColumn(name = "ID_TAREA_FASE_ACCION", nullable = false)
  private TareaFaseAccion tareaFaseAccion;

  @NotNull
  @Column(name = "DATO", nullable = false)
  private String dato;

}
