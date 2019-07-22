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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;

import lombok.Data;

@Entity
@Table(name = "TAREA_LOCALIZACION_VENTA")
@Data
public class TareaLocalizacionVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_LOCALIZACION_VENTA")
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private Tarea tarea;
    
    @NotNull
    @Column(name = "FECHA", nullable = false)
    private Date fecha;
    
    @NotNull
    @Column(name = "ID_LOCALIZACION", nullable = false)
    private String idLocalizacion;
    
    @NotNull
    @Column(name = "ID_CADENA", nullable = false)
    private String idCadena;
    
    @NotBlank
    @Column(name = "ID_SECCION", nullable = false)
    private String idSeccion;
    
    @NotNull
    @Column(name = "IMPORTE_SECCION", nullable = false)
    private Double importe;
    
    @NotNull
    @Column(name = "IMPORTE_CON_IMPUESTOS_SECCION", nullable = false)
    private Double importeConImpuestos;
    
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_DATO", nullable = false)
    private TipoDato tipoDato;

    @NotNull
    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo;
    
}
