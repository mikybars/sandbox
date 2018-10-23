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
@Table(name = "INCOME_TRABAJO_TIENDA", schema = "DESARROLLO_RRHH")
@Data
public class TrabajoTienda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRABAJO_TIENDA")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TRABAJO", nullable = false)
	private /* BigInteger */ Trabajo trabajo;
	
	@NotNull
	@Column(name = "ID_TIENDA", nullable = true)
	private String idTienda;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_ESTADO_TRABAJO_TIENDA", nullable = false)
	private /* BigInteger */ EstadoTrabajoTienda estado;

}