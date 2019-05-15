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
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "TAREA_CALCULO_SECCION")
@Data
public class TareaCalculoSeccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TAREA_CALCULO_SECCION")
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
	
	@NotNull
    @Column(name = "ID_EMPLEADO", nullable = false)
    private String idEmpleado;

	@NotNull
    @Column(name = "OR_EMPLEADO", nullable = false)
    private String orEmpleado;
    
    @NotNull
    @Column(name = "ID_EMPLEADO_LOCAL", nullable = false)
    private String idEmpleadoLocal;
    
    //TODO @NotNull
    @Column(name = "ID_SECCION_EMPLEADO") //TODO nullable = false
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
    
	@Column(name = "COMISION_PORCENTAJE_SECCION_1")
	private /* BigInteger */ Double comisionPorcentaje1;

	@Column(name = "COMISION_PORCENTAJE_SECCION_2")
	private /* BigInteger */ Double comisionPorcentaje2;

	@Column(name = "COMISION_PORCENTAJE_SECCION_3")
	private /* BigInteger */ Double comisionPorcentaje3;

	@NotNull
	@Column(name = "EMPLEADO_PRESENCIA_MINUTOS_SECCION_1", nullable = false)
	private /* BigInteger */ Long empleadoPresenciaMinutos1;

	@NotNull
	@Column(name = "EMPLEADO_PRESENCIA_MINUTOS_SECCION_2", nullable = false)
	private /* BigInteger */ Long empleadoPresenciaMinutos2;

	@NotNull
	@Column(name = "EMPLEADO_PRESENCIA_MINUTOS_SECCION_3", nullable = false)
	private /* BigInteger */ Long empleadoPresenciaMinutos3;

	@NotNull
	@Column(name = "TIENDA_PRESENCIA_MINUTOS_SECCION_1", nullable = false)
	private /* BigInteger */ Long tiendaPresenciaMinutos1;

	@NotNull
	@Column(name = "TIENDA_PRESENCIA_MINUTOS_SECCION_2", nullable = false)
	private /* BigInteger */ Long tiendaPresenciaMinutos2;

	@NotNull
	@Column(name = "TIENDA_PRESENCIA_MINUTOS_SECCION_3", nullable = false)
	private /* BigInteger */ Long tiendaPresenciaMinutos3;
	
	@NotNull
	@Column(name = "TIENDA_VENTA_IMPORTE_SECCION_1", nullable = false)
	private /* BigInteger */ Double tiendaVentaImporte1;

	@NotNull
	@Column(name = "TIENDA_VENTA_IMPORTE_SECCION_2", nullable = false)
	private /* BigInteger */ Double tiendaVentaImporte2;

	@NotNull
	@Column(name = "TIENDA_VENTA_IMPORTE_SECCION_3", nullable = false)
	private /* BigInteger */ Double tiendaVentaImporte3;
	
    @NotNull
    @Column(name = "TIENDA_VENTA_IMPORTE_CON_IMPUESTOS_SECCION_1", nullable = false)
    private /* BigInteger */ Double tiendaVentaImporteConImpuestos1;

    @NotNull
    @Column(name = "TIENDA_VENTA_IMPORTE_CON_IMPUESTOS_SECCION_2", nullable = false)
    private /* BigInteger */ Double tiendaVentaImporteConImpuestos2;

    @NotNull
    @Column(name = "TIENDA_VENTA_IMPORTE_CON_IMPUESTOS_SECCION_3", nullable = false)
    private /* BigInteger */ Double tiendaVentaImporteConImpuestos3;
	
	@NotNull
	@Column(name = "IMPORTE_CON_IMPUESTOS_SECCION_1", nullable = false)
	private /* BigInteger */ Double importeConImpuestos1;

	@NotNull
	@Column(name = "IMPORTE_CON_IMPUESTOS_SECCION_2", nullable = false)
	private /* BigInteger */ Double importeConImpuestos2;

	@NotNull
	@Column(name = "IMPORTE_CON_IMPUESTOS_SECCION_3", nullable = false)
	private /* BigInteger */ Double importeConImpuestos3;
	
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
    @Column(name = "ID_TIPO_HORA", nullable = false)
    private /* BigInteger */ String idTipoHora;
	
    @Column(name = "FECHA", nullable = false)
    private Date fecha;

}