package com.inditex.rrhh.icmclcwb.model.primary.validacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name = "TIPO_ACCION_VALIDACION")
@Data
public class TipoAccionValidacion {

    @Id
    @Column(name = "ID_TIPO_ACCION_VALIDACION")
    private Integer id;

    @NotBlank
    @Column(name = "NOMBRE", length = 32, nullable = false)
    private String nombre;
    
//    @Id Falta el id correspondiente meta4
//    @Column(name = "ICM_ID_TIPO_ACCION_VALIDACION")
//    private Integer id;

}
