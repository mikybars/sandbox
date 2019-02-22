package com.inditex.rrhh.icmclcwb.model.primary.proceso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "ALGORITMO" /*, uniqueConstraints = {@UniqueConstraint(columnNames = {"ID_TIPO_COMISION", "ID_TIPO_CALCULO"}, name = "IX_ALGORITMO_02")}*/)
@Data
public class Algoritmo {

    @Id
    @Column(name = "ID_ALGORITMO")
    private /* BigInteger */ Long id;

    @NotNull
    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo;
    
    @NotBlank
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_COMISION", nullable = false)
    private TipoComision tipoComision;
    
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_CALCULO", nullable = false)
    private TipoCalculo tipoCalculo;
    
}
