package com.inditex.rrhh.icmclcwb.model.primary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "INCOME_MOCK_TIENDA", schema = "DESARROLLO_RRHH")
@Data
public class Tienda {

	@Id
	@Column(name = "ID_TIENDA")
	private String id;

	@NotBlank
	@Column(name = "ID_PAIS", nullable = true)
	private String idPais;

	@NotBlank
	@Column(name = "ID_CADENA", nullable = true)
	private String idCadena;

}