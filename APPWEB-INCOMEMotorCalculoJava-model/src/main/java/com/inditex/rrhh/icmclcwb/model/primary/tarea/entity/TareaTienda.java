package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

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
@Table(name = "TAREA_TIENDA")
@Data
public class TareaTienda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TAREA_TIENDA")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TAREA", nullable = false)
	private /* BigInteger */ Tarea tarea;
	
	@NotNull
	@Column(name = "ID_TIENDA", nullable = false)
	private String idTienda;

}