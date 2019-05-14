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

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoImporteVenta;

import lombok.Data;

@Entity
@Table(name = "TAREA_TIENDA_SECCION_VENTA")
@Data
public class TareaTiendaSeccionVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_TIENDA_SECCION_VENTA")
    private /* BigInteger */ Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private /* BigInteger */ Tarea tarea;
    
    @NotNull
    @Column(name = "FECHA", nullable = false)
    private Date fecha;
    
    @NotNull
    @Column(name = "ID_TIENDA", nullable = false)
    private String idTienda;
    
    @NotBlank
    @Column(name = "ID_SECCION", nullable = false)
    private String idSeccion;
    
    @NotNull
    @Column(name = "IMPORTE_SECCION", nullable = false)
    private /* BigInteger */ Double importe;
    
    @NotNull
    @Column(name = "IMPORTE_CON_IMPUESTOS_SECCION", nullable = false)
    private /* BigInteger */ Double importeConImpuestosSeccion;
    
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_IMPORTE_VENTA", nullable = false)
    private TipoImporteVenta tipoImporteVenta;
    
}
