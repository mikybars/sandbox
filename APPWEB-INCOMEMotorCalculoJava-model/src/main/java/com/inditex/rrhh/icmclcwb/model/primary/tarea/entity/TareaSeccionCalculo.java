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
@Table(name = "TAREA_SECCION_CALCULO")
@Data
public class TareaSeccionCalculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_SECCION_CALCULO")
    private /* BigInteger */ Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private /* BigInteger */ Tarea tarea;
    
    @NotNull
    @Column(name = "ID_SOCIEDAD", nullable = false)
    private String idSociedad;

    @NotNull
    @Column(name = "ID_TIENDA", nullable = false)
    private String idTienda;
    
    @NotNull
    @Column(name = "ID_TIENDA_PRESENCIA", nullable = false)
    private String idTiendaPresencia;
    
    @NotNull
    @Column(name = "ID_TIENDA_MTU", nullable = false)
    private String idTiendaMtu;
    
    @NotNull
    @Column(name = "ID_TIENDA_PRESENCIA_MTU", nullable = false)
    private String idTiendaPresenciaMtu;
    
    @NotBlank
    @Column(name = "ID_SECCION", nullable = false)
    private String idSeccion;
    
    @NotNull
    @Column(name = "ID_EMPLEADO", nullable = false)
    private String idEmpleado;

    @NotNull
    @Column(name = "OR_EMPLEADO", nullable = false)
    private String orEmpleado;
    
    @NotNull
    @Column(name = "ID_EMPLEADO_LOCAL", nullable = false)
    private String idEmpleadoLocal;
    
    @NotNull
    @Column(name = "ID_SECCION_EMPLEADO", nullable = false)
    private String idSeccionEmpleado;

    @NotNull
    @Column(name = "ID_ESTRUCTURA", nullable = false)
    private /* BigInteger */ Long idEstructura;
    
    @NotNull
    @Column(name = "ID_ALGORITMO", nullable = false)
    private /* BigInteger */ Long idAlgoritmo;

    @NotNull
    @Column(name = "ID_TIPO_CALCULO", nullable = false)
    private /* BigInteger */ String idTipoCalculo;
    
    @NotNull
    @Column(name = "ID_TIPO_COMISION", nullable = false)
    private /* BigInteger */ String idTipoComision;

    @Column(name = "COMISION_PORCENTAJE")
    private /* BigInteger */ Double comisionPorcentaje;
    
    @NotNull
    @Column(name = "EMPLEADO_PRESENCIA_MINUTOS", nullable = false)
    private /* BigInteger */ Long empleadoPresenciaMinutos;
    
    @NotNull
    @Column(name = "TIENDA_PRESENCIA_MINUTOS", nullable = false)
    private /* BigInteger */ Long tiendaPresenciaMinutos;
    
    @NotNull
    @Column(name = "TIENDA_VENTA_IMPORTE", nullable = false)
    private /* BigInteger */ Double tiendaVentaImporte;

    @NotNull
    @Column(name = "TIENDA_VENTA_IMPORTE_CON_IMPUESTOS", nullable = false)
    private /* BigInteger */ Double tiendaVentaImporteImpuestos;


    @NotNull
    @Column(name = "IMPORTE", nullable = false)
    private /* BigInteger */ Double importe;
    
    @NotNull
    @Column(name = "IMPORTE_CON_IMPUESTOS", nullable = false)
    private /* BigInteger */ Double importeConImpuestos;
    
    @NotNull
    @Column(name = "ID_TIPO_HORA", nullable = false)
    private /* BigInteger */ String idTipoHora;
    
    @Column(name = "FECHA", nullable = false)
    private Date fecha;

}
