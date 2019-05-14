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

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoImporteVenta;

import lombok.Data;

@Entity
@Table(name = "TAREA_AGRUPACION_CADENA_VENTA_SECCION")
@Data
public class TareaAgrupacionCadenaVentaSeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_AGRUPACION_CADENA_VENTA_SECCION")
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
    @Column(name = "IMPORTE_SECCION_1", nullable = false)
    private /* BigInteger */ Double importe1;

    @NotNull
    @Column(name = "IMPORTE_SECCION_2", nullable = false)
    private /* BigInteger */ Double importe2;

    @NotNull
    @Column(name = "IMPORTE_SECCION_3", nullable = false)
    private /* BigInteger */ Double importe3;
    
    @NotNull
    @Column(name = "IMPORTE_CON_IMPUESTOS_SECCION_1", nullable = false)
    private /* BigInteger */ Double importeConImpuestos1;

    @NotNull
    @Column(name = "IMPORTE_CON_IMPUESTOS_SECCION_2", nullable = false)
    private /* BigInteger */ Double importeConImpuestos2;

    @NotNull
    @Column(name = "IMPORTE_CON_IMPUESTOS_SECCION_3", nullable = false)
    private /* BigInteger */ Double importeConImpuestos3;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_IMPORTE_VENTA", nullable = false)
    private TipoImporteVenta tipoImporteVenta;

}
