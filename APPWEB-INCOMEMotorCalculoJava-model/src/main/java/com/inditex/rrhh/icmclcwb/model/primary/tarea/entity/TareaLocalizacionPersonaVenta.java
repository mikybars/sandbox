package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;

import lombok.Data;

@Entity
@Table(name = "TAREA_LOCALIZACION_PERSONA_VENTA")
@Data
public class TareaLocalizacionPersonaVenta {

    @EmbeddedId
    private TareaLocalizacionPersonaVentaPk pk;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private Tarea tarea;
    
    @NotBlank
    @Column(name = "CCL_ID_COD_ORIGEN", nullable = false, length = 48)
    private String cclIdCodOrigen;
    
    @NotBlank
    @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
    private String cclIdPerson;
    
    @NotNull
    @Column(name = "IMPORTE_SIN_IMPUESTOS", nullable = false, precision = 23,  scale = 8)
    private BigDecimal importeSinImpuestos;
    
    @NotNull
    @Column(name = "IMPORTE_CON_IMPUESTOS", nullable = false, precision = 23,  scale = 8)
    private BigDecimal importeConImpuestos;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_DATO", nullable = false)
    private TipoDato tipoDato;

}
