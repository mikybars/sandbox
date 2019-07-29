package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

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
public class TareaLocalizacionPersonaVentaPk implements Serializable {

    private static final long serialVersionUID = 3267832367383339482L;

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_LOCALIZACION_PERSONA_VENTA")
    private Long id;
    
    @NotNull
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
}
