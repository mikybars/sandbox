package com.inditex.rrhh.icmclcwb.model.primary.entity;

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
@Table(name = "INCOME_TRABAJO_TIENDA_PRESENCIA", schema = "DESARROLLO_RRHH")
@Data
public class TrabajoTiendaPresencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRABAJO_TIENDA_PRESENCIA")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TRABAJO", nullable = false)
	private /* BigInteger */ Trabajo trabajo;
	
	@NotNull
	@Column(name = "FECHA", nullable = false)
	private Date fecha;
	
	@NotNull
	@Column(name = "ID_TIENDA", nullable = true)
	private String idTienda;
	
	@NotNull
	@Column(name = "MINUTOS", nullable = false)
	private /* BigInteger */ Long minutos;

}