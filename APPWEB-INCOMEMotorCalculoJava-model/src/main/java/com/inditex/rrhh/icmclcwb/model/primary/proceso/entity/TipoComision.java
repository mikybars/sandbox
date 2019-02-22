package com.inditex.rrhh.icmclcwb.model.primary.proceso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name = "TIPO_COMISION")
@Data
public class TipoComision {

    @Id
    @Column(name = "ID_TIPO_COMISION")
    private /* BigInteger */ Long id;

    @NotBlank
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

}
