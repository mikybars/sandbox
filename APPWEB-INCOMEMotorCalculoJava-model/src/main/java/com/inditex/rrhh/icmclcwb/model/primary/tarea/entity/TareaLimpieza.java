package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "TAREA_LIMPIEZA")
@Data
public class TareaLimpieza {

    @Id
    @Column(name = "ID_TAREA")
    private Long id;

    @NotNull
    @Column(name = "FECHA_HORA_LIMPIEZA", nullable = false)
    private Date fechaHoraLimpieza;

    @NotBlank
    @Column(name = "NOMBRE_USUARIO", nullable = false, length = 12)
    private String nombreUsuario;

    @NotNull
    @Column(name = "ES_COMPLETA", nullable = false)
    private Boolean esCompleta;

    @NotNull
    @Column(name = "ES_PARCIAL", nullable = false)
    private Boolean esParcial;

}
