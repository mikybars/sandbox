package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "TAREA_PERSONA_ESTRUCTURA")
@Data
public class TareaPersonaEstructura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_PERSONA_ESTRUCTURA")
    private Long id;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private Tarea tarea;

    @NotBlank
    @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
    private String idOrigen;

    @NotBlank
    @Column(name = "CCL_ID_SECCION_ESTRUCTURA", nullable = false, length = 4)
    private String idSeccionEstructura;

    @NotBlank
    @Column(name = "CCL_ID_SECCION_EFECTIVA", nullable = false, length = 4)
    private String idSeccionEfectiva;

    @NotBlank
    @Column(name = "STD_ID_HR", nullable = false, length = 18)
    private String idPersona;

    @NotBlank
    @Column(name = "STD_OR_HR_PERIOD", nullable = false, length = 48)
    private String orPersona;

    @NotBlank
    @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
    private String idPersonaLocal;

    @NotBlank
    @Column(name = "ICM_ID_ESTR_COMISION", nullable = false, length = 48)
    private String idEstructura;

    @NotBlank
    @Column(name = "ICM_ID_TP_CALCULO", nullable = false, length = 48)
    private String idTipoCalculo;

    @NotBlank
    @Column(name = "ICM_ID_TP_COMISION", nullable = false, length = 48)
    private String idTipoComision;

    @NotNull
    @Column(name = "VALOR", nullable = false, precision = 23,  scale = 8)
    private BigDecimal valor;
    
    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @NotNull
    @Column(name = "FECHA_FIN", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    
}
