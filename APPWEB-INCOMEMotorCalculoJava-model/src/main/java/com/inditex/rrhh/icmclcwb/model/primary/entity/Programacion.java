package com.inditex.rrhh.icmclcwb.model.primary.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "INCOME_PROGRAMACION", schema = "DESARROLLO_RRHH")
@Data
public class Programacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROGRAMACION")
    private /* BigInteger */ Long id;

    @NotNull
    @Column(name = "HORA_PROGRAMACION", nullable = false)
    private String hora;

    @NotNull
    @Column(name = "HORA_PROGRAMACION_HUSO", nullable = false)
    private String huso;

    @NotNull
    @Column(name = "ACTIVA", nullable = false)
    private Boolean activa;

    @Column(name = "ID_ORIGEN", nullable = true)
    private String idPaisOrigen;

    @Column(name = "ID_EMPRESA", nullable = true)
    private String idEmpresa;

    @NotBlank
    @Column(name = "ID_USUARIO", nullable = false)
    private String idUsuario;

    @NotNull
    @Column(name = "FECHA_CREACION", nullable = false)
    private Date fechaCreacion;

    @Column(name = "FECHA_ULTIMA_EJECUCION", nullable = true)
    private Date fechaUltimaEjecucion;

    @NotNull
    @Column(name = "FECHA_SIGUIENTE_EJECUCION", nullable = false)
    private Date fechaSiguienteEjecucion;

}
