package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

/*
 * Copyright (c) 2022. Inditex
 */

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "TAREA_FASE_ACCION_DATO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TareaFaseAccionDato {

  @EmbeddedId
  private TareaFaseAccionDatoPk pk;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "ID_TIPO_DATO", nullable = false)
  private TipoDato tipoDato;

}
