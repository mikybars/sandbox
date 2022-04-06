/*
 * Copyright (c) 2022.  Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;

@Embeddable
@Data
public class TareaFaseAccionFallidasPk implements Serializable {

    @OneToOne
    @JoinColumn(name = "ID_TAREA_FASE_ACCION", nullable = false)
    private TareaFaseAccion tareaFaseAccion;

}
