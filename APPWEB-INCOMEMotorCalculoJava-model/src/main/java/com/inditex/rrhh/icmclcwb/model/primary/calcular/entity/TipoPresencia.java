package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "TIPO_PRESENCIA")
@Data
public class TipoPresencia {

    @Id
    @Column(name = "ID_TIPO_PRESENCIA")
    private Long id;

    @NotBlank
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @NotBlank
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    @NotNull
    @Column(name = "PESO", nullable = false)
    private Long peso;

}
