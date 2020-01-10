package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPolitica;

import lombok.Data;

@Entity
@Table(name = "TAREA_CALCULO_AJUSTE")
@Data
public class TareaCalculoAjuste {
    
    @EmbeddedId
    private TareaCalculoAjustePk pk;
    
    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "ID_TAREA_CALCULO", referencedColumnName = "ID_TAREA_CALCULO", insertable = false, updatable = false),
        @JoinColumn(name = "FECHA_INICIO_PERIODO", referencedColumnName = "FECHA_INICIO_PERIODO", insertable = false, updatable = false) })
    private TareaCalculo tareaCalculo;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private Tarea tarea;

    @NotNull
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @NotBlank
    @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
    private String cclIdPerson;

    @NotBlank
    @Column(name = "STD_OR_HR_PERIOD", nullable = false, length = 48)
    private String stdOrHrPeriod;
    
    @NotNull
    @Column(name = "IMPORTE", nullable = false, precision = 23, scale = 8)
    private BigDecimal importe;

    @NotBlank
    @Column(name = "ICM_ID_ESTR_POLITICAS", nullable = false)
    private String idEstructuraPolitica;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TIPO_POLITICA")
    private TipoPolitica tipoPolitica;
}
