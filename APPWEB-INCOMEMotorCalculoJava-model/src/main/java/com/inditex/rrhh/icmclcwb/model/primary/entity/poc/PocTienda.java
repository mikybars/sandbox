package com.inditex.rrhh.icmclcwb.model.primary.entity.poc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "INCOME_POC_TIENDA", schema = "DESARROLLO_RRHH")
@Data
public class PocTienda {

	@Id
	@Column(name = "ID_TIENDA")
	private String id;

	@NotBlank
	@Column(name = "ID_PAIS", nullable = true)
	private String idPais;

	@NotBlank
	@Column(name = "ID_EMPRESA", nullable = true)
	private String idEmpresa;
	
	@NotBlank
	@Column(name = "ID_CADENA", nullable = true)
	private String idCadena;

}