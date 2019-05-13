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
@Table(name = "TAREA_PERIODO")
@Data
public class TareaPeriodo {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_PERIODO")
    private /* BigInteger */ Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private /* BigInteger */ Tarea tarea;
    
    @NotNull
    @Column(name = "MODIFICADO", nullable = false)
    private Boolean modificado;
    
    @NotNull
    @Column(name = "NUEVO", nullable = false)
    private Boolean nuevo;
    
    @NotNull
    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo;
    
    @NotNull
    @Column(name = "ABIERTO", nullable = false)
    private Boolean abierto;
    
    @NotNull
    @Column(name = "BORRADO", nullable = false)
    private Boolean borrado;
    
    @NotBlank
    @Column(name = "ID_ORIGEN", nullable = false)
    private String idOrigen;

    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    private Date fechaInicio;

    @NotNull
    @Column(name = "FECHA_FIN", nullable = false)
    private Date fechaFin;
    
    @NotBlank
    @Column(name = "ID_PERIODO", nullable = false)
    private String idPeriodo;
}
