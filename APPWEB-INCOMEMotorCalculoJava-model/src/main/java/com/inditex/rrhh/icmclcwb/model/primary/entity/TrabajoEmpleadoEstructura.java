package com.inditex.rrhh.icmclcwb.model.primary.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "INCOME_TRABAJO_EMPLEADO_ESTRUCTURA", schema = "DESARROLLO_RRHH")
@Data
public class TrabajoEmpleadoEstructura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRABAJO_EMPLEADO_ESTRUCTURA")
    private /* BigInteger */ Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TRABAJO", nullable = false)
    private /* BigInteger */ Trabajo trabajo;

    @NotNull
    @Column(name = "ID_EMPLEADO", nullable = false)
    private String idEmpleado;

    @NotNull
    @Column(name = "OR_EMPLEADO", nullable = false)
    private String orEmpleado;
    
    @NotNull
    @Column(name = "ID_EMPLEADO_LOCAL", nullable = false)
    private String idEmpleadoLocal;

    @NotNull
    @Column(name = "ID_ESTRUCTURA", nullable = false)
    private /* BigInteger */ Long idEstructura;

    @NotNull
    @Column(name = "ID_TIPO_CALCULO", nullable = false)
    private /* BigInteger */ Long idTipoCalculo;
    
    @NotNull
    @Column(name = "ID_TIPO_COMISION", nullable = false)
    private /* BigInteger */ Long idTipoComision;
    
    @Column(name = "PORCENTAJE", nullable = true)
    private /* BigInteger */ Double porcentaje;
    
    @Column(name = "PORCENTAJE_1", nullable = true)
    private /* BigInteger */ Double porcentaje1;
    
    @Column(name = "PORCENTAJE_2", nullable = true)
    private /* BigInteger */ Double porcentaje2;
    
    @Column(name = "PORCENTAJE_3", nullable = true)
    private /* BigInteger */ Double porcentaje3;

    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    private Date fechaInicio;

    @NotNull
    @Column(name = "FECHA_FIN", nullable = false)
    private Date fechaFin;

}