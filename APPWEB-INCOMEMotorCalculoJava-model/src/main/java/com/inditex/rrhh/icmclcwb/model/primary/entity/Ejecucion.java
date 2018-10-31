package com.inditex.rrhh.icmclcwb.model.primary.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "INCOME_POC_EJECUCION", schema = "DESARROLLO_RRHH")
@Data
public class Ejecucion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EJECUCION")
	private /* BigInteger */ Long id;

	@NotBlank
	@Column(name = "SISTEMA", nullable = true)
	private String sistema;

	@NotBlank
	@Column(name = "FECHA_CREACION", nullable = true)
	private Date fechaCreacion;
	
	@NotBlank
	@Column(name = "ID_EJECUCION_SISTEMA", nullable = true)
	private /* BigInteger */ Long idEjecucionSistema;

}