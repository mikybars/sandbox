package com.inditex.rrhh.icmclcwb.model.primary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "PROGRAMACION_TIENDA", schema = "DESARROLLO_RRHH")
@Data
public class ProgramacionTienda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROGRAMACION_TIENDA")
	private /* BigInteger */ Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "ID_PROGRAMACION", referencedColumnName = "ID_PROGRAMACION" , nullable = false )
	private /* BigInteger */ Programacion programacion;

	@NotNull
	@Column(name = "ID_TIENDA", nullable = false)
	private String idTienda;

}