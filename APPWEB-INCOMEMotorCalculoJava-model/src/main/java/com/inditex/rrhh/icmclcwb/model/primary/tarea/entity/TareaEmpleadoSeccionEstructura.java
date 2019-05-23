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
@Table(name = "TAREA_EMPLEADO_SECCION_ESTRUCTURA")
@Data
public class TareaEmpleadoSeccionEstructura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private /* BigInteger */ Tarea tarea;

    @NotBlank
    @Column(name = "ID_ORIGEN", nullable = false)
    private String idOrigen;

    @NotBlank
    @Column(name = "ID_SECCION_ESTRUCTURA", nullable = false)
    private String idSeccionEstructura;

    @NotBlank
    @Column(name = "ID_SECCION_EFECTIVA", nullable = false)
    private String idSeccionEfectiva;

    @NotBlank
    @Column(name = "ID_EMPLEADO", nullable = false)
    private String idEmpleado;

    @NotBlank
    @Column(name = "OR_EMPLEADO", nullable = false)
    private String orEmpleado;

    @NotBlank
    @Column(name = "ID_EMPLEADO_LOCAL", nullable = false)
    private String idEmpleadoLocal;

    @NotBlank
    @Column(name = "ID_ESTRUCTURA", nullable = false)
    private /* BigInteger */ String idEstructura;

    @NotBlank
    @Column(name = "ID_TIPO_CALCULO", nullable = false)
    private /* BigInteger */ String idTipoCalculo;

    @NotBlank
    @Column(name = "ID_TIPO_COMISION", nullable = false)
    private /* BigInteger */ String idTipoComision;

    @Column(name = "VALOR", nullable = true)
    private /* BigInteger */ Double valor;
    
    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    private Date fechaInicio;

    @NotNull
    @Column(name = "FECHA_FIN", nullable = false)
    private Date fechaFin;
    
}
