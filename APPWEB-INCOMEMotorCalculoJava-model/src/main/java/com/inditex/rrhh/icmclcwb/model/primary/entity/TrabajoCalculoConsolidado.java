package com.inditex.rrhh.icmclcwb.model.primary.entity;

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
@Table(name = "INCOME_TRABAJO_CALCULO_CONSOLIDADO", schema = "DESARROLLO_RRHH")
@Data
public class TrabajoCalculoConsolidado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRABAJO_CALCULO_CONSOLIDADO")
	private /* BigInteger */ Long id;
	
	@NotNull
	@Column(name = "BLOQUEADO", nullable = false)
	private Boolean bloqueado;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TRABAJO", nullable = false)
	private /* BigInteger */ Trabajo trabajo;
	
	@NotNull
	@Column(name = "ID_EMPLEADO", nullable = false)
	private String idEmpleado;
	
	@NotNull
	@Column(name = "ID_TIENDA", nullable = false)
	private String idTienda;
	
	@NotNull
	@Column(name = "ID_ESTRUCTURA", nullable = false)
	private /* BigInteger */ Long idEstructura;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TIPO_CALCULO", nullable = false)
	private /* BigInteger */ TipoCalculo tipoCalculo;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TIPO_COMISION", nullable = false)
	private /* BigInteger */ TipoComision tipoComision;
	
	@NotNull
	@Column(name = "COMISION_PORCENTAJE_1", nullable = false)
	private /* BigInteger */ Long comisionPorcentaje1;
	
	@NotNull
	@Column(name = "COMISION_PORCENTAJE_2", nullable = false)
	private /* BigInteger */ Long comisionPorcentaje2;
	
	@NotNull
	@Column(name = "COMISION_PORCENTAJE_3", nullable = false)
	private /* BigInteger */ Long comisionPorcentaje3;
	
	@NotNull
	@Column(name = "EMPLEADO_PRESENCIA_MINUTOS_1", nullable = false)
	private /* BigInteger */ Long empleadoPresenciaMinutos1;
	
	@NotNull
	@Column(name = "EMPLEADO_PRESENCIA_MINUTOS_2", nullable = false)
	private /* BigInteger */ Long empleadoPresenciaMinutos2;
	
	@NotNull
	@Column(name = "EMPLEADO_PRESENCIA_MINUTOS_3", nullable = false)
	private /* BigInteger */ Long empleadoPresenciaMinutos3;
	
	@NotNull
	@Column(name = "TIENDA_PRESENCIA_MINUTOS_1", nullable = false)
	private /* BigInteger */ Long tiendaPresenciaMinutos1;
	
	@NotNull
	@Column(name = "TIENDA_PRESENCIA_MINUTOS_2", nullable = false)
	private /* BigInteger */ Long tiendaPresenciaMinutos2;
	
	@NotNull
	@Column(name = "TIENDA_PRESENCIA_MINUTOS_3", nullable = false)
	private /* BigInteger */ Long tiendaPresenciaMinutos3;
	
	@NotNull
	@Column(name = "TIENDA_VENTA_IMPORTE_1", nullable = false)
	private /* BigInteger */ Double tiendaVentaImporte1;
	
	@NotNull
	@Column(name = "TIENDA_VENTA_IMPORTE_2", nullable = false)
	private /* BigInteger */ Double tiendaVentaImporte2;
	
	@NotNull
	@Column(name = "TIENDA_VENTA_IMPORTE_3", nullable = false)
	private /* BigInteger */ Double tiendaVentaImporte3;
	
	@NotNull
	@Column(name = "IMPORTE_1", nullable = false)
	private /* BigInteger */ Double importe1;
	
	@NotNull
	@Column(name = "IMPORTE_2", nullable = false)
	private /* BigInteger */ Double importe2;
	
	@NotNull
	@Column(name = "IMPORTE_3", nullable = false)
	private /* BigInteger */ Double importe3;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TRABAJO_TIPO_HORA", nullable = false)
	private /* BigInteger */ TrabajoTipoHora tipoHora;

}