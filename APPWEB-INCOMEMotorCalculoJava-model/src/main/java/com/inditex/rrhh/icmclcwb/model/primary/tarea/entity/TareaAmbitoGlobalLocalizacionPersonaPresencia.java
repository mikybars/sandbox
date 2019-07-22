package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "TAREA_AMBITO_GLOBAL_LOCALIZACION_PERSONA_PRESENCIA")
@Data
public class TareaAmbitoGlobalLocalizacionPersonaPresencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_AMBITO_GLOBAL_LOCALIZACION_PERSONA_PRESENCIA")
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private Tarea tarea;
    
    @NotBlank
    @Column(name = "ID_LOCALIZACION", nullable = false)
    private String idLocalizacion;

    @NotBlank
    @Column(name = "ID_PERSONA", nullable = false)
    private String idPersona;

    @NotBlank
    @Column(name = "ID_ORIGEN", nullable = false)
    private String idOrigen;
    
    @NotBlank
    @Column(name = "ID_EMPRESA", nullable = false)
    private String idEmpresa;
}
