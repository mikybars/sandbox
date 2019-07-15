package com.inditex.rrhh.icmclcwb.model.primary.periodo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;

import lombok.Data;

@Entity
@Table(name = "PERIODO_CALCULO_PERSONA")
@Data
public class PeriodoCalculoPersona {

    @EmbeddedId
    private PeriodoCalculoPersonaPk pk;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA_ACTUAL", nullable = false)
    private /* BigInteger */ Tarea tareaActual;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA_ULTIMA", nullable = false)
    private /* BigInteger */ Tarea tareaUltima;
      
    @Column(name = "FECHA_CREACION", nullable = true)
    private Date fechaCreacion;

    @Column(name = "FECHA_ACTUALIZACION", nullable = true)
    private Date fechaActualizacion;
    
    @OneToOne
    @JoinColumn(name = "ID_ESTADO", nullable = false)
    private EstadoPeriodoCalculoPersona estado;
    
    @NotNull
    @Column(name = "BLOQUEADO", nullable = false)
    private Boolean bloqueado;

}
