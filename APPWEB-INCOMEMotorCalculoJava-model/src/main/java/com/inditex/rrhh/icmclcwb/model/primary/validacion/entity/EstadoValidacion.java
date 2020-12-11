package com.inditex.rrhh.icmclcwb.model.primary.validacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name = "ESTADO_VALIDACION")
@Data
public class EstadoValidacion {

    @Id
    @Column(name = "ID_ESTADO_VALIDACION")
    private Integer id;

    @NotBlank
    @Column(name = "NOMBRE", length = 32, nullable = false)
    private String nombre;

    @Column(name = "PESO", nullable = true)
    private Integer peso;

//  @Id Falta el id correspondiente meta4
//  @Column(name = "ICM_ESTADO_VALIDACION")
//  private Integer id;
}
