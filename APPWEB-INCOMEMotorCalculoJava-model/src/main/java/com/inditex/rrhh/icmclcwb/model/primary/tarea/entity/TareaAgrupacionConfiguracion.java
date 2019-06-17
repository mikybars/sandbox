package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import lombok.Data;

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
import java.util.Date;

@Entity
@Table(name = "TAREA_AGRUPACION_CONFIGURACION")
@Data
public class TareaAgrupacionConfiguracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_AGRUPACION_CONFIGURACION")
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private /* BigInteger */ Tarea tarea;

    @NotBlank
    @Column(name = "ID_ORIGEN", nullable = false)
    private String idOrigen;

    @NotNull
    @Column(name = "ID_AGRUPACION", nullable = false)
    private Long idAgrupacion;

    @NotNull
    @Column(name = "ID_CONCEPTO_VENTA", nullable = false)
    private String idConceptoVenta;

    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    private Date fechaInicio;

    @NotNull
    @Column(name = "FECHA_FIN", nullable = false)
    private Date fechaFin;

    @NotNull
    @Column(name = "PORCENTAJE_INCLUSION", nullable = false)
    private Double porcentajeInclusion;
}
