package com.inditex.rrhh.icmclcwb.model.primary.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Embeddable
@Data
public class LocalizacionFicticiaHistoricoPk implements Serializable {

    private static final long serialVersionUID = 2842083574794060608L;

    @NotBlank
    @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
    private String cclIdOrigen;

    @NotBlank
    @Column(name = "STD_ID_LEG_ENT", nullable = false, length = 48)
    private String stdIdLegEnt;
    
    @NotBlank
    @Column(name = "CCL_ID_COD_ORIGEN", nullable = false, length = 48)
    private String cclIdCodOrigen;
    
    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

}
