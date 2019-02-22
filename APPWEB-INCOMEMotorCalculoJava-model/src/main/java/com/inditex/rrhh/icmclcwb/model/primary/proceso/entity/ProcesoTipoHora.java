package com.inditex.rrhh.icmclcwb.model.primary.proceso.entity;

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
@Table(name = "PROCESO_TIPO_HORA")
@Data
public class ProcesoTipoHora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROCESO_TIPO_HORA")
	private /* BigInteger */ Long id;

	@NotNull
	@Column(name = "ID_TIPO_HORA", nullable = false)
	private String idTipoHora;
	
	@Column(name = "COMISIONABLE", nullable = false)
	private Boolean comisionable;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_PROCESO", nullable = false)
	private /* BigInteger */ Proceso proceso;

}