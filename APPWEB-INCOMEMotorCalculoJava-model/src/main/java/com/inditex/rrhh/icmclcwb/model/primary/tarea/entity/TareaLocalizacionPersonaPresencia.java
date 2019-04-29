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
@Table(name = "TAREA_LOCALIZACION_PERSONA_PRESENCIA")
@Data
public class TareaLocalizacionPersonaPresencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_LOCALIZACION_PERSONA_PRESENCIA")
    private /* BigInteger */ Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private /* BigInteger */ Tarea tarea;
    
    @NotBlank
    @Column(name = "ID_LOCALIZACION", nullable = false)
    private String idLocalizacion;

    @NotBlank
    @Column(name = "ID_PERSONA", nullable = false)
    private String idPersona;

    @NotBlank
    @Column(name = "ID_ORIGEN", nullable = false)
    private String idOrigen;
    
    
}
