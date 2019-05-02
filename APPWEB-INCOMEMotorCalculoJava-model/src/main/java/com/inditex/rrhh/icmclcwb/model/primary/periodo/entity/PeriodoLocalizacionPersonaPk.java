package com.inditex.rrhh.icmclcwb.model.primary.periodo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Embeddable
@Data
public class PeriodoLocalizacionPersonaPk implements Serializable{

    private static final long serialVersionUID = 8083689014777629270L;

    @NotBlank
    @Column(name = "ID_PERIODO", nullable = false, length = 12)
    private String idPeriodo;
    
    @NotBlank
    @Column(name = "ID_ORIGEN", nullable = false, length = 12)
    private String idOrigen;
    
    @NotBlank
    @Column(name = "ID_EMPRESA", nullable = false, length = 12)
    private String idEmpresa;
    
    @NotBlank
    @Column(name = "ID_LOCALIZACION", nullable = false, length = 12)
    private String idLocalizacion;
    
    @NotBlank
    @Column(name = "ID_PERSONA", nullable = false, length = 12)
    private String idPersona;
}
