package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "TAREA_PREVALIDACION")
@Data
public class TareaPrevalidacion {

    @EmbeddedId
    private TareaPrevalidacionPk pk;

    @OneToOne
    @JoinColumn(name = "ID_ESTADO_TAREA_PREVALIDACION", nullable = false)
    private EstadoTareaPrevalidacion estado;
    
    @NotNull
    @Column(name = "FECHA_HORA_CREACION", nullable = false)
    private Date fechaHoraCreacion;

    @NotNull
    @Column(name = "FECHA_HORA_ACTUALIZACION", nullable = false)
    private Date fechaHoraActualizacion;
    
    @NotNull
    @Column(name = "FECHA_HORA_INICIO", nullable = false)
    private Date fechaHoraInicio;

    @Column(name = "FECHA_HORA_FIN", nullable = false)
    private Date fechaHoraFin;
    
    @NotNull
    @Column(name = "ES_ACTIVO", nullable = false)
    private Boolean activo;

}
