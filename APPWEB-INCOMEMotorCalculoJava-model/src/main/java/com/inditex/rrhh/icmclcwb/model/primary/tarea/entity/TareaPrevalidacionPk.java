package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Embeddable
@Data
public class TareaPrevalidacionPk implements Serializable {

    @Column(name = "ID_TAREA_PREVALIDACION")
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private Tarea tarea;

}
