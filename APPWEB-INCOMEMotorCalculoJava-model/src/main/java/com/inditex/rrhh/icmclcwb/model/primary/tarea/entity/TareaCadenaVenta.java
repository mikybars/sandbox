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
@Table(name = "TAREA_CADENA_VENTA")
@Data
public class TareaCadenaVenta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_CADENA_VENTA")
    private Long id;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private /* BigInteger */ Tarea tarea;
    
    @NotNull
    @Column(name = "FECHA", nullable = false)
    private Date fecha;
    
    @NotNull
    @Column(name = "ID_CADENA", nullable = false)
    private String idCadena;

    @NotNull
    @Column(name = "ID_SECCION", nullable = false)
    private String idSeccion;
    
    @NotNull
    @Column(name = "IMPORTE", nullable = false)
    private /* BigInteger */ Double importe;
    
    @NotNull
    @Column(name = "IMPORTE_CON_IMPUESTOS", nullable = false)
    private /* BigInteger */ Double importeConImpuestos;

    @NotNull
    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo;
    
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_DATO", nullable = false)
    private TipoDato tipoDato;

    
}
