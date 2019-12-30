package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;


//@Entity
//@Table(name = "TAREA_LOCALIZACION_VENTA")
@Data
public class TareaPersonaAusenciaHistorico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_PERSONA_AUSENCIA_HISTORICO")
    private Long id;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private Tarea tarea;
    
    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @NotNull
    @Column(name = "FECHA_FIN", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    
    @NotBlank
    @Column(name = "STD_OR_HR_PERIOD", nullable = false, length = 48)
    private String stdOrHrPeriod;

    @NotBlank
    @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
    private String cclIdPerson;
    
    @NotBlank
    @Column(name = "ICM_TP_ABSENCE", nullable = false, length = 48)
    private String icmTpAbsence;

}
