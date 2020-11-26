
package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.validacion.entity.EstadoValidacion;
import com.inditex.rrhh.icmclcwb.model.primary.validacion.entity.PrioridadValidacion;
import com.inditex.rrhh.icmclcwb.model.primary.validacion.entity.TipoAccionValidacion;
import com.inditex.rrhh.icmclcwb.model.primary.validacion.entity.TipoEstadoValidacion;
import lombok.Data;

@Entity
@Table(name = "TAREA_PREVALIDACION_VALIDACION")
@Data
public class TareaPrevalidacionValidacion {

    @EmbeddedId
    private TareaPrevalidacionValidacionPk pk;
    
    @NotNull
    @Column(name = "ES_DELAY", nullable = false)
    private Boolean delay;
    
    @NotNull
    @Column(name = "REINTENTO_MAX", nullable = false)
    private Integer reintentoMax;
    
    @NotNull
    @Column(name = "REINTENTO_DELAY", nullable = false)
    private Long reintentoDelay;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TIPO_ESTADO_VALIDACION", nullable = false)
    private TipoEstadoValidacion tipoEstadoValidacion;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TIPO_ACCION_VALIDACION", nullable = false)
    private TipoAccionValidacion tipoAccionValidacion;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_PRIORIDAD_VALIDACION", nullable = false)
    private PrioridadValidacion prioridadValidacion;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_ESTADO_VALIDACION", nullable = false)
    private EstadoValidacion estadoValidacion;
    
    @Column(name = "MENSAJE", nullable = false)
    private String mensaje;
    
    @NotNull
    @Column(name = "FECHA_HORA_CREACION", nullable = false)
    private Date fechaHoraCreacion;

    @NotNull
    @Column(name = "FECHA_HORA_ACTUALIZACION", nullable = false)
    private Date fechaHoraActualizacion;
    
}
