package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;

import lombok.Data;

@Entity
@Table(name = "TAREA_AGRUPACION_VENTA")
@Data
public class TareaAgrupacionVenta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_AGRUPACION_VENTA")
    private Long id;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private Tarea tarea;
    
    @NotNull
    @Column(name = "FECHA", nullable = false)
    private Date fecha;
    
    @NotNull
    @Column(name = "ID_AGRUPACION", nullable = false)
    private Long idAgrupacion;

    @NotNull
    @Column(name = "ID_SECCION", nullable = false)
    private String idSeccion;

    @NotNull
    @Column(name = "ID_ORIGEN", nullable = false)
    private String idOrigen;
    
    @NotNull
    @Column(name = "IMPORTE_SIN_IMPUESTOS", nullable = false)
    private Double importeSinImpuestos;
    
    @NotNull
    @Column(name = "IMPORTE_CON_IMPUESTOS", nullable = false)
    private Double importeConImpuestos;

    @NotNull
    @Column(name = "ES_ACTIVO", nullable = false)
    private Boolean activo;
    
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_DATO", nullable = false)
    private TipoDato tipoDato;

}
