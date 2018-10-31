package com.inditex.rrhh.icmclcwb.model.primary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "INCOME_POC_EMPLEADO", schema = "DESARROLLO_RRHH")
@Data
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EMPLEADO")
	private /* BigInteger */ Long id;

	@NotBlank
	@Column(name = "ID_PAIS", nullable = true)
	private String idPais;

	@NotBlank
	@Column(name = "ID_CADENA", nullable = true)
	private String idCadena;

}