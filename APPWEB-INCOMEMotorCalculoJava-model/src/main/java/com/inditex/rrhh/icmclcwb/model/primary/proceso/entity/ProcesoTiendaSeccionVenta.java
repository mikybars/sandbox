package com.inditex.rrhh.icmclcwb.model.primary.proceso.entity;

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
@Table(name = "PROCESO_TIENDA_SECCION_VENTA")
@Data
public class ProcesoTiendaSeccionVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROCESO_TIENDA_SECCION_VENTA")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_PROCESO", nullable = false)
	private /* BigInteger */ Proceso proceso;
	
	@NotNull
	@Column(name = "FECHA", nullable = false)
	private Date fecha;
	
	@NotNull
	@Column(name = "ID_TIENDA", nullable = false)
	private String idTienda;
	
	@NotNull
	@Column(name = "ID_SECCION", nullable = false)
	private String idSeccion;
	
	@NotNull
	@Column(name = "IMPORTE", nullable = false)
	private /* BigInteger */ Double importe;

}