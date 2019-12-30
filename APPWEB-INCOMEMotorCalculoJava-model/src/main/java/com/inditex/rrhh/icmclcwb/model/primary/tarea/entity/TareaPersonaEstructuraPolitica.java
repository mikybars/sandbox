package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPolitica;

import lombok.Data;

@Entity
@Table(name = "TAREA_PERSONA_ESTRUCTURA_POLITICA")
@Data
public class TareaPersonaEstructuraPolitica {

    @EmbeddedId
    private TareaPersonaEstructuraPoliticaPk pk;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private Tarea tarea;

    @NotBlank
    @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
    private String cclIdOrigen;

    @NotBlank
    @Column(name = "STD_ID_HR", nullable = false, length = 18)
    private String stdIdHr;

    @NotBlank
    @Column(name = "STD_OR_HR_PERIOD", nullable = false, length = 48)
    private String stdOrHrPeriod;

    @NotBlank
    @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
    private String cclIdPerson;

    @NotBlank
    @Column(name = "ICM_ID_ESTR_POLITICAS", nullable = false)
    private String idEstructuraPolitica;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TIPO_POLITICA")
    private TipoPolitica tipoPolitica;

    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @NotNull
    @Column(name = "FECHA_FIN", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "ES_EXCLUIDO_DENOMINADOR", nullable = false)
    private Boolean excluidoDenominador;
    
    @NotBlank
    @Column(name = "ICM_ID_UNIDAD_TIEMPO", nullable = false)
    private String icmIdUnidadTiempo;
    
    @NotBlank
    @Column(name = "ICM_NUM_UNIDADES", nullable = false)
    private String numeroUnidades;
    
    @NotNull
    @Column(name = "ICM_VALOR", nullable = false, precision = 23,  scale = 8)
    private BigDecimal valor;

    @NotBlank
    @Column(name = "ICM_TRAMO", nullable = false)
    private String tramo;
    
    @Column(name = "ICM_IMPORTE", nullable = true, precision = 23,  scale = 8)
    private BigDecimal importe;
    
    @Column(name = "ICM_NUM_MESES_CALC_MEDIA", nullable = true)
    private String numMesesCalcMedia;
    
    @Column(name = "ICM_NUM_HORAS", nullable = true)
    private String numHoras;
    
    @Column(name = "ICM_ID_MOTIVO_BAJA", nullable = true)
    private String idMotivoBaja;

}
