package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

/*
 * Copyright (c) 2022. Inditex
 */

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaFaseAccionDatoPk implements Serializable {

  @OneToOne
  @JoinColumn(name = "ID_TAREA_FASE_ACCION", nullable = false)
  private TareaFaseAccion tareaFaseAccion;

  @NonNull
  @Column(name = "DATO", nullable = false)
  private String dato;

}
