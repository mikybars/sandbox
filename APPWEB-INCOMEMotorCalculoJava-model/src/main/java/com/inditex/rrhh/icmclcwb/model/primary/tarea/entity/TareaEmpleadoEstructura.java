package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

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
@Table(name = "TAREA_EMPLEADO_ESTRUCTURA")
@Data
public class TareaEmpleadoEstructura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_EMPLEADO_ESTRUCTURA")
    private /* BigInteger */ Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private /* BigInteger */ Tarea tarea;

    @NotBlank
    @Column(name = "ID_ORIGEN", nullable = false)
    private String idOrigen;

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
    private /* BigInteger */ String idTipoCalculo;

    @NotNull
    @Column(name = "ID_TIPO_COMISION", nullable = false)
    private /* BigInteger */ String idTipoComision;

    @Column(name = "PORCENTAJE", nullable = true)
    private /* BigInteger */ Double porcentaje;

    @Column(name = "PORCENTAJE_SECCION_1", nullable = true)
    private /* BigInteger */ Double porcentaje1;

    @Column(name = "PORCENTAJE_SECCION_2", nullable = true)
    private /* BigInteger */ Double porcentaje2;

    @Column(name = "PORCENTAJE_SECCION_3", nullable = true)
    private /* BigInteger */ Double porcentaje3;

    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    private Date fechaInicio;

    @NotNull
    @Column(name = "FECHA_FIN", nullable = false)
    private Date fechaFin;

}