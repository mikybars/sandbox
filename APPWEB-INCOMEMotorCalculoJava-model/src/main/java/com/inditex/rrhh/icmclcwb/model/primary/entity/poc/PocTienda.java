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
	@Column(name = "CCL_ID_COD_ORIGEN")
	private String id;

	@Column(name = "STD_ID_WORK_LOCAT")
	private String idTiendaMeta4;

	@NotBlank
	@Column(name = "STD_ID_COUNTRY", nullable = true)
	private String idPais;

	@NotBlank
	@Column(name = "CCL_ID_ORIGEN", nullable = true)
	private String idPaisOrigen;

	@NotBlank
	@Column(name = "STD_ID_LEG_ENT", nullable = true)
	private String idEmpresa;

	@NotBlank
	@Column(name = "CCL_ID_CADENA", nullable = true)
	private String idCadena;

}