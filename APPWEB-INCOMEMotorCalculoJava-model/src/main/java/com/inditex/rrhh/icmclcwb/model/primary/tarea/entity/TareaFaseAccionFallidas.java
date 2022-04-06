/*
 * Copyright (c) 2022.  Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "TAREA_FASE_ACCION_FALLIDAS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TareaFaseAccionFallidas {

    @EmbeddedId
    private TareaFaseAccionFallidasPk pk;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_FALLIDAS", nullable = false)
    private TipoFallidas tipoFallidas;

    @NotNull
    @Column(name = "FALLIDAS", nullable = false)
    private String fallidas;
}
